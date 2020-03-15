/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

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

}
