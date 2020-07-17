package org.libtorrent4j.alerts;

import org.libtorrent4j.Entry;
import org.libtorrent4j.Vectors;
import org.libtorrent4j.swig.dht_mutable_item_alert;

/**
 * This alert is posted as a response to a call to session::get_item(),
 * specifically the overload for looking up mutable items in the DHT.
 *
 * @author gubatron
 * @author aldenml
 */
public final class DhtMutableItemAlert extends AbstractAlert<dht_mutable_item_alert> {

    DhtMutableItemAlert(dht_mutable_item_alert alert) {
        super(alert);
    }

    /**
     * The public key that was looked up.
     *
     *
     */
    public byte[] key() {
        return Vectors.byte_array2bytes(alert.get_key());
    }

    /**
     * The signature of the data. This is not the signature of the
     * plain encoded form of the item, but it includes the sequence number
     * and possibly the hash as well. See the dht_store document for more
     * information. This is primarily useful for echoing back in a store
     * request.
     *
     *
     */
    public byte[] signature() {
        return Vectors.byte_array2bytes(alert.get_signature());
    }

    /**
     * The sequence number of this item.
     *
     *
     */
    public long seq() {
        return alert.get_seq();
    }

    /**
     * The salt, if any, used to lookup and store this item. If no
     * salt was used, this is an empty string.
     *
     *
     */
    public byte[] salt() {
        return Vectors.byte_vector2bytes(alert.get_salt());
    }

    /**
     * The data for this item.
     *
     *
     */
    public Entry item() {
        return new Entry(alert.getItem());
    }
}
