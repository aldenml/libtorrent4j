/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class string_vector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected string_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(string_vector obj) {
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
        libtorrent_jni.delete_string_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public string_vector() {
    this(libtorrent_jni.new_string_vector(), true);
  }

  public long size() {
    return libtorrent_jni.string_vector_size(swigCPtr, this);
  }

  public long capacity() {
    return libtorrent_jni.string_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.string_vector_reserve(swigCPtr, this, n);
  }

  public boolean empty() {
    return libtorrent_jni.string_vector_empty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.string_vector_clear(swigCPtr, this);
  }

  public void push_back(String x) {
    libtorrent_jni.string_vector_push_back(swigCPtr, this, x);
  }

  public String get(int i) {
    return libtorrent_jni.string_vector_get(swigCPtr, this, i);
  }

  public void set(int i, String val) {
    libtorrent_jni.string_vector_set(swigCPtr, this, i, val);
  }

}
