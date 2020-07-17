/*
 * Created by Alden Torres (aldenml)
 *
 * Licensed under the MIT License.
 */

package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.byte_vector;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class VectorsTest {

    @Test
    public void testByteVector2String() {
        byte_vector v = new byte_vector();
        v.add((byte) 'A');
        v.add((byte) 'B');
        v.add((byte) 'C');
        assertEquals(Vectors.byte_vector2ascii(v), "ABC");

        v.clear();
        v.add((byte) 'A');
        v.add((byte) 'B');
        v.add((byte) 0);
        assertEquals(Vectors.byte_vector2ascii(v), "AB");

        v.clear();
        v.add((byte) 0);
        v.add((byte) 0);
        v.add((byte) 0);
        assertEquals(Vectors.byte_vector2ascii(v), "");

        v.clear();
        v.add((byte) 'A');
        v.add((byte) 0);
        v.add((byte) 'B');
        assertEquals(Vectors.byte_vector2ascii(v), "A");

        v.clear();
        v.add((byte) 194);
        v.add((byte) 181);
        assertEquals(Vectors.byte_vector2utf8(v), "µ");
    }

    @Test
    public void testUnicodeConversion() {
        String s = "µ";
        byte[] javaBytes = s.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < javaBytes.length; i++) {
            System.out.println("Unicode java byte: " + i + "=" + javaBytes[i]);
        }
        byte_vector v = Vectors.string2byte_vector(s, "utf-8");
        for (int i = 0; i < v.size(); i++) {
            System.out.println("Unicode jni byte: " + i + "=" + v.get(i));
        }

        assertEquals(javaBytes.length, v.size());
    }
}
