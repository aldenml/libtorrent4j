/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class address {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected address(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(address obj) {
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
        libtorrent_jni.delete_address(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public address() {
    this(libtorrent_jni.new_address__SWIG_0(), true);
  }

  public address(address other) {
    this(libtorrent_jni.new_address__SWIG_1(address.getCPtr(other), other), true);
  }

  public boolean is_v4() {
    return libtorrent_jni.address_is_v4(swigCPtr, this);
  }

  public boolean is_v6() {
    return libtorrent_jni.address_is_v6(swigCPtr, this);
  }

  public String to_string() {
    return libtorrent_jni.address_to_string(swigCPtr, this);
  }

  public boolean is_loopback() {
    return libtorrent_jni.address_is_loopback(swigCPtr, this);
  }

  public boolean is_unspecified() {
    return libtorrent_jni.address_is_unspecified(swigCPtr, this);
  }

  public boolean is_multicast() {
    return libtorrent_jni.address_is_multicast(swigCPtr, this);
  }

  public boolean op_lt(address a2) {
    return libtorrent_jni.address_op_lt(swigCPtr, this, address.getCPtr(a2), a2);
  }

  public static int compare(address a1, address a2) {
    return libtorrent_jni.address_compare(address.getCPtr(a1), a1, address.getCPtr(a2), a2);
  }

  public static address from_string(String str, error_code ec) {
    return new address(libtorrent_jni.address_from_string(str, error_code.getCPtr(ec), ec), true);
  }

}
