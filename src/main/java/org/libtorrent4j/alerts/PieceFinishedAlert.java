package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.piece_finished_alert;
import org.libtorrent4j.TorrentHandle;

/**
 * This alert is posted every time a piece completes downloading
 * and passes the hash check. This alert derives from
 * {@link TorrentAlert} which contains the
 * {@link TorrentHandle} to the torrent
 * the piece belongs to.
 *
 * @author gubatron
 * @author aldenml
 */
public final class PieceFinishedAlert extends TorrentAlert<piece_finished_alert> {

    PieceFinishedAlert(piece_finished_alert alert) {
        super(alert);
    }

    /**
     * The index of the piece that finished.
     *
     * @return the piece index
     */
    public int pieceIndex() {
        return alert.getPiece_index();
    }
}
