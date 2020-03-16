package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.Operation;
import org.libtorrent4j.swig.peer_disconnected_alert;

/**
 * This alert is generated when a peer is disconnected for any
 * reason (other than the ones covered by {@link PeerErrorAlert}).
 *
 * @author gubatron
 * @author aldenml
 */
public final class PeerDisconnectedAlert extends PeerAlert<peer_disconnected_alert> {

    PeerDisconnectedAlert(peer_disconnected_alert alert) {
        super(alert);
    }

    /**
     * The kind of socket this peer was connected over.
     *
     * @return the socket type.
     */
    public int socketType() {
        return alert.getSocket_type().swigValue();
    }

    /**
     * The operation or level where the error occurred.
     *
     * @return the operation.
     */
    public Operation operation() {
        return Operation.fromSwig(alert.getOp());
    }

    /**
     * Tells you what error caused peer to disconnect.
     *
     * @return the error.
     */
    public ErrorCode error() {
        return new ErrorCode(alert.getError());
    }

    /**
     * The reason the peer disconnected (if specified).
     *
     * @return the reason.
     */
    public CloseReason reason() {
        return CloseReason.fromSwig(alert.getReason().swigValue());
    }
}
