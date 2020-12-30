package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author aldenml
 */
public class InfoHashTest {

    @Test
    public void testDefaultConstructor() {
        InfoHash ih = new InfoHash();

        assertFalse(ih.hasV1());
        assertFalse(ih.hasV2());
    }
}
