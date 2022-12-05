/*
 * Copyright (c) 2018-2022, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.TcpEndpoint;
import org.libtorrent4j.swig.protocol_version;
import org.libtorrent4j.swig.tracker_alert;

/**
 * This is a base class used for alerts that are associated with a
 * specific tracker. It derives from torrent_alert since a tracker
 * is also associated with a specific torrent.
 *
 * @author gubatron
 * @author aldenml
 */
public class TrackerAlert<T extends tracker_alert> extends TorrentAlert<T> {

    TrackerAlert(T alert) {
        super(alert);
    }

    /**
     * Returns the endpoint of the listen interface being announced.
     *
     * @return the local endpoint
     */
    public TcpEndpoint localEndpoint() {
        return new TcpEndpoint(alert.get_local_endpoint());
    }

    /**
     * Returns a null-terminated string of the tracker's URL.
     *
     * @return the tracker's URL
     */
    public String trackerUrl() {
        return alert.tracker_url();
    }

    /**
     * The bittorrent protocol version that was announced.
     *
     * @return bittorrent protocol version that was announced
     */
    public protocol_version getVersion() {
        return alert.getVersion();
    }
}
