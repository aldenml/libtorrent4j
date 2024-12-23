/*
 * Copyright (c) 2018-2024, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.libtorrent;
import org.libtorrent4j.swig.settings_pack;
import org.libtorrent4j.swig.settings_pack.int_types;
import org.libtorrent4j.swig.settings_pack.string_types;

/**
 * The ``settings_pack`` struct, contains the names of all settings as
 * enum values. These values are passed in to the ``set_str()``,
 * ``set_int()``, ``set_bool()`` functions, to specify the setting to
 * change.
 *
 * @author gubatron
 * @author aldenml
 */
public final class SettingsPack
    extends SwigObject<settings_pack> {

    /**
     * @param sp the native object
     */
    public SettingsPack(settings_pack sp) {
        super(sp);
    }

    /**
     * Example, how to turn on the DHT using SettingsPack.
     * <pre>{@code
     * SettingsPack pack = new SettingsPack();
     * pack.setBoolean(settings_pack.bool_types.enable_dht.swigValue(), on);
     * s.applySettings(pack);
     * }</pre>
     */
    public SettingsPack() {
        this(new settings_pack());
    }

    /**
     * @param name
     *
     */
    public boolean getBoolean(int name) {
        return h.get_bool(name);
    }

    /**
     * @param name
     * @param value
     */
    public SettingsPack setBoolean(int name, boolean value) {
        h.set_bool(name, value);
        return this;
    }

    /**
     * @param name
     *
     */
    public int getInteger(int name) {
        return h.get_int(name);
    }

    /**
     * @param name
     * @param value
     */
    public SettingsPack setInteger(int name, int value) {
        h.set_int(name, value);
        return this;
    }

    /**
     * @param name
     *
     */
    public String getString(int name) {
        return h.get_str(name);
    }

    /**
     * @param name
     * @param value
     */
    public SettingsPack setString(int name, String value) {
        h.set_str(name, value);
        return this;
    }

    public byte[] getBytes(int name) {
        byte_vector v = h.get_bytes(name);
        return Vectors.byte_vector2bytes(v);
    }

    public void setBytes(int name, byte[] value) {
        byte_vector v = Vectors.bytes2byte_vector(value);
        h.set_bytes(name, v);
    }

    public void clear() {
        h.clear();
    }

    public void clear(int name) {
        h.clear(name);
    }

    /**
     * Queries whether the specified configuration option has a value set in
     * this pack. ``name`` can be any enumeration value from string_types,
     * int_types or bool_types.
     *
     * @param name name id of the setting
     * @return true if present
     */
    public boolean hasValue(int name) {
        return h.has_val(name);
    }

    /**
     * The fingerprint for the client.
     *
     * It will be used as the prefix to the peer-id. If this is 20 bytes (or longer)
     * it will be truncated to 20 bytes and used as the entire peer-id.
     */
    public byte[] getPeerFingerprint() {
        return getBytes(string_types.peer_fingerprint.swigValue());
    }

    /**
     * The fingerprint for the client.
     *
     * It will be used as the prefix to the peer-id. If this is 20 bytes (or longer)
     * it will be truncated to 20 bytes and used as the entire peer-id.
     */
    public void setPeerFingerprint(byte[] value) {
        setBytes(string_types.peer_fingerprint.swigValue(), value);
    }

    /**
     * @return the session-global download rate limit in bytes per second. (0 for unlimited)
     */
    public int downloadRateLimit() {
        return h.get_int(settings_pack.int_types.download_rate_limit.swigValue());
    }

    /**
     * Sets the session-global limits of download rate limit, in
     * bytes per second.
     * <p>
     * A value of 0 means unlimited.
     *
     * @param value
     */
    public SettingsPack downloadRateLimit(int value) {
        h.set_int(settings_pack.int_types.download_rate_limit.swigValue(), value);
        return this;
    }

    /**
     * @return the session-global upload rate limit in bytes per second. (0 for unlimited)
     */
    public int uploadRateLimit() {
        return h.get_int(settings_pack.int_types.upload_rate_limit.swigValue());
    }

    /**
     * Sets the session-global limits of upload rate limit, in
     * bytes per second.
     * <p>
     * A value of 0 means unlimited.
     *
     * @param value
     */
    public SettingsPack uploadRateLimit(int value) {
        h.set_int(settings_pack.int_types.upload_rate_limit.swigValue(), value);
        return this;
    }

    /**
     * {@code active_downloads} controls how many active
     * downloading torrents the queuing mechanism allows.
     * <p>
     * The target number of active torrents is {@code min(active_downloads +
     * active_seeds, active_limit)}. {@code active_downloads} and
     * {@code active_seeds} are upper limits on the number of downloading
     * torrents and seeding torrents respectively. Setting the value to -1
     * means unlimited.
     * <p>
     * For auto managed torrents, these are the limits they are subject to.
     * If there are too many torrents some of the auto managed ones will be
     * paused until some slots free up.
     * <p>
     * You can have more torrents *active*, even though they are not
     * announced to the DHT, lsd or their tracker. If some peer knows about
     * you for any reason and tries to connect, it will still be accepted,
     * unless the torrent is paused, which means it won't accept any
     * connections.
     * <p>
     * For example if there are 10 seeding torrents and 10 downloading
     * torrents, and ``active_downloads`` is 4 and ``active_seeds`` is 4,
     * there will be 4 seeds active and 4 downloading torrents. If the
     * settings are ``active_downloads`` = 2 and ``active_seeds`` = 4, then
     * there will be 2 downloading torrents and 4 seeding torrents active.
     * Torrents that are not auto managed are also counted against these
     * limits. If there are non-auto managed torrents that use up all the
     * slots, no auto managed torrent will be activated.
     *
     *
     */
    public int activeDownloads() {
        return h.get_int(settings_pack.int_types.active_downloads.swigValue());
    }

    /**
     * @param value
     * @see #activeDownloads()
     */
    public SettingsPack activeDownloads(int value) {
        h.set_int(settings_pack.int_types.active_downloads.swigValue(), value);
        return this;
    }

    /**
     * {@code active_seeds} controls how many active seeding
     * torrents the queuing mechanism allows.
     *
     *
     * @see #activeDownloads()
     */
    public int activeSeeds() {
        return h.get_int(settings_pack.int_types.active_seeds.swigValue());
    }

    /**
     * @param value
     * @see #activeSeeds()
     */
    public SettingsPack activeSeeds(int value) {
        h.set_int(settings_pack.int_types.active_seeds.swigValue(), value);
        return this;
    }

    /**
     * {@code active_checking} is the limit of number of simultaneous checking
     * torrents.
     *
     *
     * @see #activeDownloads()
     */
    public int activeChecking() {
        return h.get_int(settings_pack.int_types.active_checking.swigValue());
    }

    /**
     * @param value
     * @see #activeChecking()
     */
    public SettingsPack activeChecking(int value) {
        h.set_int(settings_pack.int_types.active_checking.swigValue(), value);
        return this;
    }

    /**
     * Max number of torrents to announce to the DHT. By default this is set
     * to 88, which is no more than one DHT announce every 10 seconds.
     *
     * @see #activeDownloads()
     */
    public int activeDhtLimit() {
        return h.get_int(settings_pack.int_types.active_dht_limit.swigValue());
    }

    /**
     * Max number of torrents to announce to the DHT.
     *
     * @see #activeDhtLimit()
     */
    public SettingsPack activeDhtLimit(int value) {
        h.set_int(settings_pack.int_types.active_dht_limit.swigValue(), value);
        return this;
    }

    /**
     * {@code active_tracker_limit} is the max number of torrents to announce
     * to their trackers. By default this is 360, which is no more than
     * one announce every 5 seconds.
     *
     *
     * @see #activeDownloads()
     */
    public int activeTrackerLimit() {
        return h.get_int(settings_pack.int_types.active_tracker_limit.swigValue());
    }

    /**
     * @param value
     * @see #activeTrackerLimit()
     */
    public SettingsPack activeTrackerLimit(int value) {
        h.set_int(settings_pack.int_types.active_tracker_limit.swigValue(), value);
        return this;
    }

    /**
     * {@code active_lsd_limit} is the max number of torrents to announce to
     * the local network over the local service discovery protocol. By
     * default this is 80, which is no more than one announce every 5
     * seconds (assuming the default announce interval of 5 minutes).
     *
     *
     * @see #activeDownloads()
     */
    public int activeLsdLimit() {
        return h.get_int(settings_pack.int_types.active_lsd_limit.swigValue());
    }

    /**
     * @param value
     * @see #activeLsdLimit()
     */
    public SettingsPack activeLsdLimit(int value) {
        h.set_int(settings_pack.int_types.active_lsd_limit.swigValue(), value);
        return this;
    }

    /**
     * {@code active_limit} is a hard limit on the number of active (auto
     * managed) torrents. This limit also applies to slow torrents.
     *
     * @return the value
     * @see #activeDownloads()
     */
    public int activeLimit() {
        return h.get_int(settings_pack.int_types.active_limit.swigValue());
    }

    /**
     * {@code active_limit} is a hard limit on the number of active (auto
     * managed) torrents. This limit also applies to slow torrents.
     *
     * @param value the value
     * @see #activeLimit()
     */
    public SettingsPack activeLimit(int value) {
        h.set_int(settings_pack.int_types.active_limit.swigValue(), value);
        return this;
    }

    /**
     * @return global limit on the number of connections opened.
     */
    public int connectionsLimit() {
        return h.get_int(settings_pack.int_types.connections_limit.swigValue());
    }

    /**
     * Sets a global limit on the number of connections opened. The number of
     * connections is set to a hard minimum of at least two per torrent, so
     * if you set a too low connections limit, and open too many torrents,
     * the limit will not be met.
     *
     * @param value
     */
    public SettingsPack connectionsLimit(int value) {
        h.set_int(settings_pack.int_types.connections_limit.swigValue(), value);
        return this;
    }

    /**
     * @return the maximum number of peers in the list of known peers. (0 for unlimited)
     */
    public int maxPeerlistSize() {
        return h.get_int(settings_pack.int_types.max_peerlist_size.swigValue());
    }

    /**
     * Sets the maximum number of peers in the list of known peers. These peers
     * are not necessarily connected, so this number should be much greater
     * than the maximum number of connected peers. Peers are evicted from the
     * cache when the list grows passed 90% of this limit, and once the size
     * hits the limit, peers are no longer added to the list. If this limit
     * is set to 0, there is no limit on how many peers we'll keep in the
     * peer list.
     *
     * @param value
     */
    public SettingsPack maxPeerlistSize(int value) {
        h.set_int(settings_pack.int_types.max_peerlist_size.swigValue(), value);
        return this;
    }

    /**
     * @return the maximum number of bytes a connection may have pending in the disk
     * write queue before its download rate is being throttled.
     */
    public int maxQueuedDiskBytes() {
        return h.get_int(settings_pack.int_types.max_queued_disk_bytes.swigValue());
    }

    /**
     * Sets the maximum number of bytes a connection may have pending in the disk
     * write queue before its download rate is being throttled. This prevents
     * fast downloads to slow medias to allocate more memory indefinitely.
     * This should be set to at least 16 kB to not completely disrupt normal
     * downloads. If it's set to 0, you will be starving the disk thread and
     * nothing will be written to disk. this is a per session setting.
     * <p>
     * When this limit is reached, the peer connections will stop reading
     * data from their sockets, until the disk thread catches up. Setting
     * this too low will severely limit your download rate.
     *
     * @param value
     */
    public SettingsPack maxQueuedDiskBytes(int value) {
        h.set_int(settings_pack.int_types.max_queued_disk_bytes.swigValue(), value);
        return this;
    }

    /**
     * @return the upper limit of the send buffer low-watermark.
     */
    public int sendBufferWatermark() {
        return h.get_int(settings_pack.int_types.send_buffer_watermark.swigValue());
    }

    /**
     * Sets the upper limit of the send buffer low-watermark.
     * <p>
     * if the send buffer has fewer bytes than this, we'll read another 16kB
     * block onto it. If set too small, upload rate capacity will suffer. If
     * set too high, memory will be wasted. The actual watermark may be lower
     * than this in case the upload rate is low, this is the upper limit.
     *
     * @param value
     */
    public SettingsPack sendBufferWatermark(int value) {
        h.set_int(settings_pack.int_types.send_buffer_watermark.swigValue(), value);
        return this;
    }

    /**
     *
     */
    public int tickInterval() {
        return h.get_int(settings_pack.int_types.tick_interval.swigValue());
    }

    /**
     * Specifies the number of milliseconds between internal ticks. This is
     * the frequency with which bandwidth quota is distributed to peers. It
     * should not be more than one second (i.e. 1000 ms). Setting this to a
     * low value (around 100) means higher resolution bandwidth quota
     * distribution, setting it to a higher value saves CPU cycles.
     *
     * @param value
     */
    public SettingsPack tickInterval(int value) {
        h.set_int(settings_pack.int_types.tick_interval.swigValue(), value);
        return this;
    }

    /**
     *
     */
    public int inactivityTimeout() {
        return h.get_int(settings_pack.int_types.inactivity_timeout.swigValue());
    }

    /**
     * if a peer is uninteresting and uninterested for longer than this
     * number of seconds, it will be disconnected. default is 10 minutes
     *
     * @param value
     */
    public SettingsPack inactivityTimeout(int value) {
        h.set_int(settings_pack.int_types.inactivity_timeout.swigValue(), value);
        return this;
    }

    /**
     *
     */
    public boolean seedingOutgoingConnections() {
        return h.get_bool(settings_pack.bool_types.seeding_outgoing_connections.swigValue());
    }

    /**
     * Determines if seeding (and finished) torrents should attempt to make
     * outgoing connections or not. By default this is true. It may be set to
     * false in very specific applications where the cost of making outgoing
     * connections is high, and there are no or small benefits of doing so.
     * For instance, if no nodes are behind a firewall or a NAT, seeds don't
     * need to make outgoing connections.
     *
     * @param value
     */
    public SettingsPack seedingOutgoingConnections(boolean value) {
        h.set_bool(settings_pack.bool_types.seeding_outgoing_connections.swigValue(), value);
        return this;
    }

    /**
     *
     */
    public boolean anonymousMode() {
        return h.get_bool(settings_pack.bool_types.anonymous_mode.swigValue());
    }

    /**
     * defaults to false. When set to true, the client tries to hide its
     * identity to a certain degree. The peer-ID will no longer include the
     * client's fingerprint. The user-agent will be reset to an empty string.
     * It will also try to not leak other identifying information, such as
     * your local listen port, your IP etc.
     * <p>
     * If you're using I2P, a VPN or a proxy, it might make sense to enable
     * anonymous mode.
     *
     * @param value
     */
    public SettingsPack anonymousMode(boolean value) {
        h.set_bool(settings_pack.bool_types.anonymous_mode.swigValue(), value);
        return this;
    }

    /**
     * Starts the dht node and makes the trackerless service available to
     * torrents.
     *
     * @return true if enable
     */
    public boolean isEnableDht() {
        return h.get_bool(settings_pack.bool_types.enable_dht.swigValue());
    }

    /**
     * Starts the dht node and makes the trackerless service available to
     * torrents.
     *
     * @param value true if enable
     */
    public void setEnableDht(boolean value) {
        h.set_bool(settings_pack.bool_types.enable_dht.swigValue(), value);
    }

    /**
     * Starts and stops Local Service Discovery. This service will
     * broadcast the info-hashes of all the non-private torrents on the
     * local network to look for peers on the same swarm within multicast
     * reach.
     *
     * @return true if enable
     */
    public boolean isEnableLsd() {
        return h.get_bool(settings_pack.bool_types.enable_lsd.swigValue());
    }

    /**
     * Starts and stops Local Service Discovery. This service will
     * broadcast the info-hashes of all the non-private torrents on the
     * local network to look for peers on the same swarm within multicast
     * reach.
     *
     * @param value true if enable
     */
    public void setEnableLsd(boolean value) {
        h.set_bool(settings_pack.bool_types.enable_lsd.swigValue(), value);
    }

    /**
     * The maximum allowed size (in bytes) to be
     * received by the metadata extension, i.e. magnet links.
     */
    public int getMaxMetadataSize() {
        return h.get_int(int_types.max_metadata_size.swigValue());
    }

    /**
     * The maximum allowed size (in bytes) to be
     * received by the metadata extension, i.e. magnet links.
     *
     * @param value true if enable
     */
    public void setMaxMetadataSize(int value) {
        h.set_int(int_types.max_metadata_size.swigValue(), value);
    }

    /**
     * This is a comma-separated list of IP port-pairs. They will be added
     * to the DHT node (if it's enabled) as back-up nodes in case we don't
     * know of any.
     * <p>
     * Changing these after the DHT has been started may not have any
     * effect until the DHT is restarted.
     */
    public String getDhtBootstrapNodes() {
        return h.get_str(string_types.dht_bootstrap_nodes.swigValue());
    }

    /**
     * This is a comma-separated list of IP port-pairs. They will be added
     * to the DHT node (if it's enabled) as back-up nodes in case we don't
     * know of any.
     * <p>
     * Changing these after the DHT has been started may not have any
     * effect until the DHT is restarted.
     *
     * @param value the IP port-pairs list
     */
    public void setDhtBootstrapNodes(String value) {
        h.set_str(string_types.dht_bootstrap_nodes.swigValue(), value);
    }

    /**
     * This is the STUN server used by WebTorrent to enable ICE NAT
     * traversal for WebRTC. It must have the format ``hostname:port``.
     */
    public String getWebtorrentStunServer() {
        return h.get_str(string_types.webtorrent_stun_server.swigValue());
    }

    /**
     * This is the STUN server used by WebTorrent to enable ICE NAT
     * traversal for WebRTC. It must have the format ``hostname:port``.
     *
     * @param value the STUN server endpoint
     */
    public void setWebtorrentStunServer(String value) {
        h.set_str(string_types.webtorrent_stun_server.swigValue(), value);
    }

    /**
     *
     */
    public String listenInterfaces() {
        return h.get_str(settings_pack.string_types.listen_interfaces.swigValue());
    }

    /**
     * @param value
     * @return this
     */
    public SettingsPack listenInterfaces(String value) {
        h.set_str(settings_pack.string_types.listen_interfaces.swigValue(), value);
        return this;
    }

    /**
     * @return the current value
     * @see #stopTrackerTimeout(int)
     */
    public int stopTrackerTimeout() {
        return h.get_int(settings_pack.int_types.stop_tracker_timeout.swigValue());
    }

    /**
     * {@code stop_tracker_timeout} is the number of seconds to wait when
     * sending a stopped message before considering a tracker to have
     * timed out. This is usually shorter, to make the client quit faster.
     * If the value is set to 0, the connections to trackers with the
     * stopped event are suppressed.
     *
     * @param value the new value
     * @return this
     */
    public SettingsPack stopTrackerTimeout(int value) {
        h.set_int(settings_pack.int_types.stop_tracker_timeout.swigValue(), value);
        return this;
    }

    /**
     * @return the current value
     * @see #alertQueueSize(int)
     */
    public int alertQueueSize() {
        return h.get_int(settings_pack.int_types.alert_queue_size.swigValue());
    }

    /**
     * {@code alert_queue_size} is the maximum number of alerts queued up
     * internally. If alerts are not popped, the queue will eventually
     * fill up to this level.
     *
     * @param value the new value
     * @return this
     */
    public SettingsPack alertQueueSize(int value) {
        h.set_int(settings_pack.int_types.alert_queue_size.swigValue(), value);
        return this;
    }

    /**
     * <code>announce_port</code> is the port passed along as the <code>port</code> parameter
     * to remote trackers such as HTTP or DHT. This setting does not affect
     * the effective listening port nor local service discovery announcements.
     * If left as zero (default), the listening port value is used.
     * <p>
     * This setting is only meant for very special cases where a
     * seed's listening port differs from the external port. As an
     * example, if a local proxy is used and that the proxy supports
     * reverse tunnels through NAT-PMP, the tracker must connect to
     * the external NAT-PMP port (configured using <code>announce_port</code>)
     * instead of the actual local listening port.
     *
     * @return the current value
     * @see #setAnnouncePort(int)
     */
    public int getAnnouncePort() {
        return h.get_int(settings_pack.int_types.announce_port.swigValue());
    }

    /**
     * <code>announce_port</code> is the port passed along as the <code>port</code> parameter
     * to remote trackers such as HTTP or DHT. This setting does not affect
     * the effective listening port nor local service discovery announcements.
     * If left as zero (default), the listening port value is used.
     * <p>
     * This setting is only meant for very special cases where a
     * seed's listening port differs from the external port. As an
     * example, if a local proxy is used and that the proxy supports
     * reverse tunnels through NAT-PMP, the tracker must connect to
     * the external NAT-PMP port (configured using <code>announce_port</code>)
     * instead of the actual local listening port.
     *
     * @param value the new value
     * @return this
     */
    public SettingsPack setAnnouncePort(int value) {
        h.set_int(settings_pack.int_types.announce_port.swigValue(), value);
        return this;
    }

    /**
     * Returns a `SettingsPack` with every setting set to its default value.
     */
    public static SettingsPack defaultSettings() {
        return new SettingsPack(libtorrent.default_settings());
    }
}
