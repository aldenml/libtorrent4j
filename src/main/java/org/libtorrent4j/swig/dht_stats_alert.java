/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_stats_alert extends alert {
  private transient long swigCPtr;

  protected dht_stats_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_stats_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_stats_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(dht_stats_alert obj) {
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
        libtorrent_jni.delete_dht_stats_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_stats_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_stats_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_stats_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_stats_alert_message(swigCPtr, this);
  }

  public void setActive_requests(dht_lookup_vector value) {
    libtorrent_jni.dht_stats_alert_active_requests_set(swigCPtr, this, dht_lookup_vector.getCPtr(value), value);
  }

  public dht_lookup_vector getActive_requests() {
    long cPtr = libtorrent_jni.dht_stats_alert_active_requests_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dht_lookup_vector(cPtr, false);
  }

  public void setRouting_table(dht_routing_bucket_vector value) {
    libtorrent_jni.dht_stats_alert_routing_table_set(swigCPtr, this, dht_routing_bucket_vector.getCPtr(value), value);
  }

  public dht_routing_bucket_vector getRouting_table() {
    long cPtr = libtorrent_jni.dht_stats_alert_routing_table_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dht_routing_bucket_vector(cPtr, false);
  }

  public void setNid(sha1_hash value) {
    libtorrent_jni.dht_stats_alert_nid_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getNid() {
    long cPtr = libtorrent_jni.dht_stats_alert_nid_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public udp_endpoint get_local_endpoint() {
    return new udp_endpoint(libtorrent_jni.dht_stats_alert_get_local_endpoint(swigCPtr, this), true);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.dht_stats_alert_priority_get());
  public final static int alert_type = libtorrent_jni.dht_stats_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_stats_alert_static_category_get(), false);
}
