// GenericsNote: Converted.
/*
 *  Copyright 2003-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.jivesoftware.smack.util.collections;

import java.util.Iterator;

/**
 * Defines an iterator that operates over a <code>Map</code>.
 * <p/>
 * This iterator is a special version designed for maps. It can be more
 * efficient to use this rather than an entry set iterator where the option
 * is available, and it is certainly more convenient.
 * <p/>
 * A map that provides this interface may not hold the data internally using
 * Map Entry objects, thus this interface can avoid lots of object creation.
 * <p/>
 * In use, this iterator iterates through the keys in the map. After each call
 * to <code>next()</code>, the <code>getValue()</code> method provides direct
 * access to the value. The value can also be set using <code>setValue()</code>.
 * <pre>
 * MapIterator it = map.mapIterator();
 * while (it.hasNext()) {
 *   Object key = it.next();
 *   Object value = it.getValue();
 *   it.setValue(newValue);
 * }
 * </pre>
 *
 * @author Matt Hall, John Watkinson, Stephen Colebourne
 * @version $Revision: 1.1 $ $Date: 2005/10/11 17:05:19 $
 * @since Commons Collections 3.0
 */
public interface MapIterator <K,V> extends Iterator<K> {

    /**
     * Checks to see if there are more entries still to be iterated.
     *
     * @return <code>true</code> if the iterator has more elements
     */
    boolean hasNext();

    /**
     * Gets the next <em>key</em> from the <code>Map</code>.
     *
     * @return the next key in the iteration
     * @throws java.util.NoSuchElementException
     *          if the iteration is finished
     */
    K next();

    //-----------------------------------------------------------------------
    /**
     * Gets the current key, which is the key returned by the last call
     * to <code>next()</code>.
     *
     * @return the current key
     * @throws IllegalStateException if <code>next()</code> has not yet been called
     */
    K getKey();

    /**
     * Gets the current value, which is the value associated with the last key
     * returned by <code>next()</code>.
     *
     * @return the current value
     * @throws IllegalStateException if <code>next()</code> has not yet been called
     */
    V getValue();

    //-----------------------------------------------------------------------
    /**
     * Removes the last returned key from the underlying <code>Map</code> (optional operation).
     * <p/>
     * This method can be called once per call to <code>next()</code>.
     *
     * @throws UnsupportedOperationException if remove is not supported by the map
     * @throws IllegalStateException         if <code>next()</code> has not yet been called
     * @throws IllegalStateException         if <code>remove()</code> has already been called
     *                                       since the last call to <code>next()</code>
     */
    void remove();

    /**
     * Sets the value associated with the current key (optional operation).
     *
     * @param value the new value
     * @return the previous value
     * @throws UnsupportedOperationException if setValue is not supported by the map
     * @throws IllegalStateException         if <code>next()</code> has not yet been called
     * @throws IllegalStateException         if <code>remove()</code> has been called since the
     *                                       last call to <code>next()</code>
     */
    V setValue(V value);

}
