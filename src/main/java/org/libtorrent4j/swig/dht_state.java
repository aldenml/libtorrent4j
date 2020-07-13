/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_state {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected dht_state(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_state obj) {
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
        libtorrent_jni.delete_dht_state(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setNids(address_node_id_pair_vector value) {
    libtorrent_jni.dht_state_nids_set(swigCPtr, this, address_node_id_pair_vector.getCPtr(value), value);
  }

  public address_node_id_pair_vector getNids() {
    long cPtr = libtorrent_jni.dht_state_nids_get(swigCPtr, this);
    return (cPtr == 0) ? null : new address_node_id_pair_vector(cPtr, false);
  }

  public void setNodes(udp_endpoint_vector value) {
    libtorrent_jni.dht_state_nodes_set(swigCPtr, this, udp_endpoint_vector.getCPtr(value), value);
  }

  public udp_endpoint_vector getNodes() {
    long cPtr = libtorrent_jni.dht_state_nodes_get(swigCPtr, this);
    return (cPtr == 0) ? null : new udp_endpoint_vector(cPtr, false);
  }

  public void setNodes6(udp_endpoint_vector value) {
    libtorrent_jni.dht_state_nodes6_set(swigCPtr, this, udp_endpoint_vector.getCPtr(value), value);
  }

  public udp_endpoint_vector getNodes6() {
    long cPtr = libtorrent_jni.dht_state_nodes6_get(swigCPtr, this);
    return (cPtr == 0) ? null : new udp_endpoint_vector(cPtr, false);
  }

  public void clear() {
    libtorrent_jni.dht_state_clear(swigCPtr, this);
  }

  public dht_state() {
    this(libtorrent_jni.new_dht_state(), true);
  }

}
