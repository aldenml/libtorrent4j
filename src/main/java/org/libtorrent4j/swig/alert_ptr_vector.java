/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class alert_ptr_vector extends java.util.AbstractList<alert> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected alert_ptr_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(alert_ptr_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(alert_ptr_vector obj) {
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
        libtorrent_jni.delete_alert_ptr_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public alert_ptr_vector(alert[] initialElements) {
    this();
    reserve(initialElements.length);

    for (alert element : initialElements) {
      add(element);
    }
  }

  public alert_ptr_vector(Iterable<alert> initialElements) {
    this();
    for (alert element : initialElements) {
      add(element);
    }
  }

  public alert get(int index) {
    return doGet(index);
  }

  public alert set(int index, alert e) {
    return doSet(index, e);
  }

  public boolean add(alert e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, alert e) {
    modCount++;
    doAdd(index, e);
  }

  public alert remove(int index) {
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

  public int capacity() {
    return doCapacity();
  }

  public void reserve(int n) {
    doReserve(n);
  }

  public alert_ptr_vector() {
    this(libtorrent_jni.new_alert_ptr_vector__SWIG_0(), true);
  }

  public alert_ptr_vector(alert_ptr_vector other) {
    this(libtorrent_jni.new_alert_ptr_vector__SWIG_1(alert_ptr_vector.getCPtr(other), other), true);
  }

  public boolean isEmpty() {
    return libtorrent_jni.alert_ptr_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.alert_ptr_vector_clear(swigCPtr, this);
  }

  public alert_ptr_vector(int count, alert value) {
    this(libtorrent_jni.new_alert_ptr_vector__SWIG_2(count, alert.getCPtr(value), value), true);
  }

  private int doCapacity() {
    return libtorrent_jni.alert_ptr_vector_doCapacity(swigCPtr, this);
  }

  private void doReserve(int n) {
    libtorrent_jni.alert_ptr_vector_doReserve(swigCPtr, this, n);
  }

  private int doSize() {
    return libtorrent_jni.alert_ptr_vector_doSize(swigCPtr, this);
  }

  private void doAdd(alert x) {
    libtorrent_jni.alert_ptr_vector_doAdd__SWIG_0(swigCPtr, this, alert.getCPtr(x), x);
  }

  private void doAdd(int index, alert x) {
    libtorrent_jni.alert_ptr_vector_doAdd__SWIG_1(swigCPtr, this, index, alert.getCPtr(x), x);
  }

  private alert doRemove(int index) {
    long cPtr = libtorrent_jni.alert_ptr_vector_doRemove(swigCPtr, this, index);
    return (cPtr == 0) ? null : new alert(cPtr, false);
  }

  private alert doGet(int index) {
    long cPtr = libtorrent_jni.alert_ptr_vector_doGet(swigCPtr, this, index);
    return (cPtr == 0) ? null : new alert(cPtr, false);
  }

  private alert doSet(int index, alert val) {
    long cPtr = libtorrent_jni.alert_ptr_vector_doSet(swigCPtr, this, index, alert.getCPtr(val), val);
    return (cPtr == 0) ? null : new alert(cPtr, false);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.alert_ptr_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
