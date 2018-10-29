/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class partial_piece_info {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected partial_piece_info(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(partial_piece_info obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_partial_piece_info(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPiece_index(int value) {
    libtorrent_jni.partial_piece_info_piece_index_set(swigCPtr, this, value);
  }

  public int getPiece_index() {
    return libtorrent_jni.partial_piece_info_piece_index_get(swigCPtr, this);
  }

  public void setBlocks_in_piece(int value) {
    libtorrent_jni.partial_piece_info_blocks_in_piece_set(swigCPtr, this, value);
  }

  public int getBlocks_in_piece() {
    return libtorrent_jni.partial_piece_info_blocks_in_piece_get(swigCPtr, this);
  }

  public void setFinished(int value) {
    libtorrent_jni.partial_piece_info_finished_set(swigCPtr, this, value);
  }

  public int getFinished() {
    return libtorrent_jni.partial_piece_info_finished_get(swigCPtr, this);
  }

  public void setWriting(int value) {
    libtorrent_jni.partial_piece_info_writing_set(swigCPtr, this, value);
  }

  public int getWriting() {
    return libtorrent_jni.partial_piece_info_writing_get(swigCPtr, this);
  }

  public void setRequested(int value) {
    libtorrent_jni.partial_piece_info_requested_set(swigCPtr, this, value);
  }

  public int getRequested() {
    return libtorrent_jni.partial_piece_info_requested_get(swigCPtr, this);
  }

  public partial_piece_info() {
    this(libtorrent_jni.new_partial_piece_info(), true);
  }

}
