/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/nathan/Desktop/Guardian/repo/gitorious/android-secim/src/org/gitian/android/im/plugin/IPresenceMapping.aidl
 */
package org.gitian.android.im.plugin;
import java.lang.String;
import java.util.Map;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
/**
 * The methods used to map presence value sent in protocol to predefined
 * presence status.
 */
public interface IPresenceMapping extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.gitian.android.im.plugin.IPresenceMapping
{
private static final java.lang.String DESCRIPTOR = "org.gitian.android.im.plugin.IPresenceMapping";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IPresenceMapping interface,
 * generating a proxy if needed.
 */
public static org.gitian.android.im.plugin.IPresenceMapping asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.gitian.android.im.plugin.IPresenceMapping))) {
return ((org.gitian.android.im.plugin.IPresenceMapping)iin);
}
return new org.gitian.android.im.plugin.IPresenceMapping.Stub.Proxy(obj);
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
case TRANSACTION_requireAllPresenceValues:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.requireAllPresenceValues();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPresenceStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
java.lang.String _arg1;
_arg1 = data.readString();
java.util.Map _arg2;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg2 = data.readHashMap(cl);
int _result = this.getPresenceStatus(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getOnlineStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.getOnlineStatus(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getUserAvaibility:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.getUserAvaibility(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getExtra:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.Map _result = this.getExtra(_arg0);
reply.writeNoException();
reply.writeMap(_result);
return true;
}
case TRANSACTION_getSupportedPresenceStatus:
{
data.enforceInterface(DESCRIPTOR);
int[] _result = this.getSupportedPresenceStatus();
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.gitian.android.im.plugin.IPresenceMapping
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
     * Tells if the mapping needs all presence values sent in protocol. If this
     * method returns true, the framework will pass all the presence values
     * received from the server when map to the predefined status.
     *
     * @return true if needs; false otherwise.
     */
public boolean requireAllPresenceValues() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_requireAllPresenceValues, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Map the presence values sent in protocol to the predefined presence
     * status.
     *
     * @param onlineStatus The value of presence &lt;OnlineStatus&gt; received
     *            from the server.
     * @param userAvailability The value of presence &lt;UserAvailibility&gt;
     *            received from the server.
     * @param allValues The whole presence values received from the server.
     * @return a predefined status.
     * @see #requireAllPresenceValues()
     */
public int getPresenceStatus(boolean onlineStatus, java.lang.String userAvailability, java.util.Map allValues) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((onlineStatus)?(1):(0)));
_data.writeString(userAvailability);
_data.writeMap(allValues);
mRemote.transact(Stub.TRANSACTION_getPresenceStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the value of &lt;OnlineStatus&gt; will be sent to the server when
     * update presence to the predefined status.
     *
     * @param status the predefined status.
     * @return The value of &lt;OnlineStatus&gt; will be sent to the server
     */
public boolean getOnlineStatus(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_getOnlineStatus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the value of &lt;UserAvaibility&gt; will be sent to the server when
     * update presence to the predefined status.
     *
     * @param status the predefined status.
     * @return The value of &lt;UserAvaibility&gt; will be sent to the server
     */
public java.lang.String getUserAvaibility(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_getUserAvaibility, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets the extra presence values other than &lt;OnlineStatus&gt; and
     * &lt;UserAvaibility&gt; will be sent to the server when update presence to
     * the predefined status.
     *
     * @param status the predefined status.
     * @return The extra values that will be sent to the server.
     */
public java.util.Map getExtra(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.Map _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_getExtra, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readHashMap(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Gets an array of the supported presence status. The client can only update
     * presence to the values in the array.
     *
     * @return an array of the supported presence status.
     */
public int[] getSupportedPresenceStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSupportedPresenceStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_requireAllPresenceValues = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getPresenceStatus = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getOnlineStatus = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getUserAvaibility = (IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getExtra = (IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getSupportedPresenceStatus = (IBinder.FIRST_CALL_TRANSACTION + 5);
}
/**
     * Tells if the mapping needs all presence values sent in protocol. If this
     * method returns true, the framework will pass all the presence values
     * received from the server when map to the predefined status.
     *
     * @return true if needs; false otherwise.
     */
public boolean requireAllPresenceValues() throws android.os.RemoteException;
/**
     * Map the presence values sent in protocol to the predefined presence
     * status.
     *
     * @param onlineStatus The value of presence &lt;OnlineStatus&gt; received
     *            from the server.
     * @param userAvailability The value of presence &lt;UserAvailibility&gt;
     *            received from the server.
     * @param allValues The whole presence values received from the server.
     * @return a predefined status.
     * @see #requireAllPresenceValues()
     */
public int getPresenceStatus(boolean onlineStatus, java.lang.String userAvailability, java.util.Map allValues) throws android.os.RemoteException;
/**
     * Gets the value of &lt;OnlineStatus&gt; will be sent to the server when
     * update presence to the predefined status.
     *
     * @param status the predefined status.
     * @return The value of &lt;OnlineStatus&gt; will be sent to the server
     */
public boolean getOnlineStatus(int status) throws android.os.RemoteException;
/**
     * Gets the value of &lt;UserAvaibility&gt; will be sent to the server when
     * update presence to the predefined status.
     *
     * @param status the predefined status.
     * @return The value of &lt;UserAvaibility&gt; will be sent to the server
     */
public java.lang.String getUserAvaibility(int status) throws android.os.RemoteException;
/**
     * Gets the extra presence values other than &lt;OnlineStatus&gt; and
     * &lt;UserAvaibility&gt; will be sent to the server when update presence to
     * the predefined status.
     *
     * @param status the predefined status.
     * @return The extra values that will be sent to the server.
     */
public java.util.Map getExtra(int status) throws android.os.RemoteException;
/**
     * Gets an array of the supported presence status. The client can only update
     * presence to the values in the array.
     *
     * @return an array of the supported presence status.
     */
public int[] getSupportedPresenceStatus() throws android.os.RemoteException;
}
