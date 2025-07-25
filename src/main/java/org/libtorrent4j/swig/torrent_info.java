/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

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

  protected static long swigRelease(torrent_info obj) {
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
        libtorrent_jni.delete_torrent_info(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public torrent_info(info_hash_t info_hash) {
    this(libtorrent_jni.new_torrent_info__SWIG_0(info_hash_t.getCPtr(info_hash), info_hash), true);
  }

  public torrent_info(torrent_info t) {
    this(libtorrent_jni.new_torrent_info__SWIG_1(torrent_info.getCPtr(t), t), true);
  }

  public file_storage layout() {
    return new file_storage(libtorrent_jni.torrent_info_layout(swigCPtr, this), false);
  }

  public file_storage files_impl() {
    return new file_storage(libtorrent_jni.torrent_info_files_impl(swigCPtr, this), false);
  }

  public sha1_hash_vector similar_torrents() {
    return new sha1_hash_vector(libtorrent_jni.torrent_info_similar_torrents(swigCPtr, this), true);
  }

  public string_vector collections() {
    return new string_vector(libtorrent_jni.torrent_info_collections(swigCPtr, this), true);
  }

  public long total_size() {
    return libtorrent_jni.torrent_info_total_size(swigCPtr, this);
  }

  public long size_on_disk() {
    return libtorrent_jni.torrent_info_size_on_disk(swigCPtr, this);
  }

  public int piece_length() {
    return libtorrent_jni.torrent_info_piece_length(swigCPtr, this);
  }

  public int num_pieces() {
    return libtorrent_jni.torrent_info_num_pieces(swigCPtr, this);
  }

  public int blocks_per_piece() {
    return libtorrent_jni.torrent_info_blocks_per_piece(swigCPtr, this);
  }

  public int last_piece() {
    return libtorrent_jni.torrent_info_last_piece(swigCPtr, this);
  }

  public int end_piece() {
    return libtorrent_jni.torrent_info_end_piece(swigCPtr, this);
  }

  public sha1_hash info_hash() {
    return new sha1_hash(libtorrent_jni.torrent_info_info_hash(swigCPtr, this), true);
  }

  public info_hash_t info_hashes() {
    return new info_hash_t(libtorrent_jni.torrent_info_info_hashes(swigCPtr, this), false);
  }

  public boolean v1() {
    return libtorrent_jni.torrent_info_v1(swigCPtr, this);
  }

  public boolean v2() {
    return libtorrent_jni.torrent_info_v2(swigCPtr, this);
  }

  public int num_files() {
    return libtorrent_jni.torrent_info_num_files(swigCPtr, this);
  }

  public file_slice_vector map_block(int piece, long offset, int size) {
    return new file_slice_vector(libtorrent_jni.torrent_info_map_block(swigCPtr, this, piece, offset, size), true);
  }

  public peer_request map_file(int file, long offset, int size) {
    return new peer_request(libtorrent_jni.torrent_info_map_file(swigCPtr, this, file, offset, size), true);
  }

  public boolean is_valid() {
    return libtorrent_jni.torrent_info_is_valid(swigCPtr, this);
  }

  public boolean priv() {
    return libtorrent_jni.torrent_info_priv(swigCPtr, this);
  }

  public boolean is_i2p() {
    return libtorrent_jni.torrent_info_is_i2p(swigCPtr, this);
  }

  public int piece_size(int index) {
    return libtorrent_jni.torrent_info_piece_size(swigCPtr, this, index);
  }

  public sha1_hash hash_for_piece(int index) {
    return new sha1_hash(libtorrent_jni.torrent_info_hash_for_piece(swigCPtr, this, index), true);
  }

  public boolean is_loaded() {
    return libtorrent_jni.torrent_info_is_loaded(swigCPtr, this);
  }

  public String name() {
    return libtorrent_jni.torrent_info_name(swigCPtr, this);
  }

  public bdecode_node info(String key) {
    return new bdecode_node(libtorrent_jni.torrent_info_info(swigCPtr, this, key), true);
  }

  public void internal_set_collections(string_vector c) {
    libtorrent_jni.torrent_info_internal_set_collections(swigCPtr, this, string_vector.getCPtr(c), c);
  }

  public void internal_set_similar(sha1_hash_vector s) {
    libtorrent_jni.torrent_info_internal_set_similar(swigCPtr, this, sha1_hash_vector.getCPtr(s), s);
  }

  public byte_span get_info_section() {
    return new byte_span(libtorrent_jni.torrent_info_get_info_section(swigCPtr, this), true);
  }

  public static torrent_info create_torrent_info(bdecode_node info_section, error_code ec, load_torrent_limits cfg) {
    return new torrent_info(libtorrent_jni.torrent_info_create_torrent_info__SWIG_0(bdecode_node.getCPtr(info_section), info_section, error_code.getCPtr(ec), ec, load_torrent_limits.getCPtr(cfg), cfg), true);
  }

  public static torrent_info create_torrent_info(bdecode_node info_section, error_code ec) {
    return new torrent_info(libtorrent_jni.torrent_info_create_torrent_info__SWIG_1(bdecode_node.getCPtr(info_section), info_section, error_code.getCPtr(ec), ec), true);
  }

}
