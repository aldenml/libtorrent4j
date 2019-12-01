/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class posix_wrapper {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected posix_wrapper(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(posix_wrapper obj) {
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
        libtorrent_jni.delete_posix_wrapper(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    libtorrent_jni.posix_wrapper_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    libtorrent_jni.posix_wrapper_change_ownership(this, swigCPtr, true);
  }

  public int open(String path, int flags, int mode) {
    return (getClass() == posix_wrapper.class) ? libtorrent_jni.posix_wrapper_open(swigCPtr, this, path, flags, mode) : libtorrent_jni.posix_wrapper_openSwigExplicitposix_wrapper(swigCPtr, this, path, flags, mode);
  }

  public int stat(String path, posix_stat_t buf) {
    return (getClass() == posix_wrapper.class) ? libtorrent_jni.posix_wrapper_stat(swigCPtr, this, path, posix_stat_t.getCPtr(buf), buf) : libtorrent_jni.posix_wrapper_statSwigExplicitposix_wrapper(swigCPtr, this, path, posix_stat_t.getCPtr(buf), buf);
  }

  public int mkdir(String path, int mode) {
    return (getClass() == posix_wrapper.class) ? libtorrent_jni.posix_wrapper_mkdir(swigCPtr, this, path, mode) : libtorrent_jni.posix_wrapper_mkdirSwigExplicitposix_wrapper(swigCPtr, this, path, mode);
  }

  public int remove(String path) {
    return (getClass() == posix_wrapper.class) ? libtorrent_jni.posix_wrapper_remove(swigCPtr, this, path) : libtorrent_jni.posix_wrapper_removeSwigExplicitposix_wrapper(swigCPtr, this, path);
  }

  public posix_wrapper() {
    this(libtorrent_jni.new_posix_wrapper(), true);
    libtorrent_jni.posix_wrapper_director_connect(this, swigCPtr, true, true);
  }

}
