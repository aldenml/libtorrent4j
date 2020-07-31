/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class announce_endpoint {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected announce_endpoint(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(announce_endpoint obj) {
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
        libtorrent_jni.delete_announce_endpoint(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public announce_endpoint() {
    this(libtorrent_jni.new_announce_endpoint(), true);
  }

  public void setLocal_endpoint(tcp_endpoint value) {
    libtorrent_jni.announce_endpoint_local_endpoint_set(swigCPtr, this, tcp_endpoint.getCPtr(value), value);
  }

  public tcp_endpoint getLocal_endpoint() {
    long cPtr = libtorrent_jni.announce_endpoint_local_endpoint_get(swigCPtr, this);
    return (cPtr == 0) ? null : new tcp_endpoint(cPtr, false);
  }

  public void setEnabled(boolean value) {
    libtorrent_jni.announce_endpoint_enabled_set(swigCPtr, this, value);
  }

  public boolean getEnabled() {
    return libtorrent_jni.announce_endpoint_enabled_get(swigCPtr, this);
  }

  public announce_infohash get_infohash_v1() {
    return new announce_infohash(libtorrent_jni.announce_endpoint_get_infohash_v1(swigCPtr, this), true);
  }

  public announce_infohash get_infohash_v2() {
    return new announce_infohash(libtorrent_jni.announce_endpoint_get_infohash_v2(swigCPtr, this), true);
  }

}
