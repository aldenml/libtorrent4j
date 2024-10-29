/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class tracker_warning_alert extends tracker_alert {
  private transient long swigCPtr;

  protected tracker_warning_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.tracker_warning_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tracker_warning_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(tracker_warning_alert obj) {
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
        libtorrent_jni.delete_tracker_warning_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.tracker_warning_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.tracker_warning_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.tracker_warning_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.tracker_warning_alert_message(swigCPtr, this);
  }

  public String warning_message() {
    return libtorrent_jni.tracker_warning_alert_warning_message(swigCPtr, this);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.tracker_warning_alert_priority_get());
  public final static int alert_type = libtorrent_jni.tracker_warning_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.tracker_warning_alert_static_category_get(), false);
}
