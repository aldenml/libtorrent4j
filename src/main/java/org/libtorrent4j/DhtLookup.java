package org.libtorrent4j;

import org.libtorrent4j.swig.dht_lookup;

/**
 * Holds statistics about a current dht_lookup operation.
 * a DHT lookup is the traversal of nodes, looking up a
 * set of target nodes in the DHT for retrieving and possibly
 * storing information in the DHT
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtLookup {

    private final dht_lookup l;

    /**
     * internal use
     *
     * @param l
     */
    public DhtLookup(dht_lookup l) {
        this.l = l;
    }

    /**
     * The native object.
     *
     * @return the native object
     */
    public dht_lookup swig() {
        return l;
    }

    /**
     * string literal indicating which kind of lookup this is.
     *
     *
     */
    public String type() {
        return l.get_type();
    }

    /**
     * the number of outstanding request to individual nodes
     * this lookup has right now.
     *
     *
     */
    public int outstandingRequests() {
        return l.getOutstanding_requests();
    }

    /**
     * the total number of requests that have timed out so far
     * for this lookup.
     *
     *
     */
    public int timeouts() {
        return l.getTimeouts();
    }

    /**
     * the total number of responses we have received for this
     * lookup so far for this lookup.
     *
     *
     */
    public int responses() {
        return l.getResponses();
    }

    /**
     * the branch factor for this lookup. This is the number of
     * nodes we keep outstanding requests to in parallel by default.
     * when nodes time out we may increase this.
     *
     *
     */
    public int branchFactor() {
        return l.getBranch_factor();
    }

    /**
     * the number of nodes left that could be queries for this
     * lookup. Many of these are likely to be part of the trail
     * while performing the lookup and would never end up actually
     * being queried.
     *
     *
     */
    public int nodesLeft() {
        return l.getNodes_left();
    }

    /**
     * the number of seconds ago the
     * last message was sent that's still
     * outstanding.
     *
     *
     */
    public int lastSent() {
        return l.getLast_sent();
    }

    /**
     * the number of outstanding requests
     * that have exceeded the short timeout
     * and are considered timed out in the
     * sense that they increased the branch
     * factor.
     *
     *
     */
    public int firstTimeout() {
        return l.getFirst_timeout();
    }

    /**
     * The node-id or info-hash target for this lookup.
     *
     * @return the target
     */
    public Sha1Hash target() {
        return new Sha1Hash(l.getTarget());
    }
}
