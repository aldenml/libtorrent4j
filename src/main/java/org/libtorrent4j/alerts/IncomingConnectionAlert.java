/*
 * Copyright (c) 2018-2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.TcpEndpoint;
import org.libtorrent4j.swig.incoming_connection_alert;

/**
 * The incoming connection alert is posted every time we successfully accept
 * an incoming connection, through any mean. The most straight-forward ways
 * of accepting incoming connections are through the TCP listen socket and
 * the UDP listen socket for uTP sockets. However, connections may also be
 * accepted through a Socks5 or i2p listen socket, or via a torrent specific
 * listen socket for SSL torrents.
 *
 * @author gubatron
 * @author aldenml
 */
public final class IncomingConnectionAlert extends AbstractAlert<incoming_connection_alert> {

    IncomingConnectionAlert(incoming_connection_alert alert) {
        super(alert);
    }

    /**
     * Tells you what kind of socket the connection was accepted.
     *
     * @return the socket type
     */
    public SocketType socketType() {
        return SocketType.fromSwig(alert.getSocket_type().swigValue());
    }

    /**
     * It is the IP address and port the connection came from.
     *
     * @return the endpoint
     */
    public TcpEndpoint endpoint() {
        return new TcpEndpoint(alert.get_endpoint());
    }
}
