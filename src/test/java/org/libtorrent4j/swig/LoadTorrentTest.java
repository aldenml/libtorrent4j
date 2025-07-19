/*
 * Copyright (c) 2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.swig;

import org.junit.Test;
import org.libtorrent4j.Utils;
import org.libtorrent4j.Vectors;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class LoadTorrentTest {

    @Test
    public void testLoadTorrentFileFromBytes() throws IOException {
        byte[] bytes = Utils.resourceBytes("Honey_Larochelle_Hijack_FrostClick_FrostWire_MP3_May_06_2016.torrent");

        byte_vector buffer = Vectors.bytes2byte_vector(bytes);
        bdecode_node e = new bdecode_node();
        error_code ec = new error_code();
        int ret = bdecode_node.bdecode(buffer, e, ec);

        assertEquals("failed to decode torrent: " + ec.message(), 0, ret);

        add_torrent_params params = libtorrent.load_torrent_parsed(e);
        assertEquals("83e37aea34581ce105af93c0955e7c7d4194ae47", params.getInfo_hashes().getV1().to_hex());
    }
}
