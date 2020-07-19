/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.announce_endpoint;
import org.libtorrent4j.swig.announce_endpoint_vector;
import org.libtorrent4j.swig.announce_entry;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds information about one bittorrent tracker, as it
 * relates to a specific torrent.
 *
 * @author gubatron
 * @author aldenml
 */
public final class AnnounceEntry
    extends SwigObject<announce_entry> {

    /**
     * @param e the native object
     */
    public AnnounceEntry(announce_entry e) {
        super(e);
    }

    /**
     * Constructs a tracker announce entry with `url` as the URL.
     *
     * @param url tracker announce entry URL
     */
    public AnnounceEntry(String url) {
        super(new announce_entry(url));
    }

    public List<AnnounceEndpoint> endpoints() {
        announce_endpoint_vector v = h.getEndpoints();
        int size = v.size();
        ArrayList<AnnounceEndpoint> l = new ArrayList<>(size);

        for (announce_endpoint endp : v) {
            l.add(new AnnounceEndpoint(endp));
        }

        return l;
    }

    /**
     * Tracker URL as it appeared in the torrent file.
     *
     * @return the tracker url
     */
    public String url() {
        return h.getUrl();
    }

    public void url(String value) {
        h.setUrl(value);
    }

    /**
     * The current {@code &trackerid=} argument passed to the tracker.
     * this is optional and is normally empty (in which case no
     * trackerid is sent).
     *
     * @return the trackerid url argument
     */
    public String trackerId() {
        return h.getTrackerid();
    }

    public void trackerId(String value) {
        h.setTrackerid(value);
    }

    /**
     * The tier this tracker belongs to.
     *
     * @return the tier number
     */
    public int tier() {
        return h.getTier();
    }

    public void tier(short value) {
        h.setTier(value);
    }

    /**
     * The max number of failures to announce to this tracker in
     * a row, before this tracker is not used anymore. 0 means unlimited.
     *
     * @return the max number of failures allowed
     */
    public int failLimit() {
        return h.getFail_limit();
    }

    public void failLimit(short value) {
        h.setFail_limit(value);
    }

    /**
     * A bitmask specifying which sources we got this tracker from.
     *
     * @return the source bitmask
     */
    public int source() {
        return h.getSource();
    }

    /**
     * Set to true the first time we receive a valid response
     * from this tracker.
     *
     * @return if the tracker has received a valid response
     */
    public boolean isVerified() {
        return h.getVerified();
    }
}
