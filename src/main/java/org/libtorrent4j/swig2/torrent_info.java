/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class torrent_info {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected torrent_info(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(torrent_info obj) {
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
        libtorrent_jni.delete_torrent_info(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public torrent_info(String filename, error_code ec) {
    this(libtorrent_jni.new_torrent_info(filename, error_code.getCPtr(ec), ec), true);
  }

}
