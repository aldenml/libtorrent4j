package org.libtorrent4j.alerts;

import org.libtorrent4j.Sha1Hash;
import org.libtorrent4j.UdpEndpoint;
import org.libtorrent4j.swig.dht_outgoing_get_peers_alert;

/**
 * This alert is generated when we send a get_peers request.
 * It belongs to the {@code dht_notification} category.
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtOutgoingGetPeersAlert extends AbstractAlert<dht_outgoing_get_peers_alert> {

    DhtOutgoingGetPeersAlert(dht_outgoing_get_peers_alert alert) {
        super(alert);
    }

    /**
     * the info_hash of the torrent we're looking for peers for.
     *
     *
     */
    public Sha1Hash infoHash() {
        return new Sha1Hash(alert.getInfo_hash());
    }

    /**
     * if this was an obfuscated lookup, this is the info-hash target
     * actually sent to the node.
     *
     *
     */
    public Sha1Hash obfuscatedInfoHash() {
        return new Sha1Hash(alert.getObfuscated_info_hash());
    }

    /**
     * The endpoint we're sending this query to.
     *
     * @return the endpoint
     */
    public UdpEndpoint endpoint() {
        return new UdpEndpoint(alert.get_endpoint());
    }
}
