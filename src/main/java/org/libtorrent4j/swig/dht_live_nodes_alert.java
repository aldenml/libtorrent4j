/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_live_nodes_alert extends alert {
  private transient long swigCPtr;

  protected dht_live_nodes_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_live_nodes_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_live_nodes_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(dht_live_nodes_alert obj) {
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

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_dht_live_nodes_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_live_nodes_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_live_nodes_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_live_nodes_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_live_nodes_alert_message(swigCPtr, this);
  }

  public void setNode_id(sha1_hash value) {
    libtorrent_jni.dht_live_nodes_alert_node_id_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getNode_id() {
    long cPtr = libtorrent_jni.dht_live_nodes_alert_node_id_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public int num_nodes() {
    return libtorrent_jni.dht_live_nodes_alert_num_nodes(swigCPtr, this);
  }

  public sha1_hash_udp_endpoint_pair_vector nodes() {
    return new sha1_hash_udp_endpoint_pair_vector(libtorrent_jni.dht_live_nodes_alert_nodes(swigCPtr, this), true);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.dht_live_nodes_alert_priority_get());
  public final static int alert_type = libtorrent_jni.dht_live_nodes_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_live_nodes_alert_static_category_get(), false);
}
