/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class VersionTest {

    @Test
    public void testLibtorrent4jVersionValue() {
        assertTrue(LibTorrent.libtorrent4jVersion().startsWith("2.0.3-"));
    }

    @Test
    public void testVersionValue() {
        assertEquals("2.0.3.0", LibTorrent.version());
    }
}
