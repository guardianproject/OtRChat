/*
 * Copyright 2009 Guenther Niess
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kenai.jbosh;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

final class ApacheHTTPResponse implements HTTPResponse {

    ///////////////////////////////////////////////////////////////////////////
    // Constants:

    /**
     * Name of the accept encoding header.
     */
    private static final String ACCEPT_ENCODING = "Accept-Encoding";

    /**
     * Value to use for the ACCEPT_ENCODING header.
     */
    private static final String ACCEPT_ENCODING_VAL =
            ZLIBCodec.getID() + ", " + GZIPCodec.getID();

    /**
     * Name of the character set to encode the body to/from.
     */
    private static final String CHARSET = "UTF-8";

    /**
     * Content type to use when transmitting the body data.
     */
    private static final String CONTENT_TYPE = "text/xml; charset=utf-8";

    ///////////////////////////////////////////////////////////////////////////
    // Class variables:

    /**
     * Lock used for internal synchronization.
     */
    private final Lock lock = new ReentrantLock();

    /**
     * The execution state of an HTTP process.
     */
    private final HttpContext context;

    /**
     * HttpClient instance to use to communicate.
     */
    private final HttpClient client;

    /**
     * The HTTP POST request is sent to the server.
     */
    private final HttpPost post;

    /**
     * A flag which indicates if the transmission was already done.
     */
    private boolean sent;

    /**
     * Exception to throw when the response data is attempted to be accessed,
     * or {@code null} if no exception should be thrown.
     */
    private BOSHException toThrow;

    /**
     * The response body which was received from the server or {@code null}
     * if that has not yet happened.
     */
    private AbstractBody body;

    /**
     * The HTTP response status code.
     */
    private int statusCode;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors:

    /**
     * Create and send a new request to the upstream connection manager,
     * providing deferred access to the results to be returned.
     *
     * @param client client instance to use when sending the request
     * @param cfg client configuration
     * @param params connection manager parameters from the session creation
     *  response, or {@code null} if the session has not yet been established
     * @param request body of the client request
     */
    ApacheHTTPResponse(
            final HttpClient client,
            final BOSHClientConfig cfg,
            final CMSessionParams params,
            final AbstractBody request) {
        super();
        this.client = client;
        this.context = new BasicHttpContext();
        this.post = new HttpPost(cfg.getURI().toString());
        this.sent = false;

        try {
            String xml = request.toXML();
            byte[] data = xml.getBytes(CHARSET);

            String encoding = null;
            if (cfg.isCompressionEnabled() && params != null) {
                AttrAccept accept = params.getAccept();
                if (accept != null) {
                    if (accept.isAccepted(ZLIBCodec.getID())) {
                        encoding = ZLIBCodec.getID();
                        data = ZLIBCodec.encode(data);
                    } else if (accept.isAccepted(GZIPCodec.getID())) {
                        encoding = GZIPCodec.getID();
                        data = GZIPCodec.encode(data);
                    }
                }
            }

            ByteArrayEntity entity = new ByteArrayEntity(data);
            entity.setContentType(CONTENT_TYPE);
            if (encoding != null) {
                entity.setContentEncoding(encoding);
            }
            post.setEntity(entity);
            if (cfg.isCompressionEnabled()) {
                post.setHeader(ACCEPT_ENCODING, ACCEPT_ENCODING_VAL);
            }
        } catch (Exception e) {
            toThrow = new BOSHException("Could not generate request", e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // HTTPResponse interface methods:

    /**
     * Abort the client transmission and response processing.
     */
    public void abort() {
        if (post != null) {
            post.abort();
            toThrow = new BOSHException("HTTP request aborted");
        }
    }

    /**
     * Wait for and then return the response body.
     *
     * @return body of the response
     * @throws InterruptedException if interrupted while awaiting the response
     * @throws BOSHException on communication failure
     */
    public AbstractBody getBody() throws InterruptedException, BOSHException {
        if (toThrow != null) {
            throw(toThrow);
        }
        lock.lock();
        try {
            if (!sent) {
                awaitResponse();
            }
        } finally {
            lock.unlock();
        }
        return body;
    }

    /**
     * Wait for and then return the response HTTP status code.
     *
     * @return HTTP status code of the response
     * @throws InterruptedException if interrupted while awaiting the response
     * @throws BOSHException on communication failure
     */
    public int getHTTPStatus() throws InterruptedException, BOSHException {
        if (toThrow != null) {
            throw(toThrow);
        }
        lock.lock();
        try {
            if (!sent) {
                awaitResponse();
            }
        } finally {
            lock.unlock();
        }
        return statusCode;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Package-private methods:

    /**
     * Await the response, storing the result in the instance variables of
     * this class when they arrive.
     *
     * @throws InterruptedException if interrupted while awaiting the response
     * @throws BOSHException on communication failure
     */
    private synchronized void awaitResponse() throws BOSHException {
        HttpEntity entity = null;
        try {
            HttpResponse httpResp = client.execute(post, context);
            entity = httpResp.getEntity();
            byte[] data = EntityUtils.toByteArray(entity);
            String encoding = entity.getContentEncoding() != null ?
                    entity.getContentEncoding().getValue() :
                    null;
            if (ZLIBCodec.getID().equalsIgnoreCase(encoding)) {
                data = ZLIBCodec.decode(data);
            } else if (GZIPCodec.getID().equalsIgnoreCase(encoding)) {
                data = GZIPCodec.decode(data);
            }
            body = StaticBody.fromString(new String(data, CHARSET));
            statusCode = httpResp.getStatusLine().getStatusCode();
            sent = true;
        } catch (IOException iox) {
            abort();
            toThrow = new BOSHException("Could not obtain response", iox);
            throw(toThrow);
        } catch (RuntimeException ex) {
            abort();
            throw(ex);
        }
    }
}
