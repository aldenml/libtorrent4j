/*
 * Copyright (c) 2018-2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.Sha1Hash;
import org.libtorrent4j.TcpEndpoint;
import org.libtorrent4j.swig.peer_alert;

/**
 * The peer alert is a base class for alerts that refer to a specific peer.
 * It includes all the information to identify the peer. i.e. {@code ip} and
 * {@code peer-id}.
 *
 * @author gubatron
 * @author aldenml
 */
public class PeerAlert<T extends peer_alert> extends TorrentAlert<T> {

    PeerAlert(T alert) {
        super(alert);
    }

    /**
     * The peer's IP address and port.
     *
     * @return the endpoint
     */
    public TcpEndpoint endpoint() {
        return new TcpEndpoint(alert.get_endpoint());
    }

    /**
     * The peer ID, if known.
     *
     * @return the id
     */
    public Sha1Hash peerId() {
        return new Sha1Hash(alert.getPid());
    }
}
