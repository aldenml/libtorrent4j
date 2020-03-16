/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class peer_info_vector extends java.util.AbstractList<peer_info> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected peer_info_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(peer_info_vector obj) {
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
        libtorrent_jni.delete_peer_info_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public peer_info_vector(peer_info[] initialElements) {
    this();
    reserve(initialElements.length);

    for (peer_info element : initialElements) {
      add(element);
    }
  }

  public peer_info_vector(Iterable<peer_info> initialElements) {
    this();
    for (peer_info element : initialElements) {
      add(element);
    }
  }

  public peer_info get(int index) {
    return doGet(index);
  }

  public peer_info set(int index, peer_info e) {
    return doSet(index, e);
  }

  public boolean add(peer_info e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, peer_info e) {
    modCount++;
    doAdd(index, e);
  }

  public peer_info remove(int index) {
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

  public peer_info_vector() {
    this(libtorrent_jni.new_peer_info_vector__SWIG_0(), true);
  }

  public peer_info_vector(peer_info_vector other) {
    this(libtorrent_jni.new_peer_info_vector__SWIG_1(peer_info_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.peer_info_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.peer_info_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.peer_info_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.peer_info_vector_clear(swigCPtr, this);
  }

  public peer_info_vector(int count, peer_info value) {
    this(libtorrent_jni.new_peer_info_vector__SWIG_2(count, peer_info.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.peer_info_vector_doSize(swigCPtr, this);
  }

  private void doAdd(peer_info x) {
    libtorrent_jni.peer_info_vector_doAdd__SWIG_0(swigCPtr, this, peer_info.getCPtr(x), x);
  }

  private void doAdd(int index, peer_info x) {
    libtorrent_jni.peer_info_vector_doAdd__SWIG_1(swigCPtr, this, index, peer_info.getCPtr(x), x);
  }

  private peer_info doRemove(int index) {
    return new peer_info(libtorrent_jni.peer_info_vector_doRemove(swigCPtr, this, index), true);
  }

  private peer_info doGet(int index) {
    return new peer_info(libtorrent_jni.peer_info_vector_doGet(swigCPtr, this, index), false);
  }

  private peer_info doSet(int index, peer_info val) {
    return new peer_info(libtorrent_jni.peer_info_vector_doSet(swigCPtr, this, index, peer_info.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.peer_info_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
