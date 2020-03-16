/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class create_flags_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected create_flags_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(create_flags_t obj) {
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
        libtorrent_jni.delete_create_flags_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static create_flags_t all() {
    return new create_flags_t(libtorrent_jni.create_flags_t_all(), true);
  }

  public boolean op_bool() {
    return libtorrent_jni.create_flags_t_op_bool(swigCPtr, this);
  }

  public boolean op_eq(create_flags_t f) {
    return libtorrent_jni.create_flags_t_op_eq(swigCPtr, this, create_flags_t.getCPtr(f), f);
  }

  public boolean op_ne(create_flags_t f) {
    return libtorrent_jni.create_flags_t_op_ne(swigCPtr, this, create_flags_t.getCPtr(f), f);
  }

  public create_flags_t op_or(create_flags_t other) {
    return new create_flags_t(libtorrent_jni.create_flags_t_op_or(swigCPtr, this, create_flags_t.getCPtr(other), other), true);
  }

  public create_flags_t op_and(create_flags_t other) {
    return new create_flags_t(libtorrent_jni.create_flags_t_op_and(swigCPtr, this, create_flags_t.getCPtr(other), other), true);
  }

  public create_flags_t xor(create_flags_t other) {
    return new create_flags_t(libtorrent_jni.create_flags_t_xor(swigCPtr, this, create_flags_t.getCPtr(other), other), true);
  }

  public create_flags_t inv() {
    return new create_flags_t(libtorrent_jni.create_flags_t_inv(swigCPtr, this), true);
  }

  public int to_int() {
    return libtorrent_jni.create_flags_t_to_int(swigCPtr, this);
  }

  public create_flags_t() {
    this(libtorrent_jni.new_create_flags_t(), true);
  }

}
