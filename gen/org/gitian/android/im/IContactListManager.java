/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/nathan/Desktop/Guardian/repo/gitorious/android-secim/src/org/gitian/android/im/IContactListManager.aidl
 */
package org.gitian.android.im;
import java.lang.String;
import java.util.List;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import java.util.List;
public interface IContactListManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.gitian.android.im.IContactListManager
{
private static final java.lang.String DESCRIPTOR = "org.gitian.android.im.IContactListManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IContactListManager interface,
 * generating a proxy if needed.
 */
public static org.gitian.android.im.IContactListManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.gitian.android.im.IContactListManager))) {
return ((org.gitian.android.im.IContactListManager)iin);
}
return new org.gitian.android.im.IContactListManager.Stub.Proxy(obj);
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
case TRANSACTION_registerContactListListener:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IContactListListener _arg0;
_arg0 = org.gitian.android.im.IContactListListener.Stub.asInterface(data.readStrongBinder());
this.registerContactListListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterContactListListener:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.IContactListListener _arg0;
_arg0 = org.gitian.android.im.IContactListListener.Stub.asInterface(data.readStrongBinder());
this.unregisterContactListListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerSubscriptionListener:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.ISubscriptionListener _arg0;
_arg0 = org.gitian.android.im.ISubscriptionListener.Stub.asInterface(data.readStrongBinder());
this.registerSubscriptionListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterSubscriptionListener:
{
data.enforceInterface(DESCRIPTOR);
org.gitian.android.im.ISubscriptionListener _arg0;
_arg0 = org.gitian.android.im.ISubscriptionListener.Stub.asInterface(data.readStrongBinder());
this.unregisterSubscriptionListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getContactLists:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getContactLists();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_getContactList:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
org.gitian.android.im.IContactList _result = this.getContactList(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_createContactList:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<org.gitian.android.im.engine.Contact> _arg1;
_arg1 = data.createTypedArrayList(org.gitian.android.im.engine.Contact.CREATOR);
int _result = this.createContactList(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_deleteContactList:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.deleteContactList(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_removeContact:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.removeContact(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_approveSubscription:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.approveSubscription(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_declineSubscription:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.declineSubscription(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_blockContact:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.blockContact(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_unBlockContact:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.unBlockContact(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isBlocked:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isBlocked(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_loadContactLists:
{
data.enforceInterface(DESCRIPTOR);
this.loadContactLists();
reply.writeNoException();
return true;
}
case TRANSACTION_getState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.gitian.android.im.IContactListManager
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
public void registerContactListListener(org.gitian.android.im.IContactListListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerContactListListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void unregisterContactListListener(org.gitian.android.im.IContactListListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterContactListListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void registerSubscriptionListener(org.gitian.android.im.ISubscriptionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerSubscriptionListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void unregisterSubscriptionListener(org.gitian.android.im.ISubscriptionListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterSubscriptionListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Gets all the contact lists of this account.
     */
public java.util.List getContactLists() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getContactLists, _data, _reply, 0);
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
     * Gets a contact list with specific name, return null if no contact list is found.
     */
public org.gitian.android.im.IContactList getContactList(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
org.gitian.android.im.IContactList _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_getContactList, _data, _reply, 0);
_reply.readException();
_result = org.gitian.android.im.IContactList.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Creates a contact list with given name and a list of initial contacts.
     *
     * @param name the name of the list to create.
     * @param contacts a list of contacts will be added to the new contact list, can be null.
     */
public int createContactList(java.lang.String name, java.util.List<org.gitian.android.im.engine.Contact> contacts) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeTypedList(contacts);
mRemote.transact(Stub.TRANSACTION_createContactList, _data, _reply, 0);
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
     * Deletes a contact list with given name.
     *
     * @param name the name of the list to delete.
     */
public int deleteContactList(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_deleteContactList, _data, _reply, 0);
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
     * Removes a contact from all contact lists. Note the temporary contacts
     * can only be removed by this method.
     *
     * @param address the address of the contact to be removed.
     */
public int removeContact(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_removeContact, _data, _reply, 0);
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
     * Approves a subscription request from another user.
     */
public void approveSubscription(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_approveSubscription, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Declines a subscription request from another user.
     */
public void declineSubscription(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_declineSubscription, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Blocks a contact. The ContactListListener will be notified when the contact is blocked
     * successfully or any error occurs.
     *
     * @param address the address of the contact to block.
     * @return ILLEGAL_CONTACT_LIST_MANAGER_STATE if contact lists is not loaded.
     */
public int blockContact(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_blockContact, _data, _reply, 0);
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
     * Unblocks a contact.The ContactListListener will be notified when the contact is blocked
     * successfully or any error occurs.
     *
     * @param address the address of the contact to unblock.
     * @return ILLEGAL_CONTACT_LIST_MANAGER_STATE if contact lists is not loaded.
     */
public int unBlockContact(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_unBlockContact, _data, _reply, 0);
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
     * Tells if a certain contact is blocked.
     *
     * @param address the address of the contact.
     * @return true if it's blocked; false otherwise.
     */
public boolean isBlocked(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_isBlocked, _data, _reply, 0);
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
     * Explicitly load contact lists from the server. The user only needs to call this method if
     * autoLoadContacts is false when login; otherwise, contact lists will be downloaded from the
     * server automatically after login.
     */
public void loadContactLists() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_loadContactLists, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Gets the state of the manager.
     *
     * @return the state of the manager.
     */
public int getState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_registerContactListListener = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregisterContactListListener = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_registerSubscriptionListener = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_unregisterSubscriptionListener = (IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getContactLists = (IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getContactList = (IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_createContactList = (IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_deleteContactList = (IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_removeContact = (IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_approveSubscription = (IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_declineSubscription = (IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_blockContact = (IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_unBlockContact = (IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_isBlocked = (IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_loadContactLists = (IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getState = (IBinder.FIRST_CALL_TRANSACTION + 15);
}
public void registerContactListListener(org.gitian.android.im.IContactListListener listener) throws android.os.RemoteException;
public void unregisterContactListListener(org.gitian.android.im.IContactListListener listener) throws android.os.RemoteException;
public void registerSubscriptionListener(org.gitian.android.im.ISubscriptionListener listener) throws android.os.RemoteException;
public void unregisterSubscriptionListener(org.gitian.android.im.ISubscriptionListener listener) throws android.os.RemoteException;
/**
     * Gets all the contact lists of this account.
     */
public java.util.List getContactLists() throws android.os.RemoteException;
/**
     * Gets a contact list with specific name, return null if no contact list is found.
     */
public org.gitian.android.im.IContactList getContactList(java.lang.String name) throws android.os.RemoteException;
/**
     * Creates a contact list with given name and a list of initial contacts.
     *
     * @param name the name of the list to create.
     * @param contacts a list of contacts will be added to the new contact list, can be null.
     */
public int createContactList(java.lang.String name, java.util.List<org.gitian.android.im.engine.Contact> contacts) throws android.os.RemoteException;
/**
     * Deletes a contact list with given name.
     *
     * @param name the name of the list to delete.
     */
public int deleteContactList(java.lang.String name) throws android.os.RemoteException;
/**
     * Removes a contact from all contact lists. Note the temporary contacts
     * can only be removed by this method.
     *
     * @param address the address of the contact to be removed.
     */
public int removeContact(java.lang.String address) throws android.os.RemoteException;
/**
     * Approves a subscription request from another user.
     */
public void approveSubscription(java.lang.String address) throws android.os.RemoteException;
/**
     * Declines a subscription request from another user.
     */
public void declineSubscription(java.lang.String address) throws android.os.RemoteException;
/**
     * Blocks a contact. The ContactListListener will be notified when the contact is blocked
     * successfully or any error occurs.
     *
     * @param address the address of the contact to block.
     * @return ILLEGAL_CONTACT_LIST_MANAGER_STATE if contact lists is not loaded.
     */
public int blockContact(java.lang.String address) throws android.os.RemoteException;
/**
     * Unblocks a contact.The ContactListListener will be notified when the contact is blocked
     * successfully or any error occurs.
     *
     * @param address the address of the contact to unblock.
     * @return ILLEGAL_CONTACT_LIST_MANAGER_STATE if contact lists is not loaded.
     */
public int unBlockContact(java.lang.String address) throws android.os.RemoteException;
/**
     * Tells if a certain contact is blocked.
     *
     * @param address the address of the contact.
     * @return true if it's blocked; false otherwise.
     */
public boolean isBlocked(java.lang.String address) throws android.os.RemoteException;
/**
     * Explicitly load contact lists from the server. The user only needs to call this method if
     * autoLoadContacts is false when login; otherwise, contact lists will be downloaded from the
     * server automatically after login.
     */
public void loadContactLists() throws android.os.RemoteException;
/**
     * Gets the state of the manager.
     *
     * @return the state of the manager.
     */
public int getState() throws android.os.RemoteException;
}
