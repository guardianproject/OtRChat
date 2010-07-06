/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/nathan/Desktop/Guardian/repo/gitorious/android-secim/src/org/gitian/android/im/ISubscriptionListener.aidl
 */
package org.gitian.android.im;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import org.gitian.android.im.engine.Contact;
public interface ISubscriptionListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.gitian.android.im.ISubscriptionListener
{
private static final java.lang.String DESCRIPTOR = "org.gitian.android.im.ISubscriptionListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an ISubscriptionListener interface,
 * generating a proxy if needed.
 */
public static org.gitian.android.im.ISubscriptionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.gitian.android.im.ISubscriptionListener))) {
return ((org.gitian.android.im.ISubscriptionListener)iin);
}
return new org.gitian.android.im.ISubscriptionListener.Stub.Proxy(obj);
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
case TRANSACTION_onSubScriptionRequest:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.engine.Contact _arg0;
if ((0!=data.readInt())) {
_arg0 = org.gitian.android.im.engine.Contact.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onSubScriptionRequest(_arg0);
return true;
}
case TRANSACTION_onSubscriptionApproved:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onSubscriptionApproved(_arg0);
return true;
}
case TRANSACTION_onSubscriptionDeclined:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onSubscriptionDeclined(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.gitian.android.im.ISubscriptionListener
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
     * Called when:
     *  <ul>
     *  <li> the request a contact has sent to client
     *  </ul>
     *
     * @see org.gitian.android.im.engine.SubscriptionRequestListener#onSubScriptionRequest(Contact from)
     */
public void onSubScriptionRequest(org.gitian.android.im.engine.Contact from) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((from!=null)) {
_data.writeInt(1);
from.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onSubScriptionRequest, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Called when the request is approved by user.
     *
     * @see org.gitian.android.im.engine.SubscriptionRequestListener#onSubscriptionApproved(String contact)
     */
public void onSubscriptionApproved(java.lang.String contact) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(contact);
mRemote.transact(Stub.TRANSACTION_onSubscriptionApproved, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Called when a subscription request is declined.
     *
     * @see org.gitian.android.im.engine.ContactListListener#onSubscriptionDeclined(String contact)
     */
public void onSubscriptionDeclined(java.lang.String contact) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(contact);
mRemote.transact(Stub.TRANSACTION_onSubscriptionDeclined, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onSubScriptionRequest = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onSubscriptionApproved = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onSubscriptionDeclined = (IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
     * Called when:
     *  <ul>
     *  <li> the request a contact has sent to client
     *  </ul>
     *
     * @see org.gitian.android.im.engine.SubscriptionRequestListener#onSubScriptionRequest(Contact from)
     */
public void onSubScriptionRequest(org.gitian.android.im.engine.Contact from) throws android.os.RemoteException;
/**
     * Called when the request is approved by user.
     *
     * @see org.gitian.android.im.engine.SubscriptionRequestListener#onSubscriptionApproved(String contact)
     */
public void onSubscriptionApproved(java.lang.String contact) throws android.os.RemoteException;
/**
     * Called when a subscription request is declined.
     *
     * @see org.gitian.android.im.engine.ContactListListener#onSubscriptionDeclined(String contact)
     */
public void onSubscriptionDeclined(java.lang.String contact) throws android.os.RemoteException;
}
