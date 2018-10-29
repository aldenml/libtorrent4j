package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.Operation;
import org.libtorrent4j.swig.dht_error_alert;

/**
 * Posted when something fails in the DHT. This is not necessarily a fatal
 * error, but it could prevent proper operation.
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtErrorAlert extends AbstractAlert<dht_error_alert> {

    DhtErrorAlert(dht_error_alert alert) {
        super(alert);
    }

    /**
     * The error code.
     *
     * @return the error.
     */
    public ErrorCode error() {
        return new ErrorCode(alert.getError());
    }

    /**
     * the operation that failed
     *
     * @return the operation.
     */
    public Operation operation() {
        return Operation.fromSwig(alert.getOp());
    }
}
