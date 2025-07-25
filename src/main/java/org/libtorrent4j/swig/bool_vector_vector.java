/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class bool_vector_vector extends java.util.AbstractList<bool_vector> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bool_vector_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bool_vector_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(bool_vector_vector obj) {
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
        libtorrent_jni.delete_bool_vector_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public bool_vector_vector(bool_vector[] initialElements) {
    this();
    reserve(initialElements.length);

    for (bool_vector element : initialElements) {
      add(element);
    }
  }

  public bool_vector_vector(Iterable<bool_vector> initialElements) {
    this();
    for (bool_vector element : initialElements) {
      add(element);
    }
  }

  public bool_vector get(int index) {
    return doGet(index);
  }

  public bool_vector set(int index, bool_vector e) {
    return doSet(index, e);
  }

  public boolean add(bool_vector e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, bool_vector e) {
    modCount++;
    doAdd(index, e);
  }

  public bool_vector remove(int index) {
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

  public bool_vector_vector() {
    this(libtorrent_jni.new_bool_vector_vector__SWIG_0(), true);
  }

  public bool_vector_vector(bool_vector_vector other) {
    this(libtorrent_jni.new_bool_vector_vector__SWIG_1(bool_vector_vector.getCPtr(other), other), true);
  }

  public boolean isEmpty() {
    return libtorrent_jni.bool_vector_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.bool_vector_vector_clear(swigCPtr, this);
  }

  public bool_vector_vector(int count, bool_vector value) {
    this(libtorrent_jni.new_bool_vector_vector__SWIG_2(count, bool_vector.getCPtr(value), value), true);
  }

  private int doCapacity() {
    return libtorrent_jni.bool_vector_vector_doCapacity(swigCPtr, this);
  }

  private void doReserve(int n) {
    libtorrent_jni.bool_vector_vector_doReserve(swigCPtr, this, n);
  }

  private int doSize() {
    return libtorrent_jni.bool_vector_vector_doSize(swigCPtr, this);
  }

  private void doAdd(bool_vector x) {
    libtorrent_jni.bool_vector_vector_doAdd__SWIG_0(swigCPtr, this, bool_vector.getCPtr(x), x);
  }

  private void doAdd(int index, bool_vector x) {
    libtorrent_jni.bool_vector_vector_doAdd__SWIG_1(swigCPtr, this, index, bool_vector.getCPtr(x), x);
  }

  private bool_vector doRemove(int index) {
    return new bool_vector(libtorrent_jni.bool_vector_vector_doRemove(swigCPtr, this, index), true);
  }

  private bool_vector doGet(int index) {
    return new bool_vector(libtorrent_jni.bool_vector_vector_doGet(swigCPtr, this, index), false);
  }

  private bool_vector doSet(int index, bool_vector val) {
    return new bool_vector(libtorrent_jni.bool_vector_vector_doSet(swigCPtr, this, index, bool_vector.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.bool_vector_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
