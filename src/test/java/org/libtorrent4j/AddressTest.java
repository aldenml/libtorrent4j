package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
}
