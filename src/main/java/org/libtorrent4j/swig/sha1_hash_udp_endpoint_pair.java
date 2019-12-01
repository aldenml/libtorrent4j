/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class sha1_hash_udp_endpoint_pair {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected sha1_hash_udp_endpoint_pair(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(sha1_hash_udp_endpoint_pair obj) {
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
        libtorrent_jni.delete_sha1_hash_udp_endpoint_pair(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public sha1_hash_udp_endpoint_pair() {
    this(libtorrent_jni.new_sha1_hash_udp_endpoint_pair__SWIG_0(), true);
  }

  public sha1_hash_udp_endpoint_pair(sha1_hash first, udp_endpoint second) {
    this(libtorrent_jni.new_sha1_hash_udp_endpoint_pair__SWIG_1(sha1_hash.getCPtr(first), first, udp_endpoint.getCPtr(second), second), true);
  }

  public sha1_hash_udp_endpoint_pair(sha1_hash_udp_endpoint_pair other) {
    this(libtorrent_jni.new_sha1_hash_udp_endpoint_pair__SWIG_2(sha1_hash_udp_endpoint_pair.getCPtr(other), other), true);
  }

  public void setFirst(sha1_hash value) {
    libtorrent_jni.sha1_hash_udp_endpoint_pair_first_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getFirst() {
    long cPtr = libtorrent_jni.sha1_hash_udp_endpoint_pair_first_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public void setSecond(udp_endpoint value) {
    libtorrent_jni.sha1_hash_udp_endpoint_pair_second_set(swigCPtr, this, udp_endpoint.getCPtr(value), value);
  }

  public udp_endpoint getSecond() {
    long cPtr = libtorrent_jni.sha1_hash_udp_endpoint_pair_second_get(swigCPtr, this);
    return (cPtr == 0) ? null : new udp_endpoint(cPtr, false);
  }

}
