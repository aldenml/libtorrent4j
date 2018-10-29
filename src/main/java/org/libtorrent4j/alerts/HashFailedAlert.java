package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.hash_failed_alert;

/**
 * This alert is generated when a finished piece fails its hash check. You can get the handle
 * to the torrent which got the failed piece and the index of the piece itself from the alert.
 *
 * @author gubatron
 * @author aldenml
 */
public final class HashFailedAlert extends TorrentAlert<hash_failed_alert> {

    HashFailedAlert(hash_failed_alert alert) {
        super(alert);
    }

    public int pieceIndex() {
        return alert.getPiece_index();
    }
}
