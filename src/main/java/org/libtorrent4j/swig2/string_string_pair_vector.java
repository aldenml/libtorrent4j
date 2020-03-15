/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class string_string_pair_vector extends java.util.AbstractList<string_string_pair> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected string_string_pair_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(string_string_pair_vector obj) {
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
        libtorrent_jni.delete_string_string_pair_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public string_string_pair_vector(string_string_pair[] initialElements) {
    this();
    reserve(initialElements.length);

    for (string_string_pair element : initialElements) {
      add(element);
    }
  }

  public string_string_pair_vector(Iterable<string_string_pair> initialElements) {
    this();
    for (string_string_pair element : initialElements) {
      add(element);
    }
  }

  public string_string_pair get(int index) {
    return doGet(index);
  }

  public string_string_pair set(int index, string_string_pair e) {
    return doSet(index, e);
  }

  public boolean add(string_string_pair e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, string_string_pair e) {
    modCount++;
    doAdd(index, e);
  }

  public string_string_pair remove(int index) {
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

  public string_string_pair_vector() {
    this(libtorrent_jni.new_string_string_pair_vector__SWIG_0(), true);
  }

  public string_string_pair_vector(string_string_pair_vector other) {
    this(libtorrent_jni.new_string_string_pair_vector__SWIG_1(string_string_pair_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.string_string_pair_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.string_string_pair_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.string_string_pair_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.string_string_pair_vector_clear(swigCPtr, this);
  }

  public string_string_pair_vector(int count, string_string_pair value) {
    this(libtorrent_jni.new_string_string_pair_vector__SWIG_2(count, string_string_pair.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.string_string_pair_vector_doSize(swigCPtr, this);
  }

  private void doAdd(string_string_pair x) {
    libtorrent_jni.string_string_pair_vector_doAdd__SWIG_0(swigCPtr, this, string_string_pair.getCPtr(x), x);
  }

  private void doAdd(int index, string_string_pair x) {
    libtorrent_jni.string_string_pair_vector_doAdd__SWIG_1(swigCPtr, this, index, string_string_pair.getCPtr(x), x);
  }

  private string_string_pair doRemove(int index) {
    return new string_string_pair(libtorrent_jni.string_string_pair_vector_doRemove(swigCPtr, this, index), true);
  }

  private string_string_pair doGet(int index) {
    return new string_string_pair(libtorrent_jni.string_string_pair_vector_doGet(swigCPtr, this, index), false);
  }

  private string_string_pair doSet(int index, string_string_pair val) {
    return new string_string_pair(libtorrent_jni.string_string_pair_vector_doSet(swigCPtr, this, index, string_string_pair.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.string_string_pair_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}