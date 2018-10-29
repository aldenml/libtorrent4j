/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class string_string_pair_vector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected string_string_pair_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(string_string_pair_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_string_string_pair_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public string_string_pair_vector() {
    this(libtorrent_jni.new_string_string_pair_vector(), true);
  }

  public long size() {
    return libtorrent_jni.string_string_pair_vector_size(swigCPtr, this);
  }

  public long capacity() {
    return libtorrent_jni.string_string_pair_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.string_string_pair_vector_reserve(swigCPtr, this, n);
  }

  public boolean empty() {
    return libtorrent_jni.string_string_pair_vector_empty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.string_string_pair_vector_clear(swigCPtr, this);
  }

  public void push_back(string_string_pair x) {
    libtorrent_jni.string_string_pair_vector_push_back(swigCPtr, this, string_string_pair.getCPtr(x), x);
  }

  public string_string_pair get(int i) {
    return new string_string_pair(libtorrent_jni.string_string_pair_vector_get(swigCPtr, this, i), false);
  }

  public void set(int i, string_string_pair val) {
    libtorrent_jni.string_string_pair_vector_set(swigCPtr, this, i, string_string_pair.getCPtr(val), val);
  }

}
