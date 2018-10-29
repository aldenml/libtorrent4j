package org.libtorrent4j.alerts;

import org.libtorrent4j.AddTorrentParams;
import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.swig.add_torrent_alert;
import org.libtorrent4j.SessionHandle;

/**
 * This alert is always posted when a torrent was attempted to be added
 * and contains the return status of the add operation. The torrent handle
 * of the new torrent can be found in the {@link #handle()} member.
 * If adding the torrent failed, {@link #error()} contains the error code.
 *
 * @author gubatron
 * @author aldenml
 */
public final class AddTorrentAlert extends TorrentAlert<add_torrent_alert> {

    AddTorrentAlert(add_torrent_alert alert) {
        super(alert);
    }

    /**
     * A copy of the parameters used when adding the torrent, it can be used
     * to identify which invocation to
     * {@link SessionHandle#asyncAddTorrent(AddTorrentParams)}
     * caused this alert.
     *
     * @return the params used to add the torrent
     */
    public AddTorrentParams params() {
        return new AddTorrentParams(alert.getParams());
    }

    /**
     * Set to the error, if one occurred while adding the torrent.
     *
     * @return the error
     */
    public ErrorCode error() {
        return new ErrorCode(alert.getError());
    }
}
