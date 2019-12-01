/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class alert_ptr_vector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected alert_ptr_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(alert_ptr_vector obj) {
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
        libtorrent_jni.delete_alert_ptr_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public alert_ptr_vector() {
    this(libtorrent_jni.new_alert_ptr_vector(), true);
  }

  public long size() {
    return libtorrent_jni.alert_ptr_vector_size(swigCPtr, this);
  }

  public long capacity() {
    return libtorrent_jni.alert_ptr_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.alert_ptr_vector_reserve(swigCPtr, this, n);
  }

  public boolean empty() {
    return libtorrent_jni.alert_ptr_vector_empty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.alert_ptr_vector_clear(swigCPtr, this);
  }

  public void push_back(alert x) {
    libtorrent_jni.alert_ptr_vector_push_back(swigCPtr, this, alert.getCPtr(x), x);
  }

  public alert get(int i) {
    long cPtr = libtorrent_jni.alert_ptr_vector_get(swigCPtr, this, i);
    return (cPtr == 0) ? null : new alert(cPtr, false);
  }

  public void set(int i, alert val) {
    libtorrent_jni.alert_ptr_vector_set(swigCPtr, this, i, alert.getCPtr(val), val);
  }

}
