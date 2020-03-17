package org.libtorrent4j.swig;

import org.junit.Test;
import org.libtorrent4j.TorrentInfo;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class CreateTorrentTest {

    @Test
    public void testVerbatimTorrent() {
        // this line is important to link native ahead of time
        // while debugging, any static method will do it
        libtorrent.version();

        String testTorrent = "d4:infod4:name6:foobar6:lengthi12345e12:piece lengthi65536e6:pieces20:ababababababababababee";
        byte[] torrentBytes = testTorrent.getBytes(StandardCharsets.UTF_8);

        TorrentInfo ti = new TorrentInfo(torrentBytes);
        create_torrent c = new create_torrent(ti.swig());
        assertEquals(1, c.files().num_files());
    }
}
