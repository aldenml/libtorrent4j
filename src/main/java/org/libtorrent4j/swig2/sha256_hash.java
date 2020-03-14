/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class sha256_hash {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected sha256_hash(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(sha256_hash obj) {
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
        libtorrent_jni.delete_sha256_hash(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static long size() {
    return libtorrent_jni.sha256_hash_size();
  }

  public sha256_hash() {
    this(libtorrent_jni.new_sha256_hash__SWIG_0(), true);
  }

  public sha256_hash(sha256_hash arg0) {
    this(libtorrent_jni.new_sha256_hash__SWIG_1(sha256_hash.getCPtr(arg0), arg0), true);
  }

  public static sha256_hash max() {
    return new sha256_hash(libtorrent_jni.sha256_hash_max(), true);
  }

  public static sha256_hash min() {
    return new sha256_hash(libtorrent_jni.sha256_hash_min(), true);
  }

  public void clear() {
    libtorrent_jni.sha256_hash_clear(swigCPtr, this);
  }

  public boolean is_all_zeros() {
    return libtorrent_jni.sha256_hash_is_all_zeros(swigCPtr, this);
  }

  public sha256_hash op_shl_mut(int n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_shl_mut(swigCPtr, this, n), false);
  }

  public sha256_hash op_shr_mut(int n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_shr_mut(swigCPtr, this, n), false);
  }

  public boolean op_eq(sha256_hash n) {
    return libtorrent_jni.sha256_hash_op_eq(swigCPtr, this, sha256_hash.getCPtr(n), n);
  }

  public boolean op_ne(sha256_hash n) {
    return libtorrent_jni.sha256_hash_op_ne(swigCPtr, this, sha256_hash.getCPtr(n), n);
  }

  public boolean op_lt(sha256_hash n) {
    return libtorrent_jni.sha256_hash_op_lt(swigCPtr, this, sha256_hash.getCPtr(n), n);
  }

  public int count_leading_zeroes() {
    return libtorrent_jni.sha256_hash_count_leading_zeroes(swigCPtr, this);
  }

  public sha256_hash op_neg() {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_neg(swigCPtr, this), true);
  }

  public sha256_hash op_xor(sha256_hash n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_xor(swigCPtr, this, sha256_hash.getCPtr(n), n), true);
  }

  public sha256_hash op_xor_mut(sha256_hash n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_xor_mut(swigCPtr, this, sha256_hash.getCPtr(n), n), false);
  }

  public sha256_hash op_and(sha256_hash n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_and(swigCPtr, this, sha256_hash.getCPtr(n), n), true);
  }

  public sha256_hash op_and_mut(sha256_hash n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_and_mut(swigCPtr, this, sha256_hash.getCPtr(n), n), false);
  }

  public sha256_hash op_or_mut(sha256_hash n) {
    return new sha256_hash(libtorrent_jni.sha256_hash_op_or_mut(swigCPtr, this, sha256_hash.getCPtr(n), n), false);
  }

  public sha256_hash(byte_vector v) {
    this(libtorrent_jni.new_sha256_hash__SWIG_2(byte_vector.getCPtr(v), v), true);
  }

  public void assign(byte_vector v) {
    libtorrent_jni.sha256_hash_assign(swigCPtr, this, byte_vector.getCPtr(v), v);
  }

  public int hash_code() {
    return libtorrent_jni.sha256_hash_hash_code(swigCPtr, this);
  }

  public byte_vector to_bytes() {
    return new byte_vector(libtorrent_jni.sha256_hash_to_bytes(swigCPtr, this), true);
  }

  public String to_hex() {
    return libtorrent_jni.sha256_hash_to_hex(swigCPtr, this);
  }

  public static sha256_hash from_hex(String s) {
    return new sha256_hash(libtorrent_jni.sha256_hash_from_hex(s), true);
  }

  public static int compare(sha256_hash h1, sha256_hash h2) {
    return libtorrent_jni.sha256_hash_compare(sha256_hash.getCPtr(h1), h1, sha256_hash.getCPtr(h2), h2);
  }

}
