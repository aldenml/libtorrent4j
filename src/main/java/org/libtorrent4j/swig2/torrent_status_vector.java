/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class torrent_status_vector extends java.util.AbstractList<torrent_status> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected torrent_status_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(torrent_status_vector obj) {
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
        libtorrent_jni.delete_torrent_status_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public torrent_status_vector(torrent_status[] initialElements) {
    this();
    reserve(initialElements.length);

    for (torrent_status element : initialElements) {
      add(element);
    }
  }

  public torrent_status_vector(Iterable<torrent_status> initialElements) {
    this();
    for (torrent_status element : initialElements) {
      add(element);
    }
  }

  public torrent_status get(int index) {
    return doGet(index);
  }

  public torrent_status set(int index, torrent_status e) {
    return doSet(index, e);
  }

  public boolean add(torrent_status e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, torrent_status e) {
    modCount++;
    doAdd(index, e);
  }

  public torrent_status remove(int index) {
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

  public torrent_status_vector() {
    this(libtorrent_jni.new_torrent_status_vector__SWIG_0(), true);
  }

  public torrent_status_vector(torrent_status_vector other) {
    this(libtorrent_jni.new_torrent_status_vector__SWIG_1(torrent_status_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.torrent_status_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.torrent_status_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.torrent_status_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.torrent_status_vector_clear(swigCPtr, this);
  }

  public torrent_status_vector(int count, torrent_status value) {
    this(libtorrent_jni.new_torrent_status_vector__SWIG_2(count, torrent_status.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.torrent_status_vector_doSize(swigCPtr, this);
  }

  private void doAdd(torrent_status x) {
    libtorrent_jni.torrent_status_vector_doAdd__SWIG_0(swigCPtr, this, torrent_status.getCPtr(x), x);
  }

  private void doAdd(int index, torrent_status x) {
    libtorrent_jni.torrent_status_vector_doAdd__SWIG_1(swigCPtr, this, index, torrent_status.getCPtr(x), x);
  }

  private torrent_status doRemove(int index) {
    return new torrent_status(libtorrent_jni.torrent_status_vector_doRemove(swigCPtr, this, index), true);
  }

  private torrent_status doGet(int index) {
    return new torrent_status(libtorrent_jni.torrent_status_vector_doGet(swigCPtr, this, index), false);
  }

  private torrent_status doSet(int index, torrent_status val) {
    return new torrent_status(libtorrent_jni.torrent_status_vector_doSet(swigCPtr, this, index, torrent_status.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.torrent_status_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
