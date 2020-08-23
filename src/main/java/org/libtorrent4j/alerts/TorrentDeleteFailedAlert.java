package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.InfoHash;
import org.libtorrent4j.Sha1Hash;
import org.libtorrent4j.swig.torrent_delete_failed_alert;

/**
 * This alert is generated when a request to delete the files of a torrent fails.
 * Just removing a torrent from the session cannot fail
 *
 * @author gubatron
 * @author aldenml
 */
public final class TorrentDeleteFailedAlert extends TorrentAlert<torrent_delete_failed_alert> {

    public TorrentDeleteFailedAlert(torrent_delete_failed_alert alert) {
        super(alert);
    }

    /**
     * Tells you why it failed.
     *
     * @return the failure's error code
     */
    public ErrorCode getError() {
        return new ErrorCode(alert.getError());
    }

    /**
     * Returns the info-hash of the torrent whose files failed to be deleted.
     *
     * @return the torrent info-hash
     */
    public InfoHash getInfoHashes() {
        return new InfoHash(alert.getInfo_hashes());
    }
}
