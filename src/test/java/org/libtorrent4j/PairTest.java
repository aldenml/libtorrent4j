/*
 * Copyright (c) 2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.string_int_pair;
import org.libtorrent4j.swig.string_string_pair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author aldenml
 */
public class PairTest {

    @Test
    public void testToStringString() {

        Pair<String, String> p = Pair.of("1", "2");

        string_string_pair r = p.to_string_string_pair();

        assertEquals("1", r.getFirst());
        assertEquals("2", r.getSecond());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToStringStringFail() {

        Pair<String, Integer> p = Pair.of("1", 2);

        p.to_string_string_pair();
    }

    @Test
    public void testToStringInt() {

        Pair<String, Integer> p = Pair.of("1", 2);

        string_int_pair r = p.to_string_int_pair();

        assertEquals("1", r.getFirst());
        assertEquals(2, r.getSecond());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToStringIntFail() {

        Pair<Integer, String> p = Pair.of(1, "2");

        p.to_string_int_pair();
    }

    @Test
    public void testEquals() {

        Pair<String, Integer> p1 = Pair.of("1", 2);
        Pair<String, Integer> p2 = Pair.of("1", 2);
        Pair<String, Integer> p3 = Pair.of("3", 3);

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
    }

    @Test
    public void testHashCode() {

        Pair<String, Integer> p1 = Pair.of("1", 2);
        Pair<String, Integer> p2 = Pair.of("1", 2);
        Pair<String, Integer> p3 = Pair.of("3", 3);

        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }
}
