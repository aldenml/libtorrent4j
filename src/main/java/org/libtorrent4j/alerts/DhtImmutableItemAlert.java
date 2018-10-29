package org.libtorrent4j.alerts;

import org.libtorrent4j.Entry;
import org.libtorrent4j.SessionHandle;
import org.libtorrent4j.Sha1Hash;
import org.libtorrent4j.swig.dht_immutable_item_alert;

/**
 * This alert is posted as a response to a call to {@link SessionHandle#dhtGetItem(Sha1Hash)},
 * looking up immutable items in the DHT.
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtImmutableItemAlert extends AbstractAlert<dht_immutable_item_alert> {

    DhtImmutableItemAlert(dht_immutable_item_alert alert) {
        super(alert);
    }

    /**
     * The target hash of the immutable item. This must
     * match the sha-1 hash of the bencoded form of the item.
     *
     * @return the target of the original query
     */
    public Sha1Hash target() {
        return new Sha1Hash(alert.getTarget());
    }

    /**
     * the data for this item
     *
     * @return the entry returned by the DHT
     */
    public Entry item() {
        return new Entry(alert.getItem());
    }
}
