/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/nathan/Desktop/Guardian/repo/gitorious/android-secim/src/org/gitian/android/im/IConnectionListener.aidl
 */
package org.gitian.android.im;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import org.gitian.android.im.engine.ImErrorInfo;
public interface IConnectionListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.gitian.android.im.IConnectionListener
{
private static final java.lang.String DESCRIPTOR = "org.gitian.android.im.IConnectionListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IConnectionListener interface,
 * generating a proxy if needed.
 */
public static org.gitian.android.im.IConnectionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.gitian.android.im.IConnectionListener))) {
return ((org.gitian.android.im.IConnectionListener)iin);
}
return new org.gitian.android.im.IConnectionListener.Stub.Proxy(obj);
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
case TRANSACTION_onStateChanged:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IImConnection _arg0;
_arg0 = org.gitian.android.im.IImConnection.Stub.asInterface(data.readStrongBinder());
int _arg1;
_arg1 = data.readInt();
org.gitian.android.im.engine.ImErrorInfo _arg2;
if ((0!=data.readInt())) {
_arg2 = org.gitian.android.im.engine.ImErrorInfo.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.onStateChanged(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onUserPresenceUpdated:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IImConnection _arg0;
_arg0 = org.gitian.android.im.IImConnection.Stub.asInterface(data.readStrongBinder());
this.onUserPresenceUpdated(_arg0);
return true;
}
case TRANSACTION_onUpdatePresenceError:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IImConnection _arg0;
_arg0 = org.gitian.android.im.IImConnection.Stub.asInterface(data.readStrongBinder());
org.gitian.android.im.engine.ImErrorInfo _arg1;
if ((0!=data.readInt())) {
_arg1 = org.gitian.android.im.engine.ImErrorInfo.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.onUpdatePresenceError(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.gitian.android.im.IConnectionListener
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
public void onStateChanged(org.gitian.android.im.IImConnection connection, int state, org.gitian.android.im.engine.ImErrorInfo error) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((connection!=null))?(connection.asBinder()):(null)));
_data.writeInt(state);
if ((error!=null)) {
_data.writeInt(1);
error.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onStateChanged, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
public void onUserPresenceUpdated(org.gitian.android.im.IImConnection connection) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((connection!=null))?(connection.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onUserPresenceUpdated, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
public void onUpdatePresenceError(org.gitian.android.im.IImConnection connection, org.gitian.android.im.engine.ImErrorInfo error) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((connection!=null))?(connection.asBinder()):(null)));
if ((error!=null)) {
_data.writeInt(1);
error.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onUpdatePresenceError, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onStateChanged = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onUserPresenceUpdated = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onUpdatePresenceError = (IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void onStateChanged(org.gitian.android.im.IImConnection connection, int state, org.gitian.android.im.engine.ImErrorInfo error) throws android.os.RemoteException;
public void onUserPresenceUpdated(org.gitian.android.im.IImConnection connection) throws android.os.RemoteException;
public void onUpdatePresenceError(org.gitian.android.im.IImConnection connection, org.gitian.android.im.engine.ImErrorInfo error) throws android.os.RemoteException;
}
