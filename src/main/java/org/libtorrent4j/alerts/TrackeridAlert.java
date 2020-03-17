package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.trackerid_alert;

/**
 * This alert is posted whenever a tracker responds with a ``trackerid``.
 * The tracker ID is like a cookie. The libtorrent will store the tracker ID
 * for this tracker and repeat it in subsequent announces.
 *
 * @author gubatron
 * @author aldenml
 */
public final class TrackeridAlert extends TorrentAlert<trackerid_alert> {

    TrackeridAlert(trackerid_alert alert) {
        super(alert);
    }

    /**
     * The tracker ID returned by the tracker.
     *
     *
     */
    public String trackerId() {
        return alert.tracker_id();
    }
}
