/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class peer_class_info {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected peer_class_info(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(peer_class_info obj) {
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
        libtorrent_jni.delete_peer_class_info(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIgnore_unchoke_slots(boolean value) {
    libtorrent_jni.peer_class_info_ignore_unchoke_slots_set(swigCPtr, this, value);
  }

  public boolean getIgnore_unchoke_slots() {
    return libtorrent_jni.peer_class_info_ignore_unchoke_slots_get(swigCPtr, this);
  }

  public void setConnection_limit_factor(int value) {
    libtorrent_jni.peer_class_info_connection_limit_factor_set(swigCPtr, this, value);
  }

  public int getConnection_limit_factor() {
    return libtorrent_jni.peer_class_info_connection_limit_factor_get(swigCPtr, this);
  }

  public void setLabel(String value) {
    libtorrent_jni.peer_class_info_label_set(swigCPtr, this, value);
  }

  public String getLabel() {
    return libtorrent_jni.peer_class_info_label_get(swigCPtr, this);
  }

  public void setUpload_limit(int value) {
    libtorrent_jni.peer_class_info_upload_limit_set(swigCPtr, this, value);
  }

  public int getUpload_limit() {
    return libtorrent_jni.peer_class_info_upload_limit_get(swigCPtr, this);
  }

  public void setDownload_limit(int value) {
    libtorrent_jni.peer_class_info_download_limit_set(swigCPtr, this, value);
  }

  public int getDownload_limit() {
    return libtorrent_jni.peer_class_info_download_limit_get(swigCPtr, this);
  }

  public void setUpload_priority(int value) {
    libtorrent_jni.peer_class_info_upload_priority_set(swigCPtr, this, value);
  }

  public int getUpload_priority() {
    return libtorrent_jni.peer_class_info_upload_priority_get(swigCPtr, this);
  }

  public void setDownload_priority(int value) {
    libtorrent_jni.peer_class_info_download_priority_set(swigCPtr, this, value);
  }

  public int getDownload_priority() {
    return libtorrent_jni.peer_class_info_download_priority_get(swigCPtr, this);
  }

  public peer_class_info() {
    this(libtorrent_jni.new_peer_class_info(), true);
  }

}
