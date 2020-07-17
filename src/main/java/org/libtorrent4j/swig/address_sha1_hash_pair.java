/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class address_sha1_hash_pair {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected address_sha1_hash_pair(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(address_sha1_hash_pair obj) {
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
        libtorrent_jni.delete_address_sha1_hash_pair(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public address_sha1_hash_pair() {
    this(libtorrent_jni.new_address_sha1_hash_pair__SWIG_0(), true);
  }

  public address_sha1_hash_pair(address first, sha1_hash second) {
    this(libtorrent_jni.new_address_sha1_hash_pair__SWIG_1(address.getCPtr(first), first, sha1_hash.getCPtr(second), second), true);
  }

  public address_sha1_hash_pair(address_sha1_hash_pair other) {
    this(libtorrent_jni.new_address_sha1_hash_pair__SWIG_2(address_sha1_hash_pair.getCPtr(other), other), true);
  }

  public void setFirst(address value) {
    libtorrent_jni.address_sha1_hash_pair_first_set(swigCPtr, this, address.getCPtr(value), value);
  }

  public address getFirst() {
    long cPtr = libtorrent_jni.address_sha1_hash_pair_first_get(swigCPtr, this);
    return (cPtr == 0) ? null : new address(cPtr, false);
  }

  public void setSecond(sha1_hash value) {
    libtorrent_jni.address_sha1_hash_pair_second_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getSecond() {
    long cPtr = libtorrent_jni.address_sha1_hash_pair_second_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

}
