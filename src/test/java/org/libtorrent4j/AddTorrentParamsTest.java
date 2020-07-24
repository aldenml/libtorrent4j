/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class AddTorrentParamsTest {

    @Test
    public void testVersion() {
        AddTorrentParams params = new AddTorrentParams();
        assertEquals(20000, params.getVersion());
    }

    @Test
    public void testTrackers() {
        AddTorrentParams params = new AddTorrentParams();

        assertTrue(params.getTrackers().isEmpty());

        List<String> trackers = new ArrayList<>(2);
        trackers.add("http://tracker1");
        trackers.add("http://tracker2");

        params.setTrackers(trackers);

        List<String> r = params.getTrackers();

        assertEquals(2, r.size());
        assertTrue(r.contains("http://tracker1"));
        assertTrue(r.contains("http://tracker2"));
    }

    @Test
    public void testTrackerTiers() {
        AddTorrentParams params = new AddTorrentParams();

        assertTrue(params.getTrackerTiers().isEmpty());

        List<Integer> tiers = new ArrayList<>(2);
        tiers.add(10);
        tiers.add(20);

        params.setTrackerTiers(tiers);

        List<Integer> r = params.getTrackerTiers();

        assertEquals(2, r.size());
        assertTrue(r.contains(10));
        assertTrue(r.contains(20));
    }

    @Test
    public void testParseMagnetUri() {
        AddTorrentParams params = AddTorrentParams.parseMagnetUri("magnet:?xt=urn:btih:D540FC48EB12F2833163EED6421D449DD8F1CE1F&dn=Ubuntu+desktop+19.04+%2864bit%29&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337");

        assertEquals("D540FC48EB12F2833163EED6421D449DD8F1CE1F", params.getInfoHash().getV1().toHex().toUpperCase(Locale.US));
        assertEquals("Ubuntu desktop 19.04 (64bit)", params.getName());
        assertEquals("udp://tracker.opentrackr.org:1337", params.getTrackers().get(0));
    }

    @Test
    public void testWriteResumeData() {
        AddTorrentParams params = new AddTorrentParams();

        params.setName("test");

        Entry entry = AddTorrentParams.writeResumeData(params);
        byte[] buff = AddTorrentParams.writeResumeDataBuf(params);

        assertArrayEquals(entry.bencode(), buff);
    }

    @Test
    public void testDhtNodes() {
        AddTorrentParams params = new AddTorrentParams();

        assertTrue(params.getDhtNodes().isEmpty());

        ArrayList<Pair<String, Integer>> nodes = new ArrayList<>(2);
        nodes.add(Pair.of("1.1.1.1", 1));
        nodes.add(Pair.of("2.2.2.2", 2));

        params.setDhtNodes(nodes);

        ArrayList<Pair<String, Integer>> r = params.getDhtNodes();

        assertEquals(2, r.size());
        assertTrue(r.contains(Pair.of("1.1.1.1", 1)));
        assertTrue(r.contains(Pair.of("2.2.2.2", 2)));
    }

    @Test
    public void testSavePath() {
        AddTorrentParams params = new AddTorrentParams();

        assertEquals("", params.getSavePath());

        params.setSavePath("test");

        assertEquals("test", params.getSavePath());
    }

    @Test
    public void testStorageMode() {
        AddTorrentParams params = new AddTorrentParams();

        assertEquals(StorageMode.STORAGE_MODE_SPARSE, params.getStorageMode());

        params.setStorageMode(StorageMode.STORAGE_MODE_ALLOCATE);

        assertEquals(StorageMode.STORAGE_MODE_ALLOCATE, params.getStorageMode());
    }
}
