/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author aldenml
 */
public class AddressTest {

    @Test
    public void testIsUnspecified() {
        Address addr = new Address();

        assertTrue(addr.isUnspecified());
    }

    @Test
    public void testParseIp() {
        Address addr1 = Address.parseIp("4.4.4.4");
        assertTrue(addr1.isV4());

        Address addr2 = Address.parseIp("::1");
        assertTrue(addr2.isV6());
    }

    @Test
    public void testIsLoopback() {
        Address addr = Address.parseIp("127.0.0.1");
        assertTrue(addr.isLoopback());
    }

    @Test
    public void testIsMulticast() {
        Address addr = Address.parseIp("ff00::");
        assertTrue(addr.isMulticast());
    }

    @Test
    public void testCopy() {
        Address addr1 = Address.parseIp("1.2.3.4");
        Address addr2 = addr1.copy();

        assertEquals(addr1, addr2);
    }

    @Test
    public void testHashCode() {
        Address addr1 = Address.parseIp("1.2.3.4");
        Address addr2 = Address.parseIp("1.2.3.4");
        Address addr3 = Address.parseIp("1.2.3.5");

        assertEquals(addr1.hashCode(), addr2.hashCode());
        assertNotEquals(addr1.hashCode(), addr3.hashCode());
    }
}
