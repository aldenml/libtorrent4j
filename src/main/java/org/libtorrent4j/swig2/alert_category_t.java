/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class alert_category_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected alert_category_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(alert_category_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_alert_category_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static alert_category_t all() {
    return new alert_category_t(libtorrent_jni.alert_category_t_all(), true);
  }

  public boolean op_bool() {
    return libtorrent_jni.alert_category_t_op_bool(swigCPtr, this);
  }

  public boolean op_eq(alert_category_t f) {
    return libtorrent_jni.alert_category_t_op_eq(swigCPtr, this, alert_category_t.getCPtr(f), f);
  }

  public boolean op_ne(alert_category_t f) {
    return libtorrent_jni.alert_category_t_op_ne(swigCPtr, this, alert_category_t.getCPtr(f), f);
  }

  public alert_category_t op_or(alert_category_t other) {
    return new alert_category_t(libtorrent_jni.alert_category_t_op_or(swigCPtr, this, alert_category_t.getCPtr(other), other), true);
  }

  public alert_category_t op_and(alert_category_t other) {
    return new alert_category_t(libtorrent_jni.alert_category_t_op_and(swigCPtr, this, alert_category_t.getCPtr(other), other), true);
  }

  public alert_category_t xor(alert_category_t other) {
    return new alert_category_t(libtorrent_jni.alert_category_t_xor(swigCPtr, this, alert_category_t.getCPtr(other), other), true);
  }

  public alert_category_t inv() {
    return new alert_category_t(libtorrent_jni.alert_category_t_inv(swigCPtr, this), true);
  }

  public int to_int() {
    return libtorrent_jni.alert_category_t_to_int(swigCPtr, this);
  }

  public alert_category_t() {
    this(libtorrent_jni.new_alert_category_t(), true);
  }

}