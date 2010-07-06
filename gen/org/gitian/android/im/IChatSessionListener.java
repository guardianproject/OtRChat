/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/nathan/Desktop/Guardian/repo/gitorious/android-secim/src/org/gitian/android/im/IChatSessionListener.aidl
 */
package org.gitian.android.im;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import org.gitian.android.im.engine.ImErrorInfo;
public interface IChatSessionListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.gitian.android.im.IChatSessionListener
{
private static final java.lang.String DESCRIPTOR = "org.gitian.android.im.IChatSessionListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IChatSessionListener interface,
 * generating a proxy if needed.
 */
public static org.gitian.android.im.IChatSessionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.gitian.android.im.IChatSessionListener))) {
return ((org.gitian.android.im.IChatSessionListener)iin);
}
return new org.gitian.android.im.IChatSessionListener.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onChatSessionCreated:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IChatSession _arg0;
_arg0 = org.gitian.android.im.IChatSession.Stub.asInterface(data.readStrongBinder());
this.onChatSessionCreated(_arg0);
return true;
}
case TRANSACTION_onChatSessionCreateError:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
org.gitian.android.im.engine.ImErrorInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = org.gitian.android.im.engine.ImErrorInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.onChatSessionCreateError(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.gitian.android.im.IChatSessionListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * This method is called when a new ChatSession is created. A ChatSession
     * will be created either when the user called explicitly or an incoming
     * message which doesn't belong to any active sessions arrived.
     */
public void onChatSessionCreated(org.gitian.android.im.IChatSession session) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((session!=null))?(session.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onChatSessionCreated, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * This method is called when it failed to create a new ChatSession.
     *
     * @param name the name of the ChatSession failed to create. It's either the
     *      name of the contact or the group.
     * @param error detail error,
     */
public void onChatSessionCreateError(java.lang.String name, org.gitian.android.im.engine.ImErrorInfo error) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
if ((error!=null)) {
_data.writeInt(1);
error.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onChatSessionCreateError, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onChatSessionCreated = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onChatSessionCreateError = (IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * This method is called when a new ChatSession is created. A ChatSession
     * will be created either when the user called explicitly or an incoming
     * message which doesn't belong to any active sessions arrived.
     */
public void onChatSessionCreated(org.gitian.android.im.IChatSession session) throws android.os.RemoteException;
/**
     * This method is called when it failed to create a new ChatSession.
     *
     * @param name the name of the ChatSession failed to create. It's either the
     *      name of the contact or the group.
     * @param error detail error,
     */
public void onChatSessionCreateError(java.lang.String name, org.gitian.android.im.engine.ImErrorInfo error) throws android.os.RemoteException;
}
