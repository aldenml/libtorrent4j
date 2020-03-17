package org.libtorrent4j;

import org.libtorrent4j.swig.announce_endpoint;

/**
 * Announces are sent to each tracker using every listen socket, this class
 * holds information about one listen socket for one tracker.
 * <p>
 * This class is a lightweight version of the native {@link announce_endpoint},
 * and only carries a subset of all the information. However, it's completely
 * open for custom use or optimization to accommodate client necessities.
 *
 * @author aldenml
 */
public class AnnounceEndpoint {

    protected String localEndpoint;
    protected boolean enabled;

    /**
     * @param e the native object
     */
    public AnnounceEndpoint(announce_endpoint e) {
        init(e);
    }

    /**
     * The local endpoint of the listen interface associated with this endpoint.
     *
     * @return the local endpoint
     */
    public String localEndpoint() {
        return localEndpoint;
    }

    /**
     * The time of next tracker announce in milliseconds.
     *
     * @return the time of next tracker announce in milliseconds
     */
    public boolean enabled() {
        return enabled;
    }

    /**
     * NOTE: use this with care and only if necessary.
     *
     * @param e the native object
     */
    protected void init(announce_endpoint e) {
        localEndpoint = new TcpEndpoint(e.getLocal_endpoint()).toString();
        enabled = e.getEnabled();
    }
}
