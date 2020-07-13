package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.libtorrent4j.AnnounceFlags.IMPLIED_PORT;
import static org.libtorrent4j.AnnounceFlags.SEED;
import static org.libtorrent4j.AnnounceFlags.SSL_TORRENT;

/**
 * @author aldenml
 */
public class AnnounceFlagsTest {

    @Test
    public void testSeedValue() {
        assertEquals(1, SEED);
    }

    @Test
    public void testImpliedPortValue() {
        assertEquals(2, IMPLIED_PORT);
    }

    @Test
    public void testSslTorrentValue() {
        assertEquals(4, SSL_TORRENT);
    }
}
