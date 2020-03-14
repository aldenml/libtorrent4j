/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class tcp_endpoint {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected tcp_endpoint(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tcp_endpoint obj) {
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
        libtorrent_jni.delete_tcp_endpoint(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public tcp_endpoint() {
    this(libtorrent_jni.new_tcp_endpoint__SWIG_0(), true);
  }

  public tcp_endpoint(address address, int port) {
    this(libtorrent_jni.new_tcp_endpoint__SWIG_1(address.getCPtr(address), address, port), true);
  }

  public tcp_endpoint(tcp_endpoint other) {
    this(libtorrent_jni.new_tcp_endpoint__SWIG_2(tcp_endpoint.getCPtr(other), other), true);
  }

  public int port() {
    return libtorrent_jni.tcp_endpoint_port(swigCPtr, this);
  }

  public address address() {
    return new address(libtorrent_jni.tcp_endpoint_address(swigCPtr, this), true);
  }

}
