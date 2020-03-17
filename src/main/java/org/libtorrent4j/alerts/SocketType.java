package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.socket_type_t;

/**
 *
 */
public enum SocketType {

    /**
     *
     */
    TCP(socket_type_t.tcp.swigValue()),

    /**
     *
     */
    TCP_SSL(socket_type_t.tcp_ssl.swigValue()),

    /**
     *
     */
    UTP(socket_type_t.utp.swigValue()),

    /**
     *
     */
    I2P(socket_type_t.i2p.swigValue()),

    /**
     *
     */
    SOCKS5(socket_type_t.socks5.swigValue()),

    /**
     *
     */
    UTP_SSL(socket_type_t.utp_ssl.swigValue()),

    /**
     *
     */
    UNKNOWN(-1);

    SocketType(int swigValue) {
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
     * @return the enum value
     */
    public static SocketType fromSwig(int swigValue) {
        SocketType[] enumValues = SocketType.class.getEnumConstants();
        for (SocketType ev : enumValues) {
            if (ev.swig() == swigValue) {
                return ev;
            }
        }
        return UNKNOWN;
    }
}
