/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class bdecode_node_bdecode_node_pair {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bdecode_node_bdecode_node_pair(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bdecode_node_bdecode_node_pair obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(bdecode_node_bdecode_node_pair obj) {
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
        libtorrent_jni.delete_bdecode_node_bdecode_node_pair(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public bdecode_node_bdecode_node_pair() {
    this(libtorrent_jni.new_bdecode_node_bdecode_node_pair__SWIG_0(), true);
  }

  public bdecode_node_bdecode_node_pair(bdecode_node first, bdecode_node second) {
    this(libtorrent_jni.new_bdecode_node_bdecode_node_pair__SWIG_1(bdecode_node.getCPtr(first), first, bdecode_node.getCPtr(second), second), true);
  }

  public bdecode_node_bdecode_node_pair(bdecode_node_bdecode_node_pair other) {
    this(libtorrent_jni.new_bdecode_node_bdecode_node_pair__SWIG_2(bdecode_node_bdecode_node_pair.getCPtr(other), other), true);
  }

  public void setFirst(bdecode_node value) {
    libtorrent_jni.bdecode_node_bdecode_node_pair_first_set(swigCPtr, this, bdecode_node.getCPtr(value), value);
  }

  public bdecode_node getFirst() {
    long cPtr = libtorrent_jni.bdecode_node_bdecode_node_pair_first_get(swigCPtr, this);
    return (cPtr == 0) ? null : new bdecode_node(cPtr, false);
  }

  public void setSecond(bdecode_node value) {
    libtorrent_jni.bdecode_node_bdecode_node_pair_second_set(swigCPtr, this, bdecode_node.getCPtr(value), value);
  }

  public bdecode_node getSecond() {
    long cPtr = libtorrent_jni.bdecode_node_bdecode_node_pair_second_get(swigCPtr, this);
    return (cPtr == 0) ? null : new bdecode_node(cPtr, false);
  }

}
