/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class peer_alert extends torrent_alert {
  private transient long swigCPtr;

  protected peer_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.peer_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(peer_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(peer_alert obj) {
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
        libtorrent_jni.delete_peer_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public String message() {
    return libtorrent_jni.peer_alert_message(swigCPtr, this);
  }

  public void setPid(sha1_hash value) {
    libtorrent_jni.peer_alert_pid_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getPid() {
    long cPtr = libtorrent_jni.peer_alert_pid_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public tcp_endpoint get_endpoint() {
    return new tcp_endpoint(libtorrent_jni.peer_alert_get_endpoint(swigCPtr, this), true);
  }

}
