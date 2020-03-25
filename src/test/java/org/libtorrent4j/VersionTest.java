package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class VersionTest {

    @Test
    public void testLibtorrent4jVersion() {
        assertTrue(LibTorrent.libtorrent4jVersion().startsWith("1.3.0"));
    }
}
