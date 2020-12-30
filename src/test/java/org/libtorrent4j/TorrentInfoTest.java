package org.libtorrent4j;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class TorrentInfoTest {

    @Test
    public void testNewFromBuffer() throws IOException {
        byte[] bytes = Utils.resourceBytes("Honey_Larochelle_Hijack_FrostClick_FrostWire_MP3_May_06_2016.torrent");
        ByteBuffer bb = ByteBuffer.allocateDirect(bytes.length);
        bb.put(bytes);
        bb.position(0);

        TorrentInfo ti = new TorrentInfo((MappedByteBuffer) bb);
        assertEquals("83e37aea34581ce105af93c0955e7c7d4194ae47", ti.infoHash().toHex());
        assertEquals("FrostWire 6.2.4 build 179", ti.creator());

        assertTrue(ti.hasV1());
        assertFalse(ti.hasV2());
    }
}
