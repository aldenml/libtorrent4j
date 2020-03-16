package org.libtorrent4j.alerts;

import org.libtorrent4j.BDecodeNode;
import org.libtorrent4j.Entry;
import org.libtorrent4j.UdpEndpoint;
import org.libtorrent4j.swig.dht_direct_response_alert;
import org.libtorrent4j.SessionHandle;

/**
 * This is posted exactly once for every call to
 * {@link SessionHandle#dhtDirectRequest(UdpEndpoint, Entry, long)}.
 * <p>
 * If the request failed, {@link #response()} will return a default constructed {@link BDecodeNode}.
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtDirectResponseAlert extends AbstractAlert<dht_direct_response_alert> {

    DhtDirectResponseAlert(dht_direct_response_alert alert) {
        super(alert);
    }

    /**
     * @return the user data
     */
    public long userdata() {
        return alert.getUserdata().get();
    }

    /**
     * @return the endpoint
     */
    public UdpEndpoint endpoint() {
        return new UdpEndpoint(alert.get_endpoint());
    }

    /**
     * @return the response
     */
    public BDecodeNode response() {
        return new BDecodeNode(alert.response());
    }
}
