/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_lookup_vector extends java.util.AbstractList<dht_lookup> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected dht_lookup_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_lookup_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(dht_lookup_vector obj) {
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
        libtorrent_jni.delete_dht_lookup_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public dht_lookup_vector(dht_lookup[] initialElements) {
    this();
    reserve(initialElements.length);

    for (dht_lookup element : initialElements) {
      add(element);
    }
  }

  public dht_lookup_vector(Iterable<dht_lookup> initialElements) {
    this();
    for (dht_lookup element : initialElements) {
      add(element);
    }
  }

  public dht_lookup get(int index) {
    return doGet(index);
  }

  public dht_lookup set(int index, dht_lookup e) {
    return doSet(index, e);
  }

  public boolean add(dht_lookup e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, dht_lookup e) {
    modCount++;
    doAdd(index, e);
  }

  public dht_lookup remove(int index) {
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

  public dht_lookup_vector() {
    this(libtorrent_jni.new_dht_lookup_vector__SWIG_0(), true);
  }

  public dht_lookup_vector(dht_lookup_vector other) {
    this(libtorrent_jni.new_dht_lookup_vector__SWIG_1(dht_lookup_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.dht_lookup_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.dht_lookup_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.dht_lookup_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.dht_lookup_vector_clear(swigCPtr, this);
  }

  public dht_lookup_vector(int count, dht_lookup value) {
    this(libtorrent_jni.new_dht_lookup_vector__SWIG_2(count, dht_lookup.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.dht_lookup_vector_doSize(swigCPtr, this);
  }

  private void doAdd(dht_lookup x) {
    libtorrent_jni.dht_lookup_vector_doAdd__SWIG_0(swigCPtr, this, dht_lookup.getCPtr(x), x);
  }

  private void doAdd(int index, dht_lookup x) {
    libtorrent_jni.dht_lookup_vector_doAdd__SWIG_1(swigCPtr, this, index, dht_lookup.getCPtr(x), x);
  }

  private dht_lookup doRemove(int index) {
    return new dht_lookup(libtorrent_jni.dht_lookup_vector_doRemove(swigCPtr, this, index), true);
  }

  private dht_lookup doGet(int index) {
    return new dht_lookup(libtorrent_jni.dht_lookup_vector_doGet(swigCPtr, this, index), false);
  }

  private dht_lookup doSet(int index, dht_lookup val) {
    return new dht_lookup(libtorrent_jni.dht_lookup_vector_doSet(swigCPtr, this, index, dht_lookup.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.dht_lookup_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
