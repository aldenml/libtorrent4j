/*
 * Copyright (c) 2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class SessionManagerTest {

    @Test
    public void testDefaultDhtBoostrap() {
        SessionManager s = new SessionManager();

        String nodes = s.defaultDhtBootstrapNodes();

        assertTrue(nodes.contains("dht.libtorrent.org:25401"));
        assertTrue(nodes.contains("router.bittorrent.com:6881"));
        assertTrue(nodes.contains("router.utorrent.com:6881"));
        assertTrue(nodes.contains("dht.transmissionbt.com:6881"));
    }
}
