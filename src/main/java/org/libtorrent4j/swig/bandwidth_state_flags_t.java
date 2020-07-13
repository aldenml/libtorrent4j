/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class bandwidth_state_flags_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bandwidth_state_flags_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bandwidth_state_flags_t obj) {
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
        libtorrent_jni.delete_bandwidth_state_flags_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static bandwidth_state_flags_t all() {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_all(), true);
  }

  public boolean op_bool() {
    return libtorrent_jni.bandwidth_state_flags_t_op_bool(swigCPtr, this);
  }

  public boolean op_eq(bandwidth_state_flags_t f) {
    return libtorrent_jni.bandwidth_state_flags_t_op_eq(swigCPtr, this, bandwidth_state_flags_t.getCPtr(f), f);
  }

  public boolean op_ne(bandwidth_state_flags_t f) {
    return libtorrent_jni.bandwidth_state_flags_t_op_ne(swigCPtr, this, bandwidth_state_flags_t.getCPtr(f), f);
  }

  public bandwidth_state_flags_t op_or(bandwidth_state_flags_t other) {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_op_or(swigCPtr, this, bandwidth_state_flags_t.getCPtr(other), other), true);
  }

  public bandwidth_state_flags_t op_and(bandwidth_state_flags_t other) {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_op_and(swigCPtr, this, bandwidth_state_flags_t.getCPtr(other), other), true);
  }

  public bandwidth_state_flags_t xor(bandwidth_state_flags_t other) {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_xor(swigCPtr, this, bandwidth_state_flags_t.getCPtr(other), other), true);
  }

  public bandwidth_state_flags_t inv() {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_inv(swigCPtr, this), true);
  }

  public int to_int() {
    return libtorrent_jni.bandwidth_state_flags_t_to_int(swigCPtr, this);
  }

  public bandwidth_state_flags_t() {
    this(libtorrent_jni.new_bandwidth_state_flags_t(), true);
  }

}
