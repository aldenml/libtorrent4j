/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class add_torrent_params {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected add_torrent_params(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(add_torrent_params obj) {
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
        libtorrent_jni.delete_add_torrent_params(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public add_torrent_params() {
    this(libtorrent_jni.new_add_torrent_params__SWIG_0(), true);
  }

  public add_torrent_params(add_torrent_params arg0) {
    this(libtorrent_jni.new_add_torrent_params__SWIG_1(add_torrent_params.getCPtr(arg0), arg0), true);
  }

  public void setVersion(int value) {
    libtorrent_jni.add_torrent_params_version_set(swigCPtr, this, value);
  }

  public int getVersion() {
    return libtorrent_jni.add_torrent_params_version_get(swigCPtr, this);
  }

  public void setTi(torrent_info value) {
    libtorrent_jni.add_torrent_params_ti_set(swigCPtr, this, torrent_info.getCPtr(value), value);
  }

  public torrent_info getTi() {
    long cPtr = libtorrent_jni.add_torrent_params_ti_get(swigCPtr, this);
    return (cPtr == 0) ? null : new torrent_info(cPtr, true);
  }

  public void setName(String value) {
    libtorrent_jni.add_torrent_params_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return libtorrent_jni.add_torrent_params_name_get(swigCPtr, this);
  }

  public void setSave_path(String value) {
    libtorrent_jni.add_torrent_params_save_path_set(swigCPtr, this, value);
  }

  public String getSave_path() {
    return libtorrent_jni.add_torrent_params_save_path_get(swigCPtr, this);
  }

  public void setStorage_mode(storage_mode_t value) {
    libtorrent_jni.add_torrent_params_storage_mode_set(swigCPtr, this, value.swigValue());
  }

  public storage_mode_t getStorage_mode() {
    return storage_mode_t.swigToEnum(libtorrent_jni.add_torrent_params_storage_mode_get(swigCPtr, this));
  }

  public void setUserdata(client_data_t value) {
    libtorrent_jni.add_torrent_params_userdata_set(swigCPtr, this, client_data_t.getCPtr(value), value);
  }

  public client_data_t getUserdata() {
    long cPtr = libtorrent_jni.add_torrent_params_userdata_get(swigCPtr, this);
    return (cPtr == 0) ? null : new client_data_t(cPtr, false);
  }

  public void setTrackerid(String value) {
    libtorrent_jni.add_torrent_params_trackerid_set(swigCPtr, this, value);
  }

  public String getTrackerid() {
    return libtorrent_jni.add_torrent_params_trackerid_get(swigCPtr, this);
  }

  public void setFlags(torrent_flags_t value) {
    libtorrent_jni.add_torrent_params_flags_set(swigCPtr, this, torrent_flags_t.getCPtr(value), value);
  }

  public torrent_flags_t getFlags() {
    long cPtr = libtorrent_jni.add_torrent_params_flags_get(swigCPtr, this);
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public void setInfo_hash(info_hash_t value) {
    libtorrent_jni.add_torrent_params_info_hash_set(swigCPtr, this, info_hash_t.getCPtr(value), value);
  }

  public info_hash_t getInfo_hash() {
    long cPtr = libtorrent_jni.add_torrent_params_info_hash_get(swigCPtr, this);
    return (cPtr == 0) ? null : new info_hash_t(cPtr, false);
  }

  public void setMax_uploads(int value) {
    libtorrent_jni.add_torrent_params_max_uploads_set(swigCPtr, this, value);
  }

  public int getMax_uploads() {
    return libtorrent_jni.add_torrent_params_max_uploads_get(swigCPtr, this);
  }

  public void setMax_connections(int value) {
    libtorrent_jni.add_torrent_params_max_connections_set(swigCPtr, this, value);
  }

  public int getMax_connections() {
    return libtorrent_jni.add_torrent_params_max_connections_get(swigCPtr, this);
  }

  public void setUpload_limit(int value) {
    libtorrent_jni.add_torrent_params_upload_limit_set(swigCPtr, this, value);
  }

  public int getUpload_limit() {
    return libtorrent_jni.add_torrent_params_upload_limit_get(swigCPtr, this);
  }

  public void setDownload_limit(int value) {
    libtorrent_jni.add_torrent_params_download_limit_set(swigCPtr, this, value);
  }

  public int getDownload_limit() {
    return libtorrent_jni.add_torrent_params_download_limit_get(swigCPtr, this);
  }

  public void setTotal_uploaded(long value) {
    libtorrent_jni.add_torrent_params_total_uploaded_set(swigCPtr, this, value);
  }

  public long getTotal_uploaded() {
    return libtorrent_jni.add_torrent_params_total_uploaded_get(swigCPtr, this);
  }

  public void setTotal_downloaded(long value) {
    libtorrent_jni.add_torrent_params_total_downloaded_set(swigCPtr, this, value);
  }

  public long getTotal_downloaded() {
    return libtorrent_jni.add_torrent_params_total_downloaded_get(swigCPtr, this);
  }

  public void setActive_time(int value) {
    libtorrent_jni.add_torrent_params_active_time_set(swigCPtr, this, value);
  }

  public int getActive_time() {
    return libtorrent_jni.add_torrent_params_active_time_get(swigCPtr, this);
  }

  public void setFinished_time(int value) {
    libtorrent_jni.add_torrent_params_finished_time_set(swigCPtr, this, value);
  }

  public int getFinished_time() {
    return libtorrent_jni.add_torrent_params_finished_time_get(swigCPtr, this);
  }

  public void setSeeding_time(int value) {
    libtorrent_jni.add_torrent_params_seeding_time_set(swigCPtr, this, value);
  }

  public int getSeeding_time() {
    return libtorrent_jni.add_torrent_params_seeding_time_get(swigCPtr, this);
  }

  public void setAdded_time(long value) {
    libtorrent_jni.add_torrent_params_added_time_set(swigCPtr, this, value);
  }

  public long getAdded_time() {
    return libtorrent_jni.add_torrent_params_added_time_get(swigCPtr, this);
  }

  public void setCompleted_time(long value) {
    libtorrent_jni.add_torrent_params_completed_time_set(swigCPtr, this, value);
  }

  public long getCompleted_time() {
    return libtorrent_jni.add_torrent_params_completed_time_get(swigCPtr, this);
  }

  public void setLast_seen_complete(long value) {
    libtorrent_jni.add_torrent_params_last_seen_complete_set(swigCPtr, this, value);
  }

  public long getLast_seen_complete() {
    return libtorrent_jni.add_torrent_params_last_seen_complete_get(swigCPtr, this);
  }

  public void setNum_complete(int value) {
    libtorrent_jni.add_torrent_params_num_complete_set(swigCPtr, this, value);
  }

  public int getNum_complete() {
    return libtorrent_jni.add_torrent_params_num_complete_get(swigCPtr, this);
  }

  public void setNum_incomplete(int value) {
    libtorrent_jni.add_torrent_params_num_incomplete_set(swigCPtr, this, value);
  }

  public int getNum_incomplete() {
    return libtorrent_jni.add_torrent_params_num_incomplete_get(swigCPtr, this);
  }

  public void setNum_downloaded(int value) {
    libtorrent_jni.add_torrent_params_num_downloaded_set(swigCPtr, this, value);
  }

  public int getNum_downloaded() {
    return libtorrent_jni.add_torrent_params_num_downloaded_get(swigCPtr, this);
  }

  public void setLast_download(long value) {
    libtorrent_jni.add_torrent_params_last_download_set(swigCPtr, this, value);
  }

  public long getLast_download() {
    return libtorrent_jni.add_torrent_params_last_download_get(swigCPtr, this);
  }

  public void setLast_upload(long value) {
    libtorrent_jni.add_torrent_params_last_upload_set(swigCPtr, this, value);
  }

  public long getLast_upload() {
    return libtorrent_jni.add_torrent_params_last_upload_get(swigCPtr, this);
  }

  public string_vector get_trackers() {
    return new string_vector(libtorrent_jni.add_torrent_params_get_trackers(swigCPtr, this), true);
  }

  public void set_trackers(string_vector v) {
    libtorrent_jni.add_torrent_params_set_trackers(swigCPtr, this, string_vector.getCPtr(v), v);
  }

  public int_vector get_tracker_tiers() {
    return new int_vector(libtorrent_jni.add_torrent_params_get_tracker_tiers(swigCPtr, this), true);
  }

  public void set_tracker_tiers(int_vector v) {
    libtorrent_jni.add_torrent_params_set_tracker_tiers(swigCPtr, this, int_vector.getCPtr(v), v);
  }

  public string_int_pair_vector get_dht_nodes() {
    return new string_int_pair_vector(libtorrent_jni.add_torrent_params_get_dht_nodes(swigCPtr, this), true);
  }

  public void set_dht_nodes(string_int_pair_vector v) {
    libtorrent_jni.add_torrent_params_set_dht_nodes(swigCPtr, this, string_int_pair_vector.getCPtr(v), v);
  }

  public byte_vector get_file_priorities() {
    return new byte_vector(libtorrent_jni.add_torrent_params_get_file_priorities(swigCPtr, this), true);
  }

  public void set_file_priorities(byte_vector v) {
    libtorrent_jni.add_torrent_params_set_file_priorities(swigCPtr, this, byte_vector.getCPtr(v), v);
  }

  public byte_vector get_piece_priorities() {
    return new byte_vector(libtorrent_jni.add_torrent_params_get_piece_priorities(swigCPtr, this), true);
  }

  public void set_piece_priorities(byte_vector v) {
    libtorrent_jni.add_torrent_params_set_piece_priorities(swigCPtr, this, byte_vector.getCPtr(v), v);
  }

  public sha256_hash_vector_vector get_merkle_trees() {
    return new sha256_hash_vector_vector(libtorrent_jni.add_torrent_params_get_merkle_trees(swigCPtr, this), true);
  }

  public void set_merkle_trees(sha256_hash_vector_vector v) {
    libtorrent_jni.add_torrent_params_set_merkle_trees(swigCPtr, this, sha256_hash_vector_vector.getCPtr(v), v);
  }

  public bool_vector_vector get_verified_leaf_hashes() {
    return new bool_vector_vector(libtorrent_jni.add_torrent_params_get_verified_leaf_hashes(swigCPtr, this), true);
  }

  public void set_verified_leaf_hashes(bool_vector_vector v) {
    libtorrent_jni.add_torrent_params_set_verified_leaf_hashes(swigCPtr, this, bool_vector_vector.getCPtr(v), v);
  }

  public int_bitfield_map get_unfinished_pieces() {
    return new int_bitfield_map(libtorrent_jni.add_torrent_params_get_unfinished_pieces(swigCPtr, this), true);
  }

  public void set_unfinished_pieces(int_bitfield_map v) {
    libtorrent_jni.add_torrent_params_set_unfinished_pieces(swigCPtr, this, int_bitfield_map.getCPtr(v), v);
  }

  public int_string_map get_renamed_files() {
    return new int_string_map(libtorrent_jni.add_torrent_params_get_renamed_files(swigCPtr, this), true);
  }

  public void set_renamed_files(int_string_map v) {
    libtorrent_jni.add_torrent_params_set_renamed_files(swigCPtr, this, int_string_map.getCPtr(v), v);
  }

  public bitfield get_have_pieces() {
    return new bitfield(libtorrent_jni.add_torrent_params_get_have_pieces(swigCPtr, this), true);
  }

  public void set_have_pieces(bitfield v) {
    libtorrent_jni.add_torrent_params_set_have_pieces(swigCPtr, this, bitfield.getCPtr(v), v);
  }

  public bitfield get_verified_pieces() {
    return new bitfield(libtorrent_jni.add_torrent_params_get_verified_pieces(swigCPtr, this), true);
  }

  public void set_verified_pieces(bitfield v) {
    libtorrent_jni.add_torrent_params_set_verified_pieces(swigCPtr, this, bitfield.getCPtr(v), v);
  }

  public string_vector get_http_seeds() {
    return new string_vector(libtorrent_jni.add_torrent_params_get_http_seeds(swigCPtr, this), true);
  }

  public void set_http_seeds(string_vector v) {
    libtorrent_jni.add_torrent_params_set_http_seeds(swigCPtr, this, string_vector.getCPtr(v), v);
  }

  public string_vector get_url_seeds() {
    return new string_vector(libtorrent_jni.add_torrent_params_get_url_seeds(swigCPtr, this), true);
  }

  public void set_url_seeds(string_vector v) {
    libtorrent_jni.add_torrent_params_set_url_seeds(swigCPtr, this, string_vector.getCPtr(v), v);
  }

  public tcp_endpoint_vector get_peers() {
    return new tcp_endpoint_vector(libtorrent_jni.add_torrent_params_get_peers(swigCPtr, this), true);
  }

  public void set_peers(tcp_endpoint_vector v) {
    libtorrent_jni.add_torrent_params_set_peers(swigCPtr, this, tcp_endpoint_vector.getCPtr(v), v);
  }

  public tcp_endpoint_vector get_banned_peers() {
    return new tcp_endpoint_vector(libtorrent_jni.add_torrent_params_get_banned_peers(swigCPtr, this), true);
  }

  public void set_banned_peers(tcp_endpoint_vector v) {
    libtorrent_jni.add_torrent_params_set_banned_peers(swigCPtr, this, tcp_endpoint_vector.getCPtr(v), v);
  }

}
