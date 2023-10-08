/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class string_vector extends java.util.AbstractList<String> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected string_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(string_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(string_vector obj) {
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
        libtorrent_jni.delete_string_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public string_vector(String[] initialElements) {
    this();
    reserve(initialElements.length);

    for (String element : initialElements) {
      add(element);
    }
  }

  public string_vector(Iterable<String> initialElements) {
    this();
    for (String element : initialElements) {
      add(element);
    }
  }

  public String get(int index) {
    return doGet(index);
  }

  public String set(int index, String e) {
    return doSet(index, e);
  }

  public boolean add(String e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, String e) {
    modCount++;
    doAdd(index, e);
  }

  public String remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public string_vector() {
    this(libtorrent_jni.new_string_vector__SWIG_0(), true);
  }

  public string_vector(string_vector other) {
    this(libtorrent_jni.new_string_vector__SWIG_1(string_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.string_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.string_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.string_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.string_vector_clear(swigCPtr, this);
  }

  public string_vector(int count, String value) {
    this(libtorrent_jni.new_string_vector__SWIG_2(count, value), true);
  }

  private int doSize() {
    return libtorrent_jni.string_vector_doSize(swigCPtr, this);
  }

  private void doAdd(String x) {
    libtorrent_jni.string_vector_doAdd__SWIG_0(swigCPtr, this, x);
  }

  private void doAdd(int index, String x) {
    libtorrent_jni.string_vector_doAdd__SWIG_1(swigCPtr, this, index, x);
  }

  private String doRemove(int index) {
    return libtorrent_jni.string_vector_doRemove(swigCPtr, this, index);
  }

  private String doGet(int index) {
    return libtorrent_jni.string_vector_doGet(swigCPtr, this, index);
  }

  private String doSet(int index, String val) {
    return libtorrent_jni.string_vector_doSet(swigCPtr, this, index, val);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.string_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
