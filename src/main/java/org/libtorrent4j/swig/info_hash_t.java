/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class info_hash_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected info_hash_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(info_hash_t obj) {
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
        libtorrent_jni.delete_info_hash_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public info_hash_t() {
    this(libtorrent_jni.new_info_hash_t__SWIG_0(), true);
  }

  public info_hash_t(sha1_hash h1) {
    this(libtorrent_jni.new_info_hash_t__SWIG_1(sha1_hash.getCPtr(h1), h1), true);
  }

  public info_hash_t(sha256_hash h2) {
    this(libtorrent_jni.new_info_hash_t__SWIG_2(sha256_hash.getCPtr(h2), h2), true);
  }

  public info_hash_t(sha1_hash h1, sha256_hash h2) {
    this(libtorrent_jni.new_info_hash_t__SWIG_3(sha1_hash.getCPtr(h1), h1, sha256_hash.getCPtr(h2), h2), true);
  }

  public info_hash_t(info_hash_t arg0) {
    this(libtorrent_jni.new_info_hash_t__SWIG_4(info_hash_t.getCPtr(arg0), arg0), true);
  }

  public boolean has_v1() {
    return libtorrent_jni.info_hash_t_has_v1(swigCPtr, this);
  }

  public boolean has_v2() {
    return libtorrent_jni.info_hash_t_has_v2(swigCPtr, this);
  }

  public boolean has(protocol_version v) {
    return libtorrent_jni.info_hash_t_has(swigCPtr, this, v.swigValue());
  }

  public sha1_hash get(protocol_version v) {
    return new sha1_hash(libtorrent_jni.info_hash_t_get(swigCPtr, this, v.swigValue()), true);
  }

  public sha1_hash get_best() {
    return new sha1_hash(libtorrent_jni.info_hash_t_get_best(swigCPtr, this), true);
  }

  public boolean op_lt(info_hash_t o) {
    return libtorrent_jni.info_hash_t_op_lt(swigCPtr, this, info_hash_t.getCPtr(o), o);
  }

  public void setV1(sha1_hash value) {
    libtorrent_jni.info_hash_t_v1_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getV1() {
    long cPtr = libtorrent_jni.info_hash_t_v1_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public void setV2(sha256_hash value) {
    libtorrent_jni.info_hash_t_v2_set(swigCPtr, this, sha256_hash.getCPtr(value), value);
  }

  public sha256_hash getV2() {
    long cPtr = libtorrent_jni.info_hash_t_v2_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha256_hash(cPtr, false);
  }

  public boolean op_eq(info_hash_t n) {
    return libtorrent_jni.info_hash_t_op_eq(swigCPtr, this, info_hash_t.getCPtr(n), n);
  }

  public boolean op_ne(info_hash_t n) {
    return libtorrent_jni.info_hash_t_op_ne(swigCPtr, this, info_hash_t.getCPtr(n), n);
  }

}
