/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class add_torrent_alert extends torrent_alert {
  private transient long swigCPtr;

  protected add_torrent_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.add_torrent_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(add_torrent_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(add_torrent_alert obj) {
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
        libtorrent_jni.delete_add_torrent_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.add_torrent_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.add_torrent_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.add_torrent_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.add_torrent_alert_message(swigCPtr, this);
  }

  public void setParams(add_torrent_params value) {
    libtorrent_jni.add_torrent_alert_params_set(swigCPtr, this, add_torrent_params.getCPtr(value), value);
  }

  public add_torrent_params getParams() {
    long cPtr = libtorrent_jni.add_torrent_alert_params_get(swigCPtr, this);
    return (cPtr == 0) ? null : new add_torrent_params(cPtr, false);
  }

  public void setError(error_code value) {
    libtorrent_jni.add_torrent_alert_error_set(swigCPtr, this, error_code.getCPtr(value), value);
  }

  public error_code getError() {
    long cPtr = libtorrent_jni.add_torrent_alert_error_get(swigCPtr, this);
    return (cPtr == 0) ? null : new error_code(cPtr, false);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.add_torrent_alert_priority_get());
  public final static int alert_type = libtorrent_jni.add_torrent_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.add_torrent_alert_static_category_get(), false);
}
