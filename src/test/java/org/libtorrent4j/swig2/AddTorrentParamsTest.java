package org.libtorrent4j.swig2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class AddTorrentParamsTest {

    @Test
    public void testEmptyFilePriorities() {
        add_torrent_params params = new add_torrent_params();

        byte_vector empty = params.get_file_priorities();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testSetFilePriorities() {
        add_torrent_params params = new add_torrent_params();

        byte_vector p = new byte_vector(4, (byte) 3);

        params.set_file_priorities(p);

        assertEquals(p, params.get_file_priorities());
    }
}
