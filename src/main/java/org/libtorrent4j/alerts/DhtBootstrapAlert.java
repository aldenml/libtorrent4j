package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.dht_bootstrap_alert;

/**
 * This alert is posted when the initial DHT bootstrap is done.
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtBootstrapAlert extends AbstractAlert<dht_bootstrap_alert> {

    DhtBootstrapAlert(dht_bootstrap_alert alert) {
        super(alert);
    }
}
