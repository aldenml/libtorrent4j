/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class bool_vector extends java.util.AbstractList<Boolean> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bool_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bool_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(bool_vector obj) {
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
        libtorrent_jni.delete_bool_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public bool_vector(boolean[] initialElements) {
    this();
    reserve(initialElements.length);

    for (boolean element : initialElements) {
      add(element);
    }
  }

  public bool_vector(Iterable<Boolean> initialElements) {
    this();
    for (boolean element : initialElements) {
      add(element);
    }
  }

  public Boolean get(int index) {
    return doGet(index);
  }

  public Boolean set(int index, Boolean e) {
    return doSet(index, e);
  }

  public boolean add(Boolean e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, Boolean e) {
    modCount++;
    doAdd(index, e);
  }

  public Boolean remove(int index) {
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

  public bool_vector() {
    this(libtorrent_jni.new_bool_vector__SWIG_0(), true);
  }

  public bool_vector(bool_vector other) {
    this(libtorrent_jni.new_bool_vector__SWIG_1(bool_vector.getCPtr(other), other), true);
  }

  public boolean isEmpty() {
    return libtorrent_jni.bool_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.bool_vector_clear(swigCPtr, this);
  }

  public bool_vector(int count, boolean value) {
    this(libtorrent_jni.new_bool_vector__SWIG_2(count, value), true);
  }

  private int doCapacity() {
    return libtorrent_jni.bool_vector_doCapacity(swigCPtr, this);
  }

  private void doReserve(int n) {
    libtorrent_jni.bool_vector_doReserve(swigCPtr, this, n);
  }

  private int doSize() {
    return libtorrent_jni.bool_vector_doSize(swigCPtr, this);
  }

  private void doAdd(boolean x) {
    libtorrent_jni.bool_vector_doAdd__SWIG_0(swigCPtr, this, x);
  }

  private void doAdd(int index, boolean x) {
    libtorrent_jni.bool_vector_doAdd__SWIG_1(swigCPtr, this, index, x);
  }

  private boolean doRemove(int index) {
    return libtorrent_jni.bool_vector_doRemove(swigCPtr, this, index);
  }

  private boolean doGet(int index) {
    return libtorrent_jni.bool_vector_doGet(swigCPtr, this, index);
  }

  private boolean doSet(int index, boolean val) {
    return libtorrent_jni.bool_vector_doSet(swigCPtr, this, index, val);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.bool_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
