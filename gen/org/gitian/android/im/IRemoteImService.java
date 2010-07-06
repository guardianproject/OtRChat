/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/nathan/Desktop/Guardian/repo/gitorious/android-secim/src/org/gitian/android/im/IRemoteImService.aidl
 */
package org.gitian.android.im;
import java.lang.String;
import java.util.List;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
public interface IRemoteImService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.gitian.android.im.IRemoteImService
{
private static final java.lang.String DESCRIPTOR = "org.gitian.android.im.IRemoteImService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IRemoteImService interface,
 * generating a proxy if needed.
 */
public static org.gitian.android.im.IRemoteImService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.gitian.android.im.IRemoteImService))) {
return ((org.gitian.android.im.IRemoteImService)iin);
}
return new org.gitian.android.im.IRemoteImService.Stub.Proxy(obj);
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
case TRANSACTION_getAllPlugins:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getAllPlugins();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_addConnectionCreatedListener:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IConnectionCreationListener _arg0;
_arg0 = org.gitian.android.im.IConnectionCreationListener.Stub.asInterface(data.readStrongBinder());
this.addConnectionCreatedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeConnectionCreatedListener:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IConnectionCreationListener _arg0;
_arg0 = org.gitian.android.im.IConnectionCreationListener.Stub.asInterface(data.readStrongBinder());
this.removeConnectionCreatedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_createConnection:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
org.gitian.android.im.IImConnection _result = this.createConnection(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getActiveConnections:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getActiveConnections();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_dismissNotifications:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
this.dismissNotifications(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_dismissChatNotification:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.dismissChatNotification(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.gitian.android.im.IRemoteImService
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
     * Gets a list of all installed plug-ins. Each item is an ImPluginInfo.
     */
public java.util.List getAllPlugins() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllPlugins, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readArrayList(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Register a listener on the service so that the client can be notified when
     * there is a connection be created.
     */
public void addConnectionCreatedListener(org.gitian.android.im.IConnectionCreationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addConnectionCreatedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Unregister the listener on the service so that the client doesn't ware of
     * the connection creation anymore.
     */
public void removeConnectionCreatedListener(org.gitian.android.im.IConnectionCreationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeConnectionCreatedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Create a connection for the given provider.
     */
public org.gitian.android.im.IImConnection createConnection(long providerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
org.gitian.android.im.IImConnection _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(providerId);
mRemote.transact(Stub.TRANSACTION_createConnection, _data, _reply, 0);
_reply.readException();
_result = org.gitian.android.im.IImConnection.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Get all the active connections.
     */
public java.util.List getActiveConnections() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveConnections, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readArrayList(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Dismiss all notifications for an IM provider.
     */
public void dismissNotifications(long providerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(providerId);
mRemote.transact(Stub.TRANSACTION_dismissNotifications, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Dismiss notification for the specified chat.
     */
public void dismissChatNotification(long providerId, java.lang.String username) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(providerId);
_data.writeString(username);
mRemote.transact(Stub.TRANSACTION_dismissChatNotification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getAllPlugins = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addConnectionCreatedListener = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_removeConnectionCreatedListener = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_createConnection = (IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getActiveConnections = (IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_dismissNotifications = (IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_dismissChatNotification = (IBinder.FIRST_CALL_TRANSACTION + 6);
}
/**
     * Gets a list of all installed plug-ins. Each item is an ImPluginInfo.
     */
public java.util.List getAllPlugins() throws android.os.RemoteException;
/**
     * Register a listener on the service so that the client can be notified when
     * there is a connection be created.
     */
public void addConnectionCreatedListener(org.gitian.android.im.IConnectionCreationListener listener) throws android.os.RemoteException;
/**
     * Unregister the listener on the service so that the client doesn't ware of
     * the connection creation anymore.
     */
public void removeConnectionCreatedListener(org.gitian.android.im.IConnectionCreationListener listener) throws android.os.RemoteException;
/**
     * Create a connection for the given provider.
     */
public org.gitian.android.im.IImConnection createConnection(long providerId) throws android.os.RemoteException;
/**
     * Get all the active connections.
     */
public java.util.List getActiveConnections() throws android.os.RemoteException;
/**
     * Dismiss all notifications for an IM provider.
     */
public void dismissNotifications(long providerId) throws android.os.RemoteException;
/**
     * Dismiss notification for the specified chat.
     */
public void dismissChatNotification(long providerId, java.lang.String username) throws android.os.RemoteException;
}
