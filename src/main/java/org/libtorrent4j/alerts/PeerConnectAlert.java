package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.peer_connect_alert;
import org.libtorrent4j.swig.socket_type_t;

/**
 * This alert is posted every time an outgoing peer connect attempts succeeds.
 *
 * @author gubatron
 * @author aldenml
 */
public final class PeerConnectAlert extends PeerAlert<peer_connect_alert> {

    PeerConnectAlert(peer_connect_alert alert) {
        super(alert);
    }

    public socket_type_t socketType() {
        return alert.getSocket_type();
    }
}
