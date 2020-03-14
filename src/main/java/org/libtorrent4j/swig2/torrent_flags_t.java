/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class torrent_flags_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected torrent_flags_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(torrent_flags_t obj) {
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
        libtorrent_jni.delete_torrent_flags_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static torrent_flags_t all() {
    return new torrent_flags_t(libtorrent_jni.torrent_flags_t_all(), true);
  }

  public boolean op_bool() {
    return libtorrent_jni.torrent_flags_t_op_bool(swigCPtr, this);
  }

  public boolean op_eq(torrent_flags_t f) {
    return libtorrent_jni.torrent_flags_t_op_eq(swigCPtr, this, torrent_flags_t.getCPtr(f), f);
  }

  public boolean op_ne(torrent_flags_t f) {
    return libtorrent_jni.torrent_flags_t_op_ne(swigCPtr, this, torrent_flags_t.getCPtr(f), f);
  }

  public torrent_flags_t op_or(torrent_flags_t other) {
    return new torrent_flags_t(libtorrent_jni.torrent_flags_t_op_or(swigCPtr, this, torrent_flags_t.getCPtr(other), other), true);
  }

  public torrent_flags_t op_and(torrent_flags_t other) {
    return new torrent_flags_t(libtorrent_jni.torrent_flags_t_op_and(swigCPtr, this, torrent_flags_t.getCPtr(other), other), true);
  }

  public torrent_flags_t xor(torrent_flags_t other) {
    return new torrent_flags_t(libtorrent_jni.torrent_flags_t_xor(swigCPtr, this, torrent_flags_t.getCPtr(other), other), true);
  }

  public torrent_flags_t inv() {
    return new torrent_flags_t(libtorrent_jni.torrent_flags_t_inv(swigCPtr, this), true);
  }

  public int to_int() {
    return libtorrent_jni.torrent_flags_t_to_int(swigCPtr, this);
  }

  public torrent_flags_t() {
    this(libtorrent_jni.new_torrent_flags_t(), true);
  }

}
