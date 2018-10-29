package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.torrent_need_cert_alert;
import org.libtorrent4j.TorrentHandle;

/**
 * This is always posted for SSL torrents. This is a reminder to the client that
 * the torrent won't work unless {@link TorrentHandle#setSslCertificate}
 * is called with a valid certificate. Valid certificates MUST be signed by the
 * SSL certificate in the .torrent file.
 *
 * @author gubatron
 * @author aldenml
 */
public final class TorrentNeedCertAlert extends TorrentAlert<torrent_need_cert_alert> {

    TorrentNeedCertAlert(torrent_need_cert_alert alert) {
        super(alert);
    }
}
