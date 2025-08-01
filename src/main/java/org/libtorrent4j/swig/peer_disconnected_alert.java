/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class peer_disconnected_alert extends peer_alert {
  private transient long swigCPtr;

  protected peer_disconnected_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.peer_disconnected_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(peer_disconnected_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(peer_disconnected_alert obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings({"deprecation", "removal"})
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_peer_disconnected_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.peer_disconnected_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.peer_disconnected_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.peer_disconnected_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.peer_disconnected_alert_message(swigCPtr, this);
  }

  public socket_type_t getSocket_type() {
    return socket_type_t.swigToEnum(libtorrent_jni.peer_disconnected_alert_socket_type_get(swigCPtr, this));
  }

  public operation_t getOp() {
    return operation_t.swigToEnum(libtorrent_jni.peer_disconnected_alert_op_get(swigCPtr, this));
  }

  public error_code getError() {
    long cPtr = libtorrent_jni.peer_disconnected_alert_error_get(swigCPtr, this);
    return (cPtr == 0) ? null : new error_code(cPtr, false);
  }

  public close_reason_t getReason() {
    return close_reason_t.swigToEnum(libtorrent_jni.peer_disconnected_alert_reason_get(swigCPtr, this));
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.peer_disconnected_alert_priority_get());
  public final static int alert_type = libtorrent_jni.peer_disconnected_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.peer_disconnected_alert_static_category_get(), false);
}
