/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.sha1_hash;
import org.libtorrent4j.swig.sha1_hash_vector;

import java.util.ArrayList;

/**
 * This type holds a SHA-1 digest or any other kind of 20 byte
 * sequence. It implements a number of convenience functions, such
 * as bit operations, comparison operators etc.
 * <p>
 * In libtorrent it is primarily used to hold info-hashes, piece-hashes,
 * peer IDs, node IDs etc.
 *
 * @author gubatron
 * @author aldenml
 */
public final class Sha1Hash
    extends SwigObject<sha1_hash>
    implements Comparable<Sha1Hash>, Cloneable {

    /**
     * @param h native object
     */
    public Sha1Hash(sha1_hash h) {
        super(h);
    }

    /**
     * Constructs an all-zero sha1-hash
     */
    public Sha1Hash() {
        this(new sha1_hash());
    }

    /**
     * set the sha1-hash to all zeroes.
     */
    public void clear() {
        h.clear();
    }

    /**
     * return true if the sha1-hash is all zero.
     *
     * @return true if zero
     */
    public boolean isAllZeros() {
        return h.is_all_zeros();
    }

    /**
     * @return the number of leading zeroes
     */
    public int countLeadingZeroes() {
        return h.count_leading_zeroes();
    }

    /**
     * Returns the hex representation of this has.
     * <p>
     * This method uses internally the libtorrent to_hex function.
     *
     * @return the hex representation
     */
    public String toHex() {
        return h.to_hex();
    }

    /**
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int compareTo(Sha1Hash o) {
        return sha1_hash.compare(this.h, o.h);
    }

    /**
     * Returns an hex representation of this hash. Internally it
     * calls {@link #toHex()}.
     *
     * @return {@inheritDoc}
     */
    @Override
    public String toString() {
        return toHex();
    }

    /**
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Sha1Hash)) {
            return false;
        }

        return h.eq(((Sha1Hash) obj).h);
    }

    /**
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return h.hash_code();
    }

    @Override
    public Sha1Hash clone() {
        return new Sha1Hash(new sha1_hash(h));
    }

    /**
     * returns an all-F sha1-hash. i.e. the maximum value
     * representable by a 160 bit number (20 bytes). This is
     * a static member function.
     *
     * @return the maximum number
     */
    public static Sha1Hash max() {
        return new Sha1Hash(sha1_hash.max());
    }

    /**
     * returns an all-zero sha1-hash. i.e. the minimum value
     * representable by a 160 bit number (20 bytes). This is
     * a static member function.
     *
     * @return the minimum number (zero)
     */
    public static Sha1Hash min() {
        return new Sha1Hash(sha1_hash.min());
    }

    /**
     * @param bytes hash as an array of bytes
     */
    public static Sha1Hash fromBytes(byte[] bytes) {
        if (bytes.length != 20) {
            throw new IllegalArgumentException("bytes array must be of length 20");
        }

        return new Sha1Hash(new sha1_hash(Vectors.bytes2byte_vector(bytes)));
    }

    /**
     * @param hex hex coded representation of the hash
     */
    public static Sha1Hash parseHex(String hex) {
        return fromBytes(Hex.decode(hex));
    }

    static ArrayList<Sha1Hash> convert(sha1_hash_vector v) {
        ArrayList<Sha1Hash> l = new ArrayList<>(v.size());

        for (sha1_hash hash : v) {
            l.add(new Sha1Hash(hash));
        }

        return l;
    }
}
