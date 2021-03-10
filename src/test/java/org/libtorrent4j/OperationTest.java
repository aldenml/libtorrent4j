/*
 * Copyright (c) 2018-2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.libtorrent4j.Operation.FILE_MMAP;
import static org.libtorrent4j.Operation.FILE_TRUNCATE;
import static org.libtorrent4j.Operation.HOSTNAME_LOOKUP;

/**
 * @author aldenml
 */
public class OperationTest {

    @Test
    public void testNativeName() {

        assertEquals("hostname_lookup", HOSTNAME_LOOKUP.nativeName());

        assertEquals("file_mmap", FILE_MMAP.nativeName());
        assertEquals("file_truncate", FILE_TRUNCATE.nativeName());
    }

    @Test
    public void testInvalidValue() {

        assertEquals(Operation.UNKNOWN, Operation.fromSwig(-1));
        assertEquals(Operation.UNKNOWN, Operation.fromSwig(1000));
    }
}
