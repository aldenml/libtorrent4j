/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class ip_route {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ip_route(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ip_route obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(ip_route obj) {
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
        libtorrent_jni.delete_ip_route(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setDestination(address value) {
    libtorrent_jni.ip_route_destination_set(swigCPtr, this, address.getCPtr(value), value);
  }

  public address getDestination() {
    long cPtr = libtorrent_jni.ip_route_destination_get(swigCPtr, this);
    return (cPtr == 0) ? null : new address(cPtr, false);
  }

  public void setNetmask(address value) {
    libtorrent_jni.ip_route_netmask_set(swigCPtr, this, address.getCPtr(value), value);
  }

  public address getNetmask() {
    long cPtr = libtorrent_jni.ip_route_netmask_get(swigCPtr, this);
    return (cPtr == 0) ? null : new address(cPtr, false);
  }

  public void setGateway(address value) {
    libtorrent_jni.ip_route_gateway_set(swigCPtr, this, address.getCPtr(value), value);
  }

  public address getGateway() {
    long cPtr = libtorrent_jni.ip_route_gateway_get(swigCPtr, this);
    return (cPtr == 0) ? null : new address(cPtr, false);
  }

  public void setSource_hint(address value) {
    libtorrent_jni.ip_route_source_hint_set(swigCPtr, this, address.getCPtr(value), value);
  }

  public address getSource_hint() {
    long cPtr = libtorrent_jni.ip_route_source_hint_get(swigCPtr, this);
    return (cPtr == 0) ? null : new address(cPtr, false);
  }

  public void setName(byte_vector value) {
    libtorrent_jni.ip_route_name_set(swigCPtr, this, byte_vector.getCPtr(value), value);
  }

  public byte_vector getName() {
    long cPtr = libtorrent_jni.ip_route_name_get(swigCPtr, this);
    return (cPtr == 0) ? null : new byte_vector(cPtr, false);
  }

  public void setMtu(int value) {
    libtorrent_jni.ip_route_mtu_set(swigCPtr, this, value);
  }

  public int getMtu() {
    return libtorrent_jni.ip_route_mtu_get(swigCPtr, this);
  }

  public ip_route() {
    this(libtorrent_jni.new_ip_route(), true);
  }

}
