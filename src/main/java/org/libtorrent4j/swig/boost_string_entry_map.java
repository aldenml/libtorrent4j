/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class boost_string_entry_map {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected boost_string_entry_map(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(boost_string_entry_map obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(boost_string_entry_map obj) {
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
        libtorrent_jni.delete_boost_string_entry_map(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public boolean empty() {
    return libtorrent_jni.boost_string_entry_map_empty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.boost_string_entry_map_clear(swigCPtr, this);
  }

  public long size() {
    return libtorrent_jni.boost_string_entry_map_size(swigCPtr, this);
  }

  public boolean contains(String k) {
    return libtorrent_jni.boost_string_entry_map_contains(swigCPtr, this, k);
  }

  public void put(String k, entry v) {
    libtorrent_jni.boost_string_entry_map_put(swigCPtr, this, k, entry.getCPtr(v), v);
  }

  public entry get(String k) {
    return new entry(libtorrent_jni.boost_string_entry_map_get(swigCPtr, this, k), false);
  }

  public string_vector keys() {
    return new string_vector(libtorrent_jni.boost_string_entry_map_keys(swigCPtr, this), true);
  }

  public void remove(String key) {
    libtorrent_jni.boost_string_entry_map_remove(swigCPtr, this, key);
  }

  public boost_string_entry_map() {
    this(libtorrent_jni.new_boost_string_entry_map(), true);
  }

}
