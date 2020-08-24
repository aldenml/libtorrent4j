package org.libtorrent4j.alerts;

import org.libtorrent4j.TorrentHandle;
import org.libtorrent4j.swig.torrent_alert;

/**
 * This is a base class for alerts that are associated with a
 * specific torrent. It contains a handle to the torrent.
 *
 * @author gubatron
 * @author aldenml
 */
public class TorrentAlert<T extends torrent_alert> extends AbstractAlert<T> {

    TorrentAlert(T alert) {
        super(alert);
    }

    /**
     * The {@link TorrentHandle} pointing to the torrent this
     * alert is associated with.
     *
     * @return the torrent's handle
     */
    public TorrentHandle handle() {
        return new TorrentHandle(alert.getHandle());
    }

    /**
     * @return the name of the torrent download
     */
    public String torrentName() {
        return alert.torrent_name();
    }
}
