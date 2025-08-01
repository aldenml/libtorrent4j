/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_mutable_item_alert extends alert {
  private transient long swigCPtr;

  protected dht_mutable_item_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_mutable_item_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_mutable_item_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(dht_mutable_item_alert obj) {
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
        libtorrent_jni.delete_dht_mutable_item_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_mutable_item_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_mutable_item_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_mutable_item_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_mutable_item_alert_message(swigCPtr, this);
  }

  public void setSeq(long value) {
    libtorrent_jni.dht_mutable_item_alert_seq_set(swigCPtr, this, value);
  }

  public long getSeq() {
    return libtorrent_jni.dht_mutable_item_alert_seq_get(swigCPtr, this);
  }

  public void setSalt(String value) {
    libtorrent_jni.dht_mutable_item_alert_salt_set(swigCPtr, this, value);
  }

  public String getSalt() {
    return libtorrent_jni.dht_mutable_item_alert_salt_get(swigCPtr, this);
  }

  public void setItem(entry value) {
    libtorrent_jni.dht_mutable_item_alert_item_set(swigCPtr, this, entry.getCPtr(value), value);
  }

  public entry getItem() {
    long cPtr = libtorrent_jni.dht_mutable_item_alert_item_get(swigCPtr, this);
    return (cPtr == 0) ? null : new entry(cPtr, false);
  }

  public void setAuthoritative(boolean value) {
    libtorrent_jni.dht_mutable_item_alert_authoritative_set(swigCPtr, this, value);
  }

  public boolean getAuthoritative() {
    return libtorrent_jni.dht_mutable_item_alert_authoritative_get(swigCPtr, this);
  }

  public byte_array_32 get_key() {
    return new byte_array_32(libtorrent_jni.dht_mutable_item_alert_get_key(swigCPtr, this), true);
  }

  public byte_array_64 get_signature() {
    return new byte_array_64(libtorrent_jni.dht_mutable_item_alert_get_signature(swigCPtr, this), true);
  }

  public long get_seq() {
    return libtorrent_jni.dht_mutable_item_alert_get_seq(swigCPtr, this);
  }

  public byte_vector get_salt() {
    return new byte_vector(libtorrent_jni.dht_mutable_item_alert_get_salt(swigCPtr, this), true);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.dht_mutable_item_alert_priority_get());
  public final static int alert_type = libtorrent_jni.dht_mutable_item_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_mutable_item_alert_static_category_get(), false);
}
