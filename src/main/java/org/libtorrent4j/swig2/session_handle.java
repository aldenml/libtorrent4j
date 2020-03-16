/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class session_handle {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected session_handle(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(session_handle obj) {
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
        libtorrent_jni.delete_session_handle(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public session_handle() {
    this(libtorrent_jni.new_session_handle__SWIG_0(), true);
  }

  public session_handle(session_handle t) {
    this(libtorrent_jni.new_session_handle__SWIG_1(session_handle.getCPtr(t), t), true);
  }

  public boolean is_valid() {
    return libtorrent_jni.session_handle_is_valid(swigCPtr, this);
  }

  public session_params session_state(save_state_flags_t flags) {
    return new session_params(libtorrent_jni.session_handle_session_state__SWIG_0(swigCPtr, this, save_state_flags_t.getCPtr(flags), flags), true);
  }

  public session_params session_state() {
    return new session_params(libtorrent_jni.session_handle_session_state__SWIG_1(swigCPtr, this), true);
  }

  public void refresh_torrent_status(torrent_status_vector ret, status_flags_t flags) {
    libtorrent_jni.session_handle_refresh_torrent_status__SWIG_0(swigCPtr, this, torrent_status_vector.getCPtr(ret), ret, status_flags_t.getCPtr(flags), flags);
  }

  public void refresh_torrent_status(torrent_status_vector ret) {
    libtorrent_jni.session_handle_refresh_torrent_status__SWIG_1(swigCPtr, this, torrent_status_vector.getCPtr(ret), ret);
  }

  public void post_torrent_updates(status_flags_t flags) {
    libtorrent_jni.session_handle_post_torrent_updates__SWIG_0(swigCPtr, this, status_flags_t.getCPtr(flags), flags);
  }

  public void post_torrent_updates() {
    libtorrent_jni.session_handle_post_torrent_updates__SWIG_1(swigCPtr, this);
  }

  public void post_session_stats() {
    libtorrent_jni.session_handle_post_session_stats(swigCPtr, this);
  }

  public void post_dht_stats() {
    libtorrent_jni.session_handle_post_dht_stats(swigCPtr, this);
  }

  public void set_dht_state(dht_state st) {
    libtorrent_jni.session_handle_set_dht_state__SWIG_0(swigCPtr, this, dht_state.getCPtr(st), st);
  }

  public torrent_handle find_torrent(sha1_hash info_hash) {
    return new torrent_handle(libtorrent_jni.session_handle_find_torrent(swigCPtr, this, sha1_hash.getCPtr(info_hash), info_hash), true);
  }

  public torrent_handle_vector get_torrents() {
    return new torrent_handle_vector(libtorrent_jni.session_handle_get_torrents(swigCPtr, this), true);
  }

  public torrent_handle add_torrent(add_torrent_params params, error_code ec) {
    return new torrent_handle(libtorrent_jni.session_handle_add_torrent(swigCPtr, this, add_torrent_params.getCPtr(params), params, error_code.getCPtr(ec), ec), true);
  }

  public void async_add_torrent(add_torrent_params params) {
    libtorrent_jni.session_handle_async_add_torrent(swigCPtr, this, add_torrent_params.getCPtr(params), params);
  }

  public void pause() {
    libtorrent_jni.session_handle_pause(swigCPtr, this);
  }

  public void resume() {
    libtorrent_jni.session_handle_resume(swigCPtr, this);
  }

  public boolean is_paused() {
    return libtorrent_jni.session_handle_is_paused(swigCPtr, this);
  }

  public boolean is_dht_running() {
    return libtorrent_jni.session_handle_is_dht_running(swigCPtr, this);
  }

  public void add_dht_node(string_int_pair node) {
    libtorrent_jni.session_handle_add_dht_node(swigCPtr, this, string_int_pair.getCPtr(node), node);
  }

  public void dht_get_item(sha1_hash target) {
    libtorrent_jni.session_handle_dht_get_item__SWIG_0(swigCPtr, this, sha1_hash.getCPtr(target), target);
  }

  public sha1_hash dht_put_item(entry data) {
    return new sha1_hash(libtorrent_jni.session_handle_dht_put_item__SWIG_0(swigCPtr, this, entry.getCPtr(data), data), true);
  }

  public void dht_get_peers(sha1_hash info_hash) {
    libtorrent_jni.session_handle_dht_get_peers(swigCPtr, this, sha1_hash.getCPtr(info_hash), info_hash);
  }

  public void dht_live_nodes(sha1_hash nid) {
    libtorrent_jni.session_handle_dht_live_nodes(swigCPtr, this, sha1_hash.getCPtr(nid), nid);
  }

  public void dht_sample_infohashes(udp_endpoint ep, sha1_hash target) {
    libtorrent_jni.session_handle_dht_sample_infohashes(swigCPtr, this, udp_endpoint.getCPtr(ep), ep, sha1_hash.getCPtr(target), target);
  }

  public void dht_direct_request(udp_endpoint ep, entry e, client_data_t userdata) {
    libtorrent_jni.session_handle_dht_direct_request__SWIG_0(swigCPtr, this, udp_endpoint.getCPtr(ep), ep, entry.getCPtr(e), e, client_data_t.getCPtr(userdata), userdata);
  }

  public void dht_direct_request(udp_endpoint ep, entry e) {
    libtorrent_jni.session_handle_dht_direct_request__SWIG_1(swigCPtr, this, udp_endpoint.getCPtr(ep), ep, entry.getCPtr(e), e);
  }

  public void set_ip_filter(ip_filter f) {
    libtorrent_jni.session_handle_set_ip_filter(swigCPtr, this, ip_filter.getCPtr(f), f);
  }

  public ip_filter get_ip_filter() {
    return new ip_filter(libtorrent_jni.session_handle_get_ip_filter(swigCPtr, this), true);
  }

  public void set_port_filter(port_filter f) {
    libtorrent_jni.session_handle_set_port_filter(swigCPtr, this, port_filter.getCPtr(f), f);
  }

  public int listen_port() {
    return libtorrent_jni.session_handle_listen_port(swigCPtr, this);
  }

  public int ssl_listen_port() {
    return libtorrent_jni.session_handle_ssl_listen_port(swigCPtr, this);
  }

  public boolean is_listening() {
    return libtorrent_jni.session_handle_is_listening(swigCPtr, this);
  }

  public void set_peer_class_filter(ip_filter f) {
    libtorrent_jni.session_handle_set_peer_class_filter(swigCPtr, this, ip_filter.getCPtr(f), f);
  }

  public ip_filter get_peer_class_filter() {
    return new ip_filter(libtorrent_jni.session_handle_get_peer_class_filter(swigCPtr, this), true);
  }

  public void set_peer_class_type_filter(peer_class_type_filter f) {
    libtorrent_jni.session_handle_set_peer_class_type_filter(swigCPtr, this, peer_class_type_filter.getCPtr(f), f);
  }

  public peer_class_type_filter get_peer_class_type_filter() {
    return new peer_class_type_filter(libtorrent_jni.session_handle_get_peer_class_type_filter(swigCPtr, this), true);
  }

  public void remove_torrent(torrent_handle arg0, remove_flags_t arg1) {
    libtorrent_jni.session_handle_remove_torrent__SWIG_0(swigCPtr, this, torrent_handle.getCPtr(arg0), arg0, remove_flags_t.getCPtr(arg1), arg1);
  }

  public void remove_torrent(torrent_handle arg0) {
    libtorrent_jni.session_handle_remove_torrent__SWIG_1(swigCPtr, this, torrent_handle.getCPtr(arg0), arg0);
  }

  public void apply_settings(settings_pack arg0) {
    libtorrent_jni.session_handle_apply_settings(swigCPtr, this, settings_pack.getCPtr(arg0), arg0);
  }

  public settings_pack get_settings() {
    return new settings_pack(libtorrent_jni.session_handle_get_settings(swigCPtr, this), true);
  }

  public void pop_alerts(alert_ptr_vector alerts) {
    libtorrent_jni.session_handle_pop_alerts(swigCPtr, this, alert_ptr_vector.getCPtr(alerts), alerts);
  }

  public void reopen_network_sockets(reopen_network_flags_t options) {
    libtorrent_jni.session_handle_reopen_network_sockets__SWIG_0(swigCPtr, this, reopen_network_flags_t.getCPtr(options), options);
  }

  public void reopen_network_sockets() {
    libtorrent_jni.session_handle_reopen_network_sockets__SWIG_1(swigCPtr, this);
  }

  public void dht_get_item(byte_vector key, byte_vector salt) {
    libtorrent_jni.session_handle_dht_get_item__SWIG_1(swigCPtr, this, byte_vector.getCPtr(key), key, byte_vector.getCPtr(salt), salt);
  }

  public void dht_put_item(byte_vector key, byte_vector sk, entry data, byte_vector salt) {
    libtorrent_jni.session_handle_dht_put_item__SWIG_1(swigCPtr, this, byte_vector.getCPtr(key), key, byte_vector.getCPtr(sk), sk, entry.getCPtr(data), data, byte_vector.getCPtr(salt), salt);
  }

  public void dht_direct_request(udp_endpoint ep, entry e, long userdata) {
    libtorrent_jni.session_handle_dht_direct_request__SWIG_2(swigCPtr, this, udp_endpoint.getCPtr(ep), ep, entry.getCPtr(e), e, userdata);
  }

  public alert wait_for_alert_ms(long max_wait) {
    long cPtr = libtorrent_jni.session_handle_wait_for_alert_ms(swigCPtr, this, max_wait);
    return (cPtr == 0) ? null : new alert(cPtr, false);
  }

  public void set_alert_notify_callback(alert_notify_callback cb) {
    libtorrent_jni.session_handle_set_alert_notify_callback(swigCPtr, this, alert_notify_callback.getCPtr(cb), cb);
  }

  public final static save_state_flags_t save_settings = new save_state_flags_t(libtorrent_jni.session_handle_save_settings_get(), false);
  public final static save_state_flags_t save_dht_state = new save_state_flags_t(libtorrent_jni.session_handle_save_dht_state_get(), false);
  public final static save_state_flags_t save_extension_state = new save_state_flags_t(libtorrent_jni.session_handle_save_extension_state_get(), false);
  public final static save_state_flags_t save_ip_filter = new save_state_flags_t(libtorrent_jni.session_handle_save_ip_filter_get(), false);
  public final static remove_flags_t delete_files = new remove_flags_t(libtorrent_jni.session_handle_delete_files_get(), false);
  public final static remove_flags_t delete_partfile = new remove_flags_t(libtorrent_jni.session_handle_delete_partfile_get(), false);
  public final static portmap_protocol udp = portmap_protocol.swigToEnum(libtorrent_jni.session_handle_udp_get());
  public final static portmap_protocol tcp = portmap_protocol.swigToEnum(libtorrent_jni.session_handle_tcp_get());
  public final static reopen_network_flags_t reopen_map_ports = new reopen_network_flags_t(libtorrent_jni.session_handle_reopen_map_ports_get(), false);
}
