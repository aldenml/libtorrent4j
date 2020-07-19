/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class Sha1HashTest {

    @Test
    public void testHashCode() {
        byte[] arr = new byte[20];
        Arrays.fill(arr, (byte) 2);
        Sha1Hash h = Sha1Hash.fromBytes(arr);
        assertEquals(Arrays.hashCode(arr), h.hashCode());
    }

    @Test
    public void testParseHex() {
        byte[] arr = new byte[20];
        Random rand = new Random();
        rand.nextBytes(arr);

        Sha1Hash h1 = Sha1Hash.fromBytes(arr);
        Sha1Hash h2 = Sha1Hash.parseHex(Hex.encode(arr));

        assertEquals(h1, h2);
    }
}
