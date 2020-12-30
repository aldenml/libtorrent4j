package org.libtorrent4j;

import org.libtorrent4j.swig.info_hash_t;

/**
 * Class holding the info-hash of a torrent. It can hold a v1 info-hash
 * (SHA-1) or a v2 info-hash (SHA-256) or both.
 * <p>
 * If !has_v2() then the v1 hash might actually be a truncated v2 hash.
 *
 * @author aldenml
 */
public class InfoHash
    extends SwigObject<info_hash_t> {

    /**
     * The default constructor creates an object that has neither a v1 or v2
     * hash.
     */
    public InfoHash() {
        super(new info_hash_t());
    }

    public InfoHash(info_hash_t ih) {
        super(ih);
    }

    /**
     * Returns true if the corresponding info hash is present in this
     * object.
     */
    public boolean hasV1() {
        return h.has_v1();
    }

    /**
     * Returns true if the corresponding info hash is present in this
     * object.
     */
    public boolean hasV2() {
        return h.has_v2();
    }

    public Sha1Hash getBest() {
        return new Sha1Hash(h.get_best());
    }

    public Sha1Hash getV1() {
        return new Sha1Hash(h.getV1());
    }
}
