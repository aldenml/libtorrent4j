package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author gubatron
 * @author aldenml
 */
public class TcpEndpointTest {

    @Test
    public void testToString() {
        TcpEndpoint endp1 = new TcpEndpoint("1.1.1.1", 80);
        assertEquals("tcp://1.1.1.1:80", endp1.toString());

        TcpEndpoint endp2 = new TcpEndpoint("::1", 80);
        assertEquals("tcp://[::1]:80", endp2.toString());
    }
}
