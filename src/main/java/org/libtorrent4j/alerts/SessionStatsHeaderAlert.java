package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.session_stats_header_alert;

/**
 * The session_stats_header alert is posted during the init of the
 * session thread.
 *
 * @author gubatron
 * @author aldenml
 */
public final class SessionStatsHeaderAlert extends AbstractAlert<session_stats_header_alert> {

    SessionStatsHeaderAlert(session_stats_header_alert alert) {
        super(alert);
    }
}
