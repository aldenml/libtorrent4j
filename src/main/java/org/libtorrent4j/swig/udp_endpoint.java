/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class udp_endpoint {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected udp_endpoint(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(udp_endpoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(udp_endpoint obj) {
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

  @SuppressWarnings({"deprecation", "removal"})
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_udp_endpoint(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public udp_endpoint() {
    this(libtorrent_jni.new_udp_endpoint__SWIG_0(), true);
  }

  public udp_endpoint(address address, int port) {
    this(libtorrent_jni.new_udp_endpoint__SWIG_1(address.getCPtr(address), address, port), true);
  }

  public udp_endpoint(udp_endpoint other) {
    this(libtorrent_jni.new_udp_endpoint__SWIG_2(udp_endpoint.getCPtr(other), other), true);
  }

  public int port() {
    return libtorrent_jni.udp_endpoint_port(swigCPtr, this);
  }

  public address address() {
    return new address(libtorrent_jni.udp_endpoint_address(swigCPtr, this), true);
  }

}
