package org.libtorrent4j.alerts;

import org.libtorrent4j.Pair;
import org.libtorrent4j.Sha1Hash;
import org.libtorrent4j.UdpEndpoint;
import org.libtorrent4j.swig.dht_live_nodes_alert;
import org.libtorrent4j.swig.sha1_hash_udp_endpoint_pair;
import org.libtorrent4j.swig.sha1_hash_udp_endpoint_pair_vector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gubatron
 * @author aldenml
 */
public final class DhtLiveNodesAlert extends AbstractAlert<dht_live_nodes_alert> {

    DhtLiveNodesAlert(dht_live_nodes_alert alert) {
        super(alert);
    }

    /**
     * @return the DHT node id
     */
    public Sha1Hash nodeId() {
        return new Sha1Hash(alert.getNode_id());
    }

    /**
     * @return the number of nodes
     */
    public int numNodes() {
        return alert.num_nodes();
    }

    /**
     * This method creates a new list each time is called.
     *
     * @return the list of node, endpoint pairs
     */
    public List<Pair<Sha1Hash, UdpEndpoint>> nodes() {
        sha1_hash_udp_endpoint_pair_vector v = alert.nodes();
        int size = (int) v.size();
        ArrayList<Pair<Sha1Hash, UdpEndpoint>> nodes = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            sha1_hash_udp_endpoint_pair p = v.get(i);
            Sha1Hash h = new Sha1Hash(p.getFirst()).clone();
            UdpEndpoint endp = new UdpEndpoint(p.getSecond()).clone();
            nodes.add(new Pair<>(h, endp));
        }

        return nodes;
    }
}
