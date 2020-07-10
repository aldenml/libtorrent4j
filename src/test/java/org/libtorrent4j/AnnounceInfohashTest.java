package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.announce_endpoint;
import org.libtorrent4j.swig.announce_infohash;

import static org.junit.Assert.*;

/**
 * @author aldenml
 */
public class AnnounceInfohashTest {

    @Test
    public void testValues() {
        AnnounceInfohash infohash = new AnnounceInfohash(createNative());

        assertEquals("test", infohash.message());
        assertEquals(1, infohash.fails());
        assertTrue(infohash.updating());
        assertFalse(infohash.isWorking());
    }

    private announce_infohash createNative() {
        announce_endpoint ae = new announce_endpoint();
        announce_infohash infohash = ae.get_infohash_v1();

        infohash.setMessage("test");
        infohash.setFails((short) 1);
        infohash.setUpdating(true);

        return infohash;
    }
}
