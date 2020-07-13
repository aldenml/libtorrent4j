/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class sha1_hash_vector extends java.util.AbstractList<sha1_hash> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected sha1_hash_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(sha1_hash_vector obj) {
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
        libtorrent_jni.delete_sha1_hash_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public sha1_hash_vector(sha1_hash[] initialElements) {
    this();
    reserve(initialElements.length);

    for (sha1_hash element : initialElements) {
      add(element);
    }
  }

  public sha1_hash_vector(Iterable<sha1_hash> initialElements) {
    this();
    for (sha1_hash element : initialElements) {
      add(element);
    }
  }

  public sha1_hash get(int index) {
    return doGet(index);
  }

  public sha1_hash set(int index, sha1_hash e) {
    return doSet(index, e);
  }

  public boolean add(sha1_hash e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, sha1_hash e) {
    modCount++;
    doAdd(index, e);
  }

  public sha1_hash remove(int index) {
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

  public sha1_hash_vector() {
    this(libtorrent_jni.new_sha1_hash_vector__SWIG_0(), true);
  }

  public sha1_hash_vector(sha1_hash_vector other) {
    this(libtorrent_jni.new_sha1_hash_vector__SWIG_1(sha1_hash_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.sha1_hash_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.sha1_hash_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.sha1_hash_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.sha1_hash_vector_clear(swigCPtr, this);
  }

  public sha1_hash_vector(int count, sha1_hash value) {
    this(libtorrent_jni.new_sha1_hash_vector__SWIG_2(count, sha1_hash.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.sha1_hash_vector_doSize(swigCPtr, this);
  }

  private void doAdd(sha1_hash x) {
    libtorrent_jni.sha1_hash_vector_doAdd__SWIG_0(swigCPtr, this, sha1_hash.getCPtr(x), x);
  }

  private void doAdd(int index, sha1_hash x) {
    libtorrent_jni.sha1_hash_vector_doAdd__SWIG_1(swigCPtr, this, index, sha1_hash.getCPtr(x), x);
  }

  private sha1_hash doRemove(int index) {
    return new sha1_hash(libtorrent_jni.sha1_hash_vector_doRemove(swigCPtr, this, index), true);
  }

  private sha1_hash doGet(int index) {
    return new sha1_hash(libtorrent_jni.sha1_hash_vector_doGet(swigCPtr, this, index), false);
  }

  private sha1_hash doSet(int index, sha1_hash val) {
    return new sha1_hash(libtorrent_jni.sha1_hash_vector_doSet(swigCPtr, this, index, sha1_hash.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.sha1_hash_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
