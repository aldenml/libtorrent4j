package org.libtorrent4j.swig;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class PeerInfoTest {

    @Test
    public void testGetPieces() {
        peer_info p = new peer_info();

        assertTrue(p.get_pieces().empty());
    }
}
