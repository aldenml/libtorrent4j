/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class create_file_entry_vector extends java.util.AbstractList<create_file_entry> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected create_file_entry_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(create_file_entry_vector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(create_file_entry_vector obj) {
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
        libtorrent_jni.delete_create_file_entry_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public create_file_entry_vector(create_file_entry[] initialElements) {
    this();
    reserve(initialElements.length);

    for (create_file_entry element : initialElements) {
      add(element);
    }
  }

  public create_file_entry_vector(Iterable<create_file_entry> initialElements) {
    this();
    for (create_file_entry element : initialElements) {
      add(element);
    }
  }

  public create_file_entry get(int index) {
    return doGet(index);
  }

  public create_file_entry set(int index, create_file_entry e) {
    return doSet(index, e);
  }

  public boolean add(create_file_entry e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, create_file_entry e) {
    modCount++;
    doAdd(index, e);
  }

  public create_file_entry remove(int index) {
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

  public create_file_entry_vector() {
    this(libtorrent_jni.new_create_file_entry_vector__SWIG_0(), true);
  }

  public create_file_entry_vector(create_file_entry_vector other) {
    this(libtorrent_jni.new_create_file_entry_vector__SWIG_1(create_file_entry_vector.getCPtr(other), other), true);
  }

  public boolean isEmpty() {
    return libtorrent_jni.create_file_entry_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.create_file_entry_vector_clear(swigCPtr, this);
  }

  public create_file_entry_vector(int count, create_file_entry value) {
    this(libtorrent_jni.new_create_file_entry_vector__SWIG_2(count, create_file_entry.getCPtr(value), value), true);
  }

  private int doCapacity() {
    return libtorrent_jni.create_file_entry_vector_doCapacity(swigCPtr, this);
  }

  private void doReserve(int n) {
    libtorrent_jni.create_file_entry_vector_doReserve(swigCPtr, this, n);
  }

  private int doSize() {
    return libtorrent_jni.create_file_entry_vector_doSize(swigCPtr, this);
  }

  private void doAdd(create_file_entry x) {
    libtorrent_jni.create_file_entry_vector_doAdd__SWIG_0(swigCPtr, this, create_file_entry.getCPtr(x), x);
  }

  private void doAdd(int index, create_file_entry x) {
    libtorrent_jni.create_file_entry_vector_doAdd__SWIG_1(swigCPtr, this, index, create_file_entry.getCPtr(x), x);
  }

  private create_file_entry doRemove(int index) {
    return new create_file_entry(libtorrent_jni.create_file_entry_vector_doRemove(swigCPtr, this, index), true);
  }

  private create_file_entry doGet(int index) {
    return new create_file_entry(libtorrent_jni.create_file_entry_vector_doGet(swigCPtr, this, index), false);
  }

  private create_file_entry doSet(int index, create_file_entry val) {
    return new create_file_entry(libtorrent_jni.create_file_entry_vector_doSet(swigCPtr, this, index, create_file_entry.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.create_file_entry_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
