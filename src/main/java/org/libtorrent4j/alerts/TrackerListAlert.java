/*
 * Copyright (c) 2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.AnnounceEntry;
import org.libtorrent4j.swig.announce_entry;
import org.libtorrent4j.swig.announce_entry_vector;
import org.libtorrent4j.swig.tracker_list_alert;

import java.util.ArrayList;

/**
 * posted when torrent_handle::post_trackers() is called.
 *
 * @author aldenml
 */
public final class TrackerListAlert extends TorrentAlert<tracker_list_alert> {

    TrackerListAlert(tracker_list_alert alert) {
        super(alert);
    }

    /**
     * list of trackers and their status for the torrent.
     */
    public ArrayList<AnnounceEntry> getTrackers() {
        announce_entry_vector v = alert.getTrackers();
        int size = v.size();
        ArrayList<AnnounceEntry> trackers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            announce_entry e = v.get(i);
            trackers.add(new AnnounceEntry(e));
        }

        return trackers;
    }
}
