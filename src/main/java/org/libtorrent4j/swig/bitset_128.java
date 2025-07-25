/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class bitset_128 {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bitset_128(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bitset_128 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(bitset_128 obj) {
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
        libtorrent_jni.delete_bitset_128(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public boolean test(long pos) {
    return libtorrent_jni.bitset_128_test(swigCPtr, this, pos);
  }

  public boolean all() {
    return libtorrent_jni.bitset_128_all(swigCPtr, this);
  }

  public boolean any() {
    return libtorrent_jni.bitset_128_any(swigCPtr, this);
  }

  public boolean none() {
    return libtorrent_jni.bitset_128_none(swigCPtr, this);
  }

  public long count() {
    return libtorrent_jni.bitset_128_count(swigCPtr, this);
  }

  public long size() {
    return libtorrent_jni.bitset_128_size(swigCPtr, this);
  }

  public boolean get(long pos) {
    return libtorrent_jni.bitset_128_get(swigCPtr, this, pos);
  }

  public bitset_128() {
    this(libtorrent_jni.new_bitset_128(), true);
  }

}
