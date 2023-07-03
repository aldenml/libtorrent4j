/*
 * Copyright (c) 2018-2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.peer_connect_alert;

/**
 * This alert is posted every time an incoming peer connection both
 * successfully passes the protocol handshake and is associated with a
 * torrent, or an outgoing peer connection attempt succeeds. For arbitrary
 * incoming connections, see {@link IncomingConnectionAlert}.
 *
 * @author gubatron
 * @author aldenml
 */
public final class PeerConnectAlert extends PeerAlert<peer_connect_alert> {

    PeerConnectAlert(peer_connect_alert alert) {
        super(alert);
    }

    /**
     * Tells you if the peer was incoming or outgoing.
     */
    public Direction direction() {
        return Direction.fromSwig(alert.getDirection().swigValue());
    }

    public SocketType socketType() {
        return SocketType.fromSwig(alert.getSocket_type().swigValue());
    }

    /**
     *
     */
    public enum Direction {

        /**
         *
         */
        IN(peer_connect_alert.direction_t.in.swigValue()),

        /**
         *
         */
        OUT(peer_connect_alert.direction_t.out.swigValue()),

        /**
         *
         */
        UNKNOWN(-1);

        Direction(int swigValue) {
            this.swigValue = swigValue;
        }

        private final int swigValue;

        /**
         * @return the native value
         */
        public int swig() {
            return swigValue;
        }

        /**
         * @param swigValue the native value
         * @return the java enum
         */
        public static PeerConnectAlert.Direction fromSwig(int swigValue) {
            PeerConnectAlert.Direction[] enumValues = PeerConnectAlert.Direction.class.getEnumConstants();
            for (PeerConnectAlert.Direction ev : enumValues) {
                if (ev.swig() == swigValue) {
                    return ev;
                }
            }
            return UNKNOWN;
        }
    }
}
