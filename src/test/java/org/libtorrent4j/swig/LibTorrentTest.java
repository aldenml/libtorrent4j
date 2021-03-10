/*
 * Copyright (c) 2018-2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.swig;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class LibTorrentTest {

    @Test
    public void testGenerateFingerprint() {
        String fingerprint = libtorrent.generate_fingerprint("TEST",
            1, 2, 3, 4);
        assertEquals("-TE1234-", fingerprint);
    }
}
