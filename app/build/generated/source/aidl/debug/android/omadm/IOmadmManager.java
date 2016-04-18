/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\work\\Service\\app\\src\\main\\aidl\\android\\omadm\\IOmadmManager.aidl
 */
package android.omadm;
/** @hide */
public interface IOmadmManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.omadm.IOmadmManager
{
private static final java.lang.String DESCRIPTOR = "android.omadm.IOmadmManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an android.omadm.IOmadmManager interface,
 * generating a proxy if needed.
 */
public static android.omadm.IOmadmManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.omadm.IOmadmManager))) {
return ((android.omadm.IOmadmManager)iin);
}
return new android.omadm.IOmadmManager.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
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
case TRANSACTION_getDeviceId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDeviceId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setWifiEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.setWifiEnabled(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_sendNotification:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.sendNotification(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pal_system_dev_id_get:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.pal_system_dev_id_get();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_pal_test_get_int:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.pal_test_get_int();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_pal_system_dmv_get:
{
data.enforceInterface(DESCRIPTOR);
double _result = this.pal_system_dmv_get();
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
case TRANSACTION_concat:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _result = this.concat(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.omadm.IOmadmManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getDeviceId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setWifiEnabled(boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setWifiEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean sendNotification(java.lang.String title, java.lang.String message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(title);
_data.writeString(message);
mRemote.transact(Stub.TRANSACTION_sendNotification, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String pal_system_dev_id_get() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pal_system_dev_id_get, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int pal_test_get_int() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pal_test_get_int, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public double pal_system_dmv_get() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pal_system_dmv_get, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String concat(java.lang.String v1, java.lang.String v2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(v1);
_data.writeString(v2);
mRemote.transact(Stub.TRANSACTION_concat, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getDeviceId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setWifiEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_sendNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_pal_system_dev_id_get = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_pal_test_get_int = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_pal_system_dmv_get = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_concat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
}
public java.lang.String getDeviceId() throws android.os.RemoteException;
public boolean setWifiEnabled(boolean enable) throws android.os.RemoteException;
public boolean sendNotification(java.lang.String title, java.lang.String message) throws android.os.RemoteException;
public java.lang.String pal_system_dev_id_get() throws android.os.RemoteException;
public int pal_test_get_int() throws android.os.RemoteException;
public double pal_system_dmv_get() throws android.os.RemoteException;
public java.lang.String concat(java.lang.String v1, java.lang.String v2) throws android.os.RemoteException;
}
