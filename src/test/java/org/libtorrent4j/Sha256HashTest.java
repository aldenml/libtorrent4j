/*
 * Copyright (c) 2018-2021, Alden Torres
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
public class Sha256HashTest {

    @Test
    public void testHashCode() {
        byte[] arr = new byte[32];
        Arrays.fill(arr, (byte) 2);
        Sha256Hash h = Sha256Hash.fromBytes(arr);
        assertEquals(Arrays.hashCode(arr), h.hashCode());
    }

    @Test
    public void testParseHex() {
        byte[] arr = new byte[32];
        Random rand = new Random();
        rand.nextBytes(arr);

        Sha256Hash h1 = Sha256Hash.fromBytes(arr);
        Sha256Hash h2 = Sha256Hash.parseHex(Hex.encode(arr));

        assertEquals(h1, h2);
    }
}
