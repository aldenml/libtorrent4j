/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_outgoing_get_peers_alert extends alert {
  private transient long swigCPtr;

  protected dht_outgoing_get_peers_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_outgoing_get_peers_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_outgoing_get_peers_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(dht_outgoing_get_peers_alert obj) {
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
        libtorrent_jni.delete_dht_outgoing_get_peers_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_outgoing_get_peers_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_outgoing_get_peers_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_outgoing_get_peers_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_outgoing_get_peers_alert_message(swigCPtr, this);
  }

  public void setInfo_hash(sha1_hash value) {
    libtorrent_jni.dht_outgoing_get_peers_alert_info_hash_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getInfo_hash() {
    long cPtr = libtorrent_jni.dht_outgoing_get_peers_alert_info_hash_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public void setObfuscated_info_hash(sha1_hash value) {
    libtorrent_jni.dht_outgoing_get_peers_alert_obfuscated_info_hash_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getObfuscated_info_hash() {
    long cPtr = libtorrent_jni.dht_outgoing_get_peers_alert_obfuscated_info_hash_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public udp_endpoint get_endpoint() {
    return new udp_endpoint(libtorrent_jni.dht_outgoing_get_peers_alert_get_endpoint(swigCPtr, this), true);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.dht_outgoing_get_peers_alert_priority_get());
  public final static int alert_type = libtorrent_jni.dht_outgoing_get_peers_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_outgoing_get_peers_alert_static_category_get(), false);
}
