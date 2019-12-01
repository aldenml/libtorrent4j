/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_sample_infohashes_alert extends alert {
  private transient long swigCPtr;

  protected dht_sample_infohashes_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_sample_infohashes_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_sample_infohashes_alert obj) {
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
        libtorrent_jni.delete_dht_sample_infohashes_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_sample_infohashes_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_sample_infohashes_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_sample_infohashes_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_sample_infohashes_alert_message(swigCPtr, this);
  }

  public int getNum_infohashes() {
    return libtorrent_jni.dht_sample_infohashes_alert_num_infohashes_get(swigCPtr, this);
  }

  public int num_samples() {
    return libtorrent_jni.dht_sample_infohashes_alert_num_samples(swigCPtr, this);
  }

  public sha1_hash_vector samples() {
    return new sha1_hash_vector(libtorrent_jni.dht_sample_infohashes_alert_samples(swigCPtr, this), true);
  }

  public int num_nodes() {
    return libtorrent_jni.dht_sample_infohashes_alert_num_nodes(swigCPtr, this);
  }

  public sha1_hash_udp_endpoint_pair_vector nodes() {
    return new sha1_hash_udp_endpoint_pair_vector(libtorrent_jni.dht_sample_infohashes_alert_nodes(swigCPtr, this), true);
  }

  public udp_endpoint get_endpoint() {
    return new udp_endpoint(libtorrent_jni.dht_sample_infohashes_alert_get_endpoint(swigCPtr, this), true);
  }

  public long get_interval() {
    return libtorrent_jni.dht_sample_infohashes_alert_get_interval(swigCPtr, this);
  }

  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_sample_infohashes_alert_static_category_get(), false);
  public final static int priority = libtorrent_jni.dht_sample_infohashes_alert_priority_get();
  public final static int alert_type = libtorrent_jni.dht_sample_infohashes_alert_alert_type_get();
}
