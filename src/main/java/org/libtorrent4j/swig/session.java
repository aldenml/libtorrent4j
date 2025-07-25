/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class session extends session_handle {
  private transient long swigCPtr;

  protected session(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.session_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(session obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(session obj) {
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
        libtorrent_jni.delete_session(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public session(session_params params) {
    this(libtorrent_jni.new_session__SWIG_0(session_params.getCPtr(params), params), true);
  }

  public session() {
    this(libtorrent_jni.new_session__SWIG_1(), true);
  }

  public session(session arg0) {
    this(libtorrent_jni.new_session__SWIG_2(session.swigRelease(arg0), arg0), true);
  }

  public session_proxy abort() {
    return new session_proxy(libtorrent_jni.session_abort(swigCPtr, this), true);
  }

}
