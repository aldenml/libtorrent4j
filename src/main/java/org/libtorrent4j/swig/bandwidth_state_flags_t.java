/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
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

  protected static long swigRelease(bandwidth_state_flags_t obj) {
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
        libtorrent_jni.delete_bandwidth_state_flags_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public bandwidth_state_flags_t() {
    this(libtorrent_jni.new_bandwidth_state_flags_t(), true);
  }

  public static bandwidth_state_flags_t all() {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_all(), true);
  }

  public boolean non_zero() {
    return libtorrent_jni.bandwidth_state_flags_t_non_zero(swigCPtr, this);
  }

  public boolean eq(bandwidth_state_flags_t f) {
    return libtorrent_jni.bandwidth_state_flags_t_eq(swigCPtr, this, bandwidth_state_flags_t.getCPtr(f), f);
  }

  public boolean ne(bandwidth_state_flags_t f) {
    return libtorrent_jni.bandwidth_state_flags_t_ne(swigCPtr, this, bandwidth_state_flags_t.getCPtr(f), f);
  }

  public bandwidth_state_flags_t or_(bandwidth_state_flags_t other) {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_or_(swigCPtr, this, bandwidth_state_flags_t.getCPtr(other), other), true);
  }

  public bandwidth_state_flags_t and_(bandwidth_state_flags_t other) {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_and_(swigCPtr, this, bandwidth_state_flags_t.getCPtr(other), other), true);
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

  public static bandwidth_state_flags_t from_int(int val) {
    return new bandwidth_state_flags_t(libtorrent_jni.bandwidth_state_flags_t_from_int(val), true);
  }

}
