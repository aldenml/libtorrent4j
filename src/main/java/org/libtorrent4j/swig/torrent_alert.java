/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class torrent_alert extends alert {
  private transient long swigCPtr;

  protected torrent_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.torrent_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(torrent_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(torrent_alert obj) {
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
        libtorrent_jni.delete_torrent_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public String message() {
    return libtorrent_jni.torrent_alert_message(swigCPtr, this);
  }

  public void setHandle(torrent_handle value) {
    libtorrent_jni.torrent_alert_handle_set(swigCPtr, this, torrent_handle.getCPtr(value), value);
  }

  public torrent_handle getHandle() {
    long cPtr = libtorrent_jni.torrent_alert_handle_get(swigCPtr, this);
    return (cPtr == 0) ? null : new torrent_handle(cPtr, false);
  }

}
