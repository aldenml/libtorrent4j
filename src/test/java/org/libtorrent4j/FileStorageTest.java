/*
 * Copyright (c) 2018-2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author gubatron
 * @author aldenml
 */
public class FileStorageTest {

    @Test
    public void testFileName() throws IOException {
        byte[] data = Utils.resourceBytes("test5.torrent");
        TorrentInfo ti = TorrentInfo.bdecode(data);
        String name = ti.files().fileName(0);
        assertEquals("frostwire-6.2.3.windows.fusion.exe", name);
    }
}
