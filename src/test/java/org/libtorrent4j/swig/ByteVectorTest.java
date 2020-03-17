package org.libtorrent4j.swig;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class ByteVectorTest {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public synchronized void testEmptyCreation() {
        // this line is important to link native ahead of time
        // while debugging, any static method will do it
        libtorrent.version();

        byte_vector v = new byte_vector();
        assertTrue(v.isEmpty());
    }
}
