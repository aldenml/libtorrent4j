/*
 * Copyright (c) 2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.PeerInfo;
import org.libtorrent4j.swig.peer_info;
import org.libtorrent4j.swig.peer_info_alert;
import org.libtorrent4j.swig.peer_info_vector;

import java.util.ArrayList;

/**
 * posted when torrent_handle::post_peer_info() is called.
 *
 * @author aldenml
 */
public final class PeerInfoAlert extends TorrentAlert<peer_info_alert> {

    PeerInfoAlert(peer_info_alert alert) {
        super(alert);
    }

    /**
     * the list of the currently connected peers.
     */
    public ArrayList<PeerInfo> getPeerInfo() {
        peer_info_vector v = alert.getPeer_info();
        int size = v.size();
        ArrayList<PeerInfo> peerInfo = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            peer_info e = v.get(i);
            peerInfo.add(new PeerInfo(e));
        }

        return peerInfo;
    }
}
