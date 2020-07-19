/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.address;
import org.libtorrent4j.swig.error_code;

/**
 * @author gubatron
 * @author aldenml
 */
public final class Address
    extends SwigObject<address>
    implements Comparable<Address> {

    /**
     * @param addr the native object
     */
    public Address(address addr) {
        super(addr);
    }

    /**
     * Empty address.
     */
    public Address() {
        this(new address());
    }

    /**
     * Get whether the address is an IP version 4 address.
     *
     * @return if it's an IPv4 address
     */
    public boolean isV4() {
        return h.is_v4();
    }

    /**
     * Get whether the address is an IP version 6 address.
     *
     * @return if it's an IPv6 address
     */
    public boolean isV6() {
        return h.is_v6();
    }

    /**
     * Determine whether the address is a loopback address.
     *
     * @return if it's a loopback address
     */
    public boolean isLoopback() {
        return h.is_loopback();
    }

    /**
     * Determine whether the address is unspecified.
     *
     * @return if it's an unspecified address
     */
    public boolean isUnspecified() {
        return h.is_unspecified();
    }

    /**
     * Determine whether the address is a multicast address.
     *
     * @return if it's an multicast address
     */
    public boolean isMulticast() {
        return h.is_multicast();
    }

    /**
     * Compare addresses for ordering.
     *
     * @param o the other address
     * @return -1, 0 or 1
     */
    @Override
    public int compareTo(Address o) {
        return address.compare(this.h, o.h);
    }

    /**
     * Get the address as a string in dotted decimal format.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return h.to_string();
    }

    /**
     * Returns a deep/native copy of this address.
     *
     * @return a copy of this address.
     */
    public Address copy() {
        return new Address(new address(h));
    }

    /**
     * Create an address from an IPv4 address string in dotted decimal form,
     * or from an IPv6 address in hexadecimal notation.
     *
     * @param ip the ip string representation
     */
    public static Address parseIp(String ip) {
        error_code ec = new error_code();
        address h = address.from_string(ip, ec);
        if (ec.value() != 0) {
            throw new IllegalArgumentException(ec.message());
        }
        return new Address(h);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }

        return compareTo((Address) obj) == 0;
    }

    @Override
    public int hashCode() {
        return h.hash_code();
    }
}
