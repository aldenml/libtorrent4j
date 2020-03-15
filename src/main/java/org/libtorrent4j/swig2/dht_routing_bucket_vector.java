/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class dht_routing_bucket_vector extends java.util.AbstractList<dht_routing_bucket> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected dht_routing_bucket_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_routing_bucket_vector obj) {
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
        libtorrent_jni.delete_dht_routing_bucket_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public dht_routing_bucket_vector(dht_routing_bucket[] initialElements) {
    this();
    reserve(initialElements.length);

    for (dht_routing_bucket element : initialElements) {
      add(element);
    }
  }

  public dht_routing_bucket_vector(Iterable<dht_routing_bucket> initialElements) {
    this();
    for (dht_routing_bucket element : initialElements) {
      add(element);
    }
  }

  public dht_routing_bucket get(int index) {
    return doGet(index);
  }

  public dht_routing_bucket set(int index, dht_routing_bucket e) {
    return doSet(index, e);
  }

  public boolean add(dht_routing_bucket e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, dht_routing_bucket e) {
    modCount++;
    doAdd(index, e);
  }

  public dht_routing_bucket remove(int index) {
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

  public dht_routing_bucket_vector() {
    this(libtorrent_jni.new_dht_routing_bucket_vector__SWIG_0(), true);
  }

  public dht_routing_bucket_vector(dht_routing_bucket_vector other) {
    this(libtorrent_jni.new_dht_routing_bucket_vector__SWIG_1(dht_routing_bucket_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.dht_routing_bucket_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.dht_routing_bucket_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.dht_routing_bucket_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.dht_routing_bucket_vector_clear(swigCPtr, this);
  }

  public dht_routing_bucket_vector(int count, dht_routing_bucket value) {
    this(libtorrent_jni.new_dht_routing_bucket_vector__SWIG_2(count, dht_routing_bucket.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.dht_routing_bucket_vector_doSize(swigCPtr, this);
  }

  private void doAdd(dht_routing_bucket x) {
    libtorrent_jni.dht_routing_bucket_vector_doAdd__SWIG_0(swigCPtr, this, dht_routing_bucket.getCPtr(x), x);
  }

  private void doAdd(int index, dht_routing_bucket x) {
    libtorrent_jni.dht_routing_bucket_vector_doAdd__SWIG_1(swigCPtr, this, index, dht_routing_bucket.getCPtr(x), x);
  }

  private dht_routing_bucket doRemove(int index) {
    return new dht_routing_bucket(libtorrent_jni.dht_routing_bucket_vector_doRemove(swigCPtr, this, index), true);
  }

  private dht_routing_bucket doGet(int index) {
    return new dht_routing_bucket(libtorrent_jni.dht_routing_bucket_vector_doGet(swigCPtr, this, index), false);
  }

  private dht_routing_bucket doSet(int index, dht_routing_bucket val) {
    return new dht_routing_bucket(libtorrent_jni.dht_routing_bucket_vector_doSet(swigCPtr, this, index, dht_routing_bucket.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.dht_routing_bucket_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
