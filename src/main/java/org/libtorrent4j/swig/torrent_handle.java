/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class torrent_handle {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected torrent_handle(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(torrent_handle obj) {
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
        libtorrent_jni.delete_torrent_handle(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void read_piece(int piece) {
    libtorrent_jni.torrent_handle_read_piece(swigCPtr, this, piece);
  }

  public boolean have_piece(int piece) {
    return libtorrent_jni.torrent_handle_have_piece(swigCPtr, this, piece);
  }

  public void get_peer_info(peer_info_vector v) {
    libtorrent_jni.torrent_handle_get_peer_info(swigCPtr, this, peer_info_vector.getCPtr(v), v);
  }

  public torrent_status status(status_flags_t flags) {
    return new torrent_status(libtorrent_jni.torrent_handle_status__SWIG_0(swigCPtr, this, status_flags_t.getCPtr(flags), flags), true);
  }

  public torrent_status status() {
    return new torrent_status(libtorrent_jni.torrent_handle_status__SWIG_1(swigCPtr, this), true);
  }

  public partial_piece_info_vector get_download_queue() {
    return new partial_piece_info_vector(libtorrent_jni.torrent_handle_get_download_queue__SWIG_0(swigCPtr, this), true);
  }

  public void get_download_queue(partial_piece_info_vector queue) {
    libtorrent_jni.torrent_handle_get_download_queue__SWIG_1(swigCPtr, this, partial_piece_info_vector.getCPtr(queue), queue);
  }

  public void set_piece_deadline(int index, int deadline, deadline_flags_t flags) {
    libtorrent_jni.torrent_handle_set_piece_deadline__SWIG_0(swigCPtr, this, index, deadline, deadline_flags_t.getCPtr(flags), flags);
  }

  public void set_piece_deadline(int index, int deadline) {
    libtorrent_jni.torrent_handle_set_piece_deadline__SWIG_1(swigCPtr, this, index, deadline);
  }

  public void reset_piece_deadline(int index) {
    libtorrent_jni.torrent_handle_reset_piece_deadline(swigCPtr, this, index);
  }

  public void clear_piece_deadlines() {
    libtorrent_jni.torrent_handle_clear_piece_deadlines(swigCPtr, this);
  }

  public void file_progress(int64_vector progress, file_progress_flags_t flags) {
    libtorrent_jni.torrent_handle_file_progress__SWIG_0(swigCPtr, this, int64_vector.getCPtr(progress), progress, file_progress_flags_t.getCPtr(flags), flags);
  }

  public void file_progress(int64_vector progress) {
    libtorrent_jni.torrent_handle_file_progress__SWIG_1(swigCPtr, this, int64_vector.getCPtr(progress), progress);
  }

  public int64_vector file_progress(file_progress_flags_t flags) {
    return new int64_vector(libtorrent_jni.torrent_handle_file_progress__SWIG_2(swigCPtr, this, file_progress_flags_t.getCPtr(flags), flags), true);
  }

  public int64_vector file_progress() {
    return new int64_vector(libtorrent_jni.torrent_handle_file_progress__SWIG_3(swigCPtr, this), true);
  }

  public void clear_error() {
    libtorrent_jni.torrent_handle_clear_error(swigCPtr, this);
  }

  public announce_entry_vector trackers() {
    return new announce_entry_vector(libtorrent_jni.torrent_handle_trackers(swigCPtr, this), true);
  }

  public void replace_trackers(announce_entry_vector arg0) {
    libtorrent_jni.torrent_handle_replace_trackers(swigCPtr, this, announce_entry_vector.getCPtr(arg0), arg0);
  }

  public void add_tracker(announce_entry arg0) {
    libtorrent_jni.torrent_handle_add_tracker(swigCPtr, this, announce_entry.getCPtr(arg0), arg0);
  }

  public void add_url_seed(String url) {
    libtorrent_jni.torrent_handle_add_url_seed(swigCPtr, this, url);
  }

  public void remove_url_seed(String url) {
    libtorrent_jni.torrent_handle_remove_url_seed(swigCPtr, this, url);
  }

  public void add_http_seed(String url) {
    libtorrent_jni.torrent_handle_add_http_seed(swigCPtr, this, url);
  }

  public void remove_http_seed(String url) {
    libtorrent_jni.torrent_handle_remove_http_seed(swigCPtr, this, url);
  }

  public boolean is_valid() {
    return libtorrent_jni.torrent_handle_is_valid(swigCPtr, this);
  }

  public void pause(pause_flags_t flags) {
    libtorrent_jni.torrent_handle_pause__SWIG_0(swigCPtr, this, pause_flags_t.getCPtr(flags), flags);
  }

  public void pause() {
    libtorrent_jni.torrent_handle_pause__SWIG_1(swigCPtr, this);
  }

  public void resume() {
    libtorrent_jni.torrent_handle_resume(swigCPtr, this);
  }

  public torrent_flags_t flags() {
    return new torrent_flags_t(libtorrent_jni.torrent_handle_flags(swigCPtr, this), true);
  }

  public void set_flags(torrent_flags_t flags, torrent_flags_t mask) {
    libtorrent_jni.torrent_handle_set_flags__SWIG_0(swigCPtr, this, torrent_flags_t.getCPtr(flags), flags, torrent_flags_t.getCPtr(mask), mask);
  }

  public void set_flags(torrent_flags_t flags) {
    libtorrent_jni.torrent_handle_set_flags__SWIG_1(swigCPtr, this, torrent_flags_t.getCPtr(flags), flags);
  }

  public void unset_flags(torrent_flags_t flags) {
    libtorrent_jni.torrent_handle_unset_flags(swigCPtr, this, torrent_flags_t.getCPtr(flags), flags);
  }

  public void flush_cache() {
    libtorrent_jni.torrent_handle_flush_cache(swigCPtr, this);
  }

  public void force_recheck() {
    libtorrent_jni.torrent_handle_force_recheck(swigCPtr, this);
  }

  public void save_resume_data(resume_data_flags_t flags) {
    libtorrent_jni.torrent_handle_save_resume_data__SWIG_0(swigCPtr, this, resume_data_flags_t.getCPtr(flags), flags);
  }

  public void save_resume_data() {
    libtorrent_jni.torrent_handle_save_resume_data__SWIG_1(swigCPtr, this);
  }

  public boolean need_save_resume_data() {
    return libtorrent_jni.torrent_handle_need_save_resume_data(swigCPtr, this);
  }

  public void queue_position_up() {
    libtorrent_jni.torrent_handle_queue_position_up(swigCPtr, this);
  }

  public void queue_position_down() {
    libtorrent_jni.torrent_handle_queue_position_down(swigCPtr, this);
  }

  public void queue_position_top() {
    libtorrent_jni.torrent_handle_queue_position_top(swigCPtr, this);
  }

  public void queue_position_bottom() {
    libtorrent_jni.torrent_handle_queue_position_bottom(swigCPtr, this);
  }

  public void set_ssl_certificate(String certificate, String private_key, String dh_params, String passphrase) {
    libtorrent_jni.torrent_handle_set_ssl_certificate__SWIG_0(swigCPtr, this, certificate, private_key, dh_params, passphrase);
  }

  public void set_ssl_certificate(String certificate, String private_key, String dh_params) {
    libtorrent_jni.torrent_handle_set_ssl_certificate__SWIG_1(swigCPtr, this, certificate, private_key, dh_params);
  }

  public void piece_availability(int_vector avail) {
    libtorrent_jni.torrent_handle_piece_availability(swigCPtr, this, int_vector.getCPtr(avail), avail);
  }

  public void force_reannounce(int seconds, int idx, reannounce_flags_t arg2) {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_0(swigCPtr, this, seconds, idx, reannounce_flags_t.getCPtr(arg2), arg2);
  }

  public void force_reannounce(int seconds, int idx) {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_1(swigCPtr, this, seconds, idx);
  }

  public void force_reannounce(int seconds) {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_2(swigCPtr, this, seconds);
  }

  public void force_reannounce() {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_3(swigCPtr, this);
  }

  public void force_dht_announce() {
    libtorrent_jni.torrent_handle_force_dht_announce(swigCPtr, this);
  }

  public void force_lsd_announce() {
    libtorrent_jni.torrent_handle_force_lsd_announce(swigCPtr, this);
  }

  public void scrape_tracker(int idx) {
    libtorrent_jni.torrent_handle_scrape_tracker__SWIG_0(swigCPtr, this, idx);
  }

  public void scrape_tracker() {
    libtorrent_jni.torrent_handle_scrape_tracker__SWIG_1(swigCPtr, this);
  }

  public void set_upload_limit(int limit) {
    libtorrent_jni.torrent_handle_set_upload_limit(swigCPtr, this, limit);
  }

  public int upload_limit() {
    return libtorrent_jni.torrent_handle_upload_limit(swigCPtr, this);
  }

  public void set_download_limit(int limit) {
    libtorrent_jni.torrent_handle_set_download_limit(swigCPtr, this, limit);
  }

  public int download_limit() {
    return libtorrent_jni.torrent_handle_download_limit(swigCPtr, this);
  }

  public void connect_peer(tcp_endpoint adr, peer_source_flags_t source, pex_flags_t flags) {
    libtorrent_jni.torrent_handle_connect_peer__SWIG_0(swigCPtr, this, tcp_endpoint.getCPtr(adr), adr, peer_source_flags_t.getCPtr(source), source, pex_flags_t.getCPtr(flags), flags);
  }

  public void connect_peer(tcp_endpoint adr, peer_source_flags_t source) {
    libtorrent_jni.torrent_handle_connect_peer__SWIG_1(swigCPtr, this, tcp_endpoint.getCPtr(adr), adr, peer_source_flags_t.getCPtr(source), source);
  }

  public void connect_peer(tcp_endpoint adr) {
    libtorrent_jni.torrent_handle_connect_peer__SWIG_2(swigCPtr, this, tcp_endpoint.getCPtr(adr), adr);
  }

  public void clear_peers() {
    libtorrent_jni.torrent_handle_clear_peers(swigCPtr, this);
  }

  public void set_max_uploads(int max_uploads) {
    libtorrent_jni.torrent_handle_set_max_uploads(swigCPtr, this, max_uploads);
  }

  public int max_uploads() {
    return libtorrent_jni.torrent_handle_max_uploads(swigCPtr, this);
  }

  public void set_max_connections(int max_connections) {
    libtorrent_jni.torrent_handle_set_max_connections(swigCPtr, this, max_connections);
  }

  public int max_connections() {
    return libtorrent_jni.torrent_handle_max_connections(swigCPtr, this);
  }

  public void move_storage(String save_path, move_flags_t flags) {
    libtorrent_jni.torrent_handle_move_storage__SWIG_0(swigCPtr, this, save_path, flags.swigValue());
  }

  public void move_storage(String save_path) {
    libtorrent_jni.torrent_handle_move_storage__SWIG_1(swigCPtr, this, save_path);
  }

  public void rename_file(int index, String new_name) {
    libtorrent_jni.torrent_handle_rename_file(swigCPtr, this, index, new_name);
  }

  public sha1_hash info_hash() {
    return new sha1_hash(libtorrent_jni.torrent_handle_info_hash(swigCPtr, this), true);
  }

  public info_hash_t info_hashes() {
    return new info_hash_t(libtorrent_jni.torrent_handle_info_hashes(swigCPtr, this), true);
  }

  public boolean eq(torrent_handle h) {
    return libtorrent_jni.torrent_handle_eq(swigCPtr, this, torrent_handle.getCPtr(h), h);
  }

  public boolean ne(torrent_handle h) {
    return libtorrent_jni.torrent_handle_ne(swigCPtr, this, torrent_handle.getCPtr(h), h);
  }

  public boolean lt(torrent_handle h) {
    return libtorrent_jni.torrent_handle_lt(swigCPtr, this, torrent_handle.getCPtr(h), h);
  }

  public long id() {
    return libtorrent_jni.torrent_handle_id(swigCPtr, this);
  }

  public client_data_t userdata() {
    return new client_data_t(libtorrent_jni.torrent_handle_userdata(swigCPtr, this), true);
  }

  public void add_piece_bytes(int piece, byte_vector data, add_piece_flags_t flags) {
    libtorrent_jni.torrent_handle_add_piece_bytes__SWIG_0(swigCPtr, this, piece, byte_vector.getCPtr(data), data, add_piece_flags_t.getCPtr(flags), flags);
  }

  public void add_piece_bytes(int piece, byte_vector data) {
    libtorrent_jni.torrent_handle_add_piece_bytes__SWIG_1(swigCPtr, this, piece, byte_vector.getCPtr(data), data);
  }

  public torrent_info torrent_file_ptr() {
    long cPtr = libtorrent_jni.torrent_handle_torrent_file_ptr(swigCPtr, this);
    return (cPtr == 0) ? null : new torrent_info(cPtr, false);
  }

  public string_vector get_url_seeds() {
    return new string_vector(libtorrent_jni.torrent_handle_get_url_seeds(swigCPtr, this), true);
  }

  public string_vector get_http_seeds() {
    return new string_vector(libtorrent_jni.torrent_handle_get_http_seeds(swigCPtr, this), true);
  }

  public void set_ssl_certificate_buffer_ex(byte_vector certificate, byte_vector private_key, byte_vector dh_params) {
    libtorrent_jni.torrent_handle_set_ssl_certificate_buffer_ex(swigCPtr, this, byte_vector.getCPtr(certificate), certificate, byte_vector.getCPtr(private_key), private_key, byte_vector.getCPtr(dh_params), dh_params);
  }

  public int queue_position_ex() {
    return libtorrent_jni.torrent_handle_queue_position_ex(swigCPtr, this);
  }

  public void queue_position_set_ex(int p) {
    libtorrent_jni.torrent_handle_queue_position_set_ex(swigCPtr, this, p);
  }

  public int piece_priority_ex(int index) {
    return libtorrent_jni.torrent_handle_piece_priority_ex__SWIG_0(swigCPtr, this, index);
  }

  public void piece_priority_ex(int index, int priority) {
    libtorrent_jni.torrent_handle_piece_priority_ex__SWIG_1(swigCPtr, this, index, priority);
  }

  public void prioritize_pieces_ex(int_vector pieces) {
    libtorrent_jni.torrent_handle_prioritize_pieces_ex__SWIG_0(swigCPtr, this, int_vector.getCPtr(pieces), pieces);
  }

  public void prioritize_pieces_ex(int_int_pair_vector pieces) {
    libtorrent_jni.torrent_handle_prioritize_pieces_ex__SWIG_1(swigCPtr, this, int_int_pair_vector.getCPtr(pieces), pieces);
  }

  public byte_vector get_piece_priorities_ex() {
    return new byte_vector(libtorrent_jni.torrent_handle_get_piece_priorities_ex(swigCPtr, this), true);
  }

  public int file_priority_ex(int index) {
    return libtorrent_jni.torrent_handle_file_priority_ex__SWIG_0(swigCPtr, this, index);
  }

  public void file_priority_ex(int index, int priority) {
    libtorrent_jni.torrent_handle_file_priority_ex__SWIG_1(swigCPtr, this, index, priority);
  }

  public void prioritize_files_ex(int_vector files) {
    libtorrent_jni.torrent_handle_prioritize_files_ex(swigCPtr, this, int_vector.getCPtr(files), files);
  }

  public byte_vector get_file_priorities_ex() {
    return new byte_vector(libtorrent_jni.torrent_handle_get_file_priorities_ex(swigCPtr, this), true);
  }

  public final static add_piece_flags_t overwrite_existing = new add_piece_flags_t(libtorrent_jni.torrent_handle_overwrite_existing_get(), false);
  public final static status_flags_t query_distributed_copies = new status_flags_t(libtorrent_jni.torrent_handle_query_distributed_copies_get(), false);
  public final static status_flags_t query_accurate_download_counters = new status_flags_t(libtorrent_jni.torrent_handle_query_accurate_download_counters_get(), false);
  public final static status_flags_t query_last_seen_complete = new status_flags_t(libtorrent_jni.torrent_handle_query_last_seen_complete_get(), false);
  public final static status_flags_t query_pieces = new status_flags_t(libtorrent_jni.torrent_handle_query_pieces_get(), false);
  public final static status_flags_t query_verified_pieces = new status_flags_t(libtorrent_jni.torrent_handle_query_verified_pieces_get(), false);
  public final static status_flags_t query_torrent_file = new status_flags_t(libtorrent_jni.torrent_handle_query_torrent_file_get(), false);
  public final static status_flags_t query_name = new status_flags_t(libtorrent_jni.torrent_handle_query_name_get(), false);
  public final static status_flags_t query_save_path = new status_flags_t(libtorrent_jni.torrent_handle_query_save_path_get(), false);
  public final static deadline_flags_t alert_when_available = new deadline_flags_t(libtorrent_jni.torrent_handle_alert_when_available_get(), false);
  public final static file_progress_flags_t piece_granularity = new file_progress_flags_t(libtorrent_jni.torrent_handle_piece_granularity_get(), false);
  public final static pause_flags_t graceful_pause = new pause_flags_t(libtorrent_jni.torrent_handle_graceful_pause_get(), false);
  public final static pause_flags_t clear_disk_cache = new pause_flags_t(libtorrent_jni.torrent_handle_clear_disk_cache_get(), false);
  public final static resume_data_flags_t flush_disk_cache = new resume_data_flags_t(libtorrent_jni.torrent_handle_flush_disk_cache_get(), false);
  public final static resume_data_flags_t save_info_dict = new resume_data_flags_t(libtorrent_jni.torrent_handle_save_info_dict_get(), false);
  public final static resume_data_flags_t only_if_modified = new resume_data_flags_t(libtorrent_jni.torrent_handle_only_if_modified_get(), false);
  public final static reannounce_flags_t ignore_min_interval = new reannounce_flags_t(libtorrent_jni.torrent_handle_ignore_min_interval_get(), false);
}
