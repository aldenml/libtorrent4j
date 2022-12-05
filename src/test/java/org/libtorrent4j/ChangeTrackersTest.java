/*
 * Copyright (c) 2018-2022, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author gubatron
 * @author aldenml
 */
public class ChangeTrackersTest {

    @Test
    public void testChangeTrackersLowLevel() throws IOException {
        byte[] torrentBytes = Utils.resourceBytes("test4.torrent");
        TorrentInfo ti = TorrentInfo.bdecode(torrentBytes);

        // do we have any tracker
        assertTrue(ti.trackers().size() > 0);

        entry e = entry.bdecode(Vectors.bytes2byte_vector(torrentBytes));
        boost_string_entry_map m = e.dict();

        // remove trackers
        if (m.contains("announce")) {
            m.remove("announce");
        }
        if (m.contains("announce-list")) {
            m.remove("announce-list");
        }

        // add trackers
        String[] tks = new String[]{"http://a:6969/announce", "http://b:6969/announce"};
        entry_vector l = new entry_vector();
        l.add(new entry(tks[0]));
        m.put("announce", new entry(l));

        entry_vector tl = new entry_vector();
        for (int i = 0; i < tks.length; i++) {
            l.clear();
            l.add(new entry(tks[i]));
            tl.add(new entry(l));
        }
        m.put("announce-list", new entry(tl));

        ti = TorrentInfo.bdecode(Vectors.byte_vector2bytes(e.bencode()));
        ArrayList<AnnounceEntry> trackers = ti.trackers();
        // do we have exactly the two added trackers
        assertEquals(trackers.size(), 2);
        assertEquals(trackers.get(0).url(), "http://a:6969/announce");
        assertEquals(trackers.get(1).url(), "http://b:6969/announce");
    }

    @Test
    public void testChangeTrackersWithTorrentInfo() throws IOException {
        byte[] torrentBytes = Utils.resourceBytes("test4.torrent");
        TorrentInfo ti = TorrentInfo.bdecode(torrentBytes);

        // do we have any tracker
        assertTrue(ti.trackers().size() > 0);

        ti.clearTrackers();

        // did we remove all trackers
        assertEquals(ti.trackers().size(), 0);

        ti.addTracker("http://a:6969/announce", 0);
        ti.addTracker("http://b:6969/announce", 1);

        ArrayList<AnnounceEntry> trackers = ti.trackers();
        // do we have exactly the two added trackers
        assertEquals(trackers.size(), 2);
        assertEquals(trackers.get(0).url(), "http://a:6969/announce");
        assertEquals(trackers.get(1).url(), "http://b:6969/announce");
    }
}
