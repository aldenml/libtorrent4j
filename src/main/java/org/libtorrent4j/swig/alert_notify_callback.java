/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class alert_notify_callback {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected alert_notify_callback(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(alert_notify_callback obj) {
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
        libtorrent_jni.delete_alert_notify_callback(swigCPtr);
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
    libtorrent_jni.alert_notify_callback_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    libtorrent_jni.alert_notify_callback_change_ownership(this, swigCPtr, true);
  }

  public void on_alert() {
    if (getClass() == alert_notify_callback.class) libtorrent_jni.alert_notify_callback_on_alert(swigCPtr, this); else libtorrent_jni.alert_notify_callback_on_alertSwigExplicitalert_notify_callback(swigCPtr, this);
  }

  public alert_notify_callback() {
    this(libtorrent_jni.new_alert_notify_callback(), true);
    libtorrent_jni.alert_notify_callback_director_connect(this, swigCPtr, true, true);
  }

}
