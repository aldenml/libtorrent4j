package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.peer_blocked_alert;

/**
 * This alert is posted when an incoming peer connection, or a peer that's about to be added
 * to our peer list, is blocked for some reason. This could be any of:
 * <p>
 * * the IP filter
 * * i2p mixed mode restrictions (a normal peer is not allowed on an i2p swarm)
 * * the port filter
 * * the peer has a low port and ``no_connect_privileged_ports`` is enabled
 * * the protocol of the peer is blocked (uTP/TCP blocking)
 *
 * @author gubatron
 * @author aldenml
 */
public final class PeerBlockedAlert extends TorrentAlert<peer_blocked_alert> {

    PeerBlockedAlert(peer_blocked_alert alert) {
        super(alert);
    }

    /**
     * The reason for the peer being blocked.
     *
     *
     */
    public Reason reason() {
        return Reason.fromSwig(alert.getReason());
    }

    /**
     *
     */
    public enum Reason {

        /**
         *
         */
        IP_FILTER(peer_blocked_alert.reason_t.ip_filter.swigValue()),

        /**
         *
         */
        PORT_FILTER(peer_blocked_alert.reason_t.port_filter.swigValue()),

        /**
         *
         */
        I2P_MIXED(peer_blocked_alert.reason_t.i2p_mixed.swigValue()),

        /**
         *
         */
        PRIVILEGED_PORTS(peer_blocked_alert.reason_t.privileged_ports.swigValue()),

        /**
         *
         */
        UTP_DISABLED(peer_blocked_alert.reason_t.utp_disabled.swigValue()),

        /**
         *
         */
        TCP_DISABLED(peer_blocked_alert.reason_t.tcp_disabled.swigValue()),

        /**
         *
         */
        INVALID_LOCAL_INTERFACE(peer_blocked_alert.reason_t.invalid_local_interface.swigValue()),

        /**
         *
         */
        SSRF_MITIGATION(peer_blocked_alert.reason_t.ssrf_mitigation.swigValue()),

        /**
         *
         */
        UNKNOWN(-1);

        Reason(int swigValue) {
            this.swigValue = swigValue;
        }

        private final int swigValue;

        /**
         *
         */
        public int swig() {
            return swigValue;
        }

        /**
         * @param swigValue
         *
         */
        public static Reason fromSwig(int swigValue) {
            Reason[] enumValues = Reason.class.getEnumConstants();
            for (Reason ev : enumValues) {
                if (ev.swig() == swigValue) {
                    return ev;
                }
            }
            return UNKNOWN;
        }
    }
}
