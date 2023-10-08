/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class udp_error_alert extends alert {
  private transient long swigCPtr;

  protected udp_error_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.udp_error_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(udp_error_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(udp_error_alert obj) {
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

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_udp_error_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.udp_error_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.udp_error_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.udp_error_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.udp_error_alert_message(swigCPtr, this);
  }

  public void setOperation(operation_t value) {
    libtorrent_jni.udp_error_alert_operation_set(swigCPtr, this, value.swigValue());
  }

  public operation_t getOperation() {
    return operation_t.swigToEnum(libtorrent_jni.udp_error_alert_operation_get(swigCPtr, this));
  }

  public error_code getError() {
    long cPtr = libtorrent_jni.udp_error_alert_error_get(swigCPtr, this);
    return (cPtr == 0) ? null : new error_code(cPtr, false);
  }

  public udp_endpoint get_endpoint() {
    return new udp_endpoint(libtorrent_jni.udp_error_alert_get_endpoint(swigCPtr, this), true);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.udp_error_alert_priority_get());
  public final static int alert_type = libtorrent_jni.udp_error_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.udp_error_alert_static_category_get(), false);
}
