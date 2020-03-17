package org.libtorrent4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class AddTorrentParamsTest {

    @Test
    public void testVersion() {
        AddTorrentParams params = new AddTorrentParams();
        assertEquals(20000, params.version());
    }

    @Test
    public void testTrackers() {
        AddTorrentParams params = new AddTorrentParams();

        assertTrue(params.trackers().isEmpty());

        List<String> trackers = new ArrayList<>(2);
        trackers.add("http://tracker1");
        trackers.add("http://tracker2");

        params.trackers(trackers);

        List<String> r = params.trackers();

        assertEquals(2, r.size());
        assertTrue(r.contains("http://tracker1"));
        assertTrue(r.contains("http://tracker2"));
    }

    @Test
    public void testTrackerTiers() {
        AddTorrentParams params = new AddTorrentParams();

        assertTrue(params.trackerTiers().isEmpty());

        List<Integer> tiers = new ArrayList<>(2);
        tiers.add(10);
        tiers.add(20);

        params.trackerTiers(tiers);

        List<Integer> r = params.trackerTiers();

        assertEquals(2, r.size());
        assertTrue(r.contains(10));
        assertTrue(r.contains(20));
    }
}
