/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class libtorrent {
  public static boolean op_eq(error_code lhs, error_code rhs) {
    return libtorrent_jni.op_eq__SWIG_1(error_code.getCPtr(lhs), lhs, error_code.getCPtr(rhs), rhs);
  }

  public static boolean op_lt(error_code lhs, error_code rhs) {
    return libtorrent_jni.op_lt__SWIG_1(error_code.getCPtr(lhs), lhs, error_code.getCPtr(rhs), rhs);
  }

  public static error_code make_error_code(errc_t e) {
    return new error_code(libtorrent_jni.make_error_code(e.swigValue()), true);
  }

  public static long getNum_protocols() {
    return libtorrent_jni.num_protocols_get();
  }

  public static boolean op_ne(info_hash_t lhs, info_hash_t rhs) {
    return libtorrent_jni.op_ne(info_hash_t.getCPtr(lhs), lhs, info_hash_t.getCPtr(rhs), rhs);
  }

  public static boolean op_eq(info_hash_t lhs, info_hash_t rhs) {
    return libtorrent_jni.op_eq(info_hash_t.getCPtr(lhs), lhs, info_hash_t.getCPtr(rhs), rhs);
  }

  public static String operation_name(operation_t op) {
    return libtorrent_jni.operation_name(op.swigValue());
  }

  public static String print_entry(bdecode_node e, boolean single_line, int indent) {
    return libtorrent_jni.print_entry__SWIG_0(bdecode_node.getCPtr(e), e, single_line, indent);
  }

  public static String print_entry(bdecode_node e, boolean single_line) {
    return libtorrent_jni.print_entry__SWIG_1(bdecode_node.getCPtr(e), e, single_line);
  }

  public static String print_entry(bdecode_node e) {
    return libtorrent_jni.print_entry__SWIG_2(bdecode_node.getCPtr(e), e);
  }

  public static torrent_flags_t getSeed_mode() {
    long cPtr = libtorrent_jni.seed_mode_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getUpload_mode() {
    long cPtr = libtorrent_jni.upload_mode_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getShare_mode() {
    long cPtr = libtorrent_jni.share_mode_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getApply_ip_filter() {
    long cPtr = libtorrent_jni.apply_ip_filter_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getPaused() {
    long cPtr = libtorrent_jni.paused_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getAuto_managed() {
    long cPtr = libtorrent_jni.auto_managed_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getDuplicate_is_error() {
    long cPtr = libtorrent_jni.duplicate_is_error_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getUpdate_subscribe() {
    long cPtr = libtorrent_jni.update_subscribe_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getSuper_seeding() {
    long cPtr = libtorrent_jni.super_seeding_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getSequential_download() {
    long cPtr = libtorrent_jni.sequential_download_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getStop_when_ready() {
    long cPtr = libtorrent_jni.stop_when_ready_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getOverride_trackers() {
    long cPtr = libtorrent_jni.override_trackers_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getOverride_web_seeds() {
    long cPtr = libtorrent_jni.override_web_seeds_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getNeed_save_resume() {
    long cPtr = libtorrent_jni.need_save_resume_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getDisable_dht() {
    long cPtr = libtorrent_jni.disable_dht_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getDisable_lsd() {
    long cPtr = libtorrent_jni.disable_lsd_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getDisable_pex() {
    long cPtr = libtorrent_jni.disable_pex_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getAll() {
    long cPtr = libtorrent_jni.all_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static torrent_flags_t getDefault_flags() {
    long cPtr = libtorrent_jni.default_flags_get();
    return (cPtr == 0) ? null : new torrent_flags_t(cPtr, false);
  }

  public static close_reason_t error_to_close_reason(error_code ec) {
    return close_reason_t.swigToEnum(libtorrent_jni.error_to_close_reason(error_code.getCPtr(ec), ec));
  }

  public static pex_flags_t getPex_encryption() {
    long cPtr = libtorrent_jni.pex_encryption_get();
    return (cPtr == 0) ? null : new pex_flags_t(cPtr, false);
  }

  public static pex_flags_t getPex_seed() {
    long cPtr = libtorrent_jni.pex_seed_get();
    return (cPtr == 0) ? null : new pex_flags_t(cPtr, false);
  }

  public static pex_flags_t getPex_utp() {
    long cPtr = libtorrent_jni.pex_utp_get();
    return (cPtr == 0) ? null : new pex_flags_t(cPtr, false);
  }

  public static pex_flags_t getPex_holepunch() {
    long cPtr = libtorrent_jni.pex_holepunch_get();
    return (cPtr == 0) ? null : new pex_flags_t(cPtr, false);
  }

  public static pex_flags_t getPex_lt_v2() {
    long cPtr = libtorrent_jni.pex_lt_v2_get();
    return (cPtr == 0) ? null : new pex_flags_t(cPtr, false);
  }

  public static String socket_type_name(socket_type_t arg0) {
    return libtorrent_jni.socket_type_name(arg0.swigValue());
  }

  public static String alert_name(int alert_type) {
    return libtorrent_jni.alert_name(alert_type);
  }

  public static int getUser_alert_id() {
    return libtorrent_jni.user_alert_id_get();
  }

  public static int getNum_alert_types() {
    return libtorrent_jni.num_alert_types_get();
  }

  public static int getAbi_alert_count() {
    return libtorrent_jni.abi_alert_count_get();
  }

  public static settings_pack load_pack_from_dict(bdecode_node settings) {
    return new settings_pack(libtorrent_jni.load_pack_from_dict(bdecode_node.getCPtr(settings), settings), true);
  }

  public static void save_settings_to_dict(settings_pack sett, string_entry_map out) {
    libtorrent_jni.save_settings_to_dict(settings_pack.getCPtr(sett), sett, string_entry_map.getCPtr(out), out);
  }

  public static String name_for_setting(int s) {
    return libtorrent_jni.name_for_setting(s);
  }

  public static settings_pack default_settings() {
    return new settings_pack(libtorrent_jni.default_settings(), true);
  }

  public static settings_pack min_memory_usage() {
    return new settings_pack(libtorrent_jni.min_memory_usage(), true);
  }

  public static settings_pack high_performance_seed() {
    return new settings_pack(libtorrent_jni.high_performance_seed(), true);
  }

  public static void add_files(file_storage fs, String file, create_flags_t flags) {
    libtorrent_jni.add_files__SWIG_0(file_storage.getCPtr(fs), fs, file, create_flags_t.getCPtr(flags), flags);
  }

  public static void add_files(file_storage fs, String file) {
    libtorrent_jni.add_files__SWIG_1(file_storage.getCPtr(fs), fs, file);
  }

  public static void set_piece_hashes(create_torrent t, String p, error_code ec) {
    libtorrent_jni.set_piece_hashes(create_torrent.getCPtr(t), t, p, error_code.getCPtr(ec), ec);
  }

  public static stats_metric_vector session_stats_metrics() {
    return new stats_metric_vector(libtorrent_jni.session_stats_metrics(), true);
  }

  public static String version() {
    return libtorrent_jni.version();
  }

  public static String make_magnet_uri(torrent_handle handle) {
    return libtorrent_jni.make_magnet_uri__SWIG_0(torrent_handle.getCPtr(handle), handle);
  }

  public static String make_magnet_uri(torrent_info info) {
    return libtorrent_jni.make_magnet_uri__SWIG_1(torrent_info.getCPtr(info), info);
  }

  public static String generate_fingerprint(String name, int major, int minor, int revision, int tag) {
    return libtorrent_jni.generate_fingerprint__SWIG_0(name, major, minor, revision, tag);
  }

  public static String generate_fingerprint(String name, int major, int minor, int revision) {
    return libtorrent_jni.generate_fingerprint__SWIG_1(name, major, minor, revision);
  }

  public static String generate_fingerprint(String name, int major, int minor) {
    return libtorrent_jni.generate_fingerprint__SWIG_2(name, major, minor);
  }

  public static String generate_fingerprint(String name, int major) {
    return libtorrent_jni.generate_fingerprint__SWIG_3(name, major);
  }

  public static int find_metric_idx_ex(String name) {
    return libtorrent_jni.find_metric_idx_ex(name);
  }

  public static String boost_lib_version() {
    return libtorrent_jni.boost_lib_version();
  }

  public static String openssl_version_text() {
    return libtorrent_jni.openssl_version_text();
  }

  public static boolean arm_neon_support() {
    return libtorrent_jni.arm_neon_support();
  }

  public static byte_vector ed25519_create_seed() {
    return new byte_vector(libtorrent_jni.ed25519_create_seed(), true);
  }

  public static byte_vector_byte_vector_pair ed25519_create_keypair(byte_vector seed) {
    return new byte_vector_byte_vector_pair(libtorrent_jni.ed25519_create_keypair(byte_vector.getCPtr(seed), seed), true);
  }

  public static byte_vector ed25519_sign(byte_vector msg, byte_vector pk, byte_vector sk) {
    return new byte_vector(libtorrent_jni.ed25519_sign(byte_vector.getCPtr(msg), msg, byte_vector.getCPtr(pk), pk, byte_vector.getCPtr(sk), sk), true);
  }

  public static boolean ed25519_verify(byte_vector sig, byte_vector msg, byte_vector pk) {
    return libtorrent_jni.ed25519_verify(byte_vector.getCPtr(sig), sig, byte_vector.getCPtr(msg), msg, byte_vector.getCPtr(pk), pk);
  }

  public static byte_vector ed25519_add_scalar_public(byte_vector pk, byte_vector scalar) {
    return new byte_vector(libtorrent_jni.ed25519_add_scalar_public(byte_vector.getCPtr(pk), pk, byte_vector.getCPtr(scalar), scalar), true);
  }

  public static byte_vector ed25519_add_scalar_secret(byte_vector sk, byte_vector scalar) {
    return new byte_vector(libtorrent_jni.ed25519_add_scalar_secret(byte_vector.getCPtr(sk), sk, byte_vector.getCPtr(scalar), scalar), true);
  }

  public static byte_vector ed25519_key_exchange(byte_vector pk, byte_vector sk) {
    return new byte_vector(libtorrent_jni.ed25519_key_exchange(byte_vector.getCPtr(pk), pk, byte_vector.getCPtr(sk), sk), true);
  }

  public static ip_interface_vector enum_net_interfaces(session s) {
    return new ip_interface_vector(libtorrent_jni.enum_net_interfaces(session.getCPtr(s), s), true);
  }

  public static ip_route_vector enum_routes(session s) {
    return new ip_route_vector(libtorrent_jni.enum_routes(session.getCPtr(s), s), true);
  }

  public static address get_gateway(ip_interface iface, ip_route_vector routes) {
    return new address(libtorrent_jni.get_gateway(ip_interface.getCPtr(iface), iface, ip_route_vector.getCPtr(routes), routes), true);
  }

  public static String device_for_address(session s, address addr, error_code ec) {
    return libtorrent_jni.device_for_address(session.getCPtr(s), s, address.getCPtr(addr), addr, error_code.getCPtr(ec), ec);
  }

  public static void add_files_ex(file_storage fs, String file, add_files_listener listener, create_flags_t flags) {
    libtorrent_jni.add_files_ex(file_storage.getCPtr(fs), fs, file, add_files_listener.getCPtr(listener), listener, create_flags_t.getCPtr(flags), flags);
  }

  public static void set_piece_hashes_ex(create_torrent t, String p, set_piece_hashes_listener listener, error_code ec) {
    libtorrent_jni.set_piece_hashes_ex(create_torrent.getCPtr(t), t, p, set_piece_hashes_listener.getCPtr(listener), listener, error_code.getCPtr(ec), ec);
  }

  public static void set_posix_wrapper(posix_wrapper obj) {
    libtorrent_jni.set_posix_wrapper(posix_wrapper.getCPtr(obj), obj);
  }

  public static void set_posix_errno(int val) {
    libtorrent_jni.set_posix_errno(val);
  }

}
