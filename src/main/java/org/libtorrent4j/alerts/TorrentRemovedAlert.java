package org.libtorrent4j.alerts;

import org.libtorrent4j.InfoHash;
import org.libtorrent4j.Sha1Hash;
import org.libtorrent4j.swig.torrent_removed_alert;

/**
 * The ``torrent_removed_alert`` is posted whenever a torrent is removed. Since
 * the torrent handle in its baseclass will always be invalid (since the torrent
 * is already removed) it has the info hash as a member, to identify it.
 * It's posted when the ``status_notification`` bit is set in the alert_mask.
 * <p>
 * Even though the ``handle`` member doesn't point to an existing torrent anymore,
 * it is still useful for comparing to other handles, which may also no
 * longer point to existing torrents, but to the same non-existing torrents.
 * <p>
 * The ``torrent_handle`` acts as a ``weak_ptr``, even though its object no
 * longer exists, it can still compare equal to another weak pointer which
 * points to the same non-existent object.
 *
 * @author gubatron
 * @author aldenml
 */
public final class TorrentRemovedAlert extends TorrentAlert<torrent_removed_alert> {

    TorrentRemovedAlert(torrent_removed_alert alert) {
        super(alert);
    }

    /**
     * Returns the info-hash of the torrent that was removed.
     *
     * @return the torrent's info-hash
     */
    public InfoHash getInfoHashes() {
        return new InfoHash(alert.getInfo_hashes());
    }
}
