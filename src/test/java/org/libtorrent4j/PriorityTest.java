package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.int_vector;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 * @author gubatron
 */
public class PriorityTest {

    @Test
    public void testArray2vector() {
        Priority[] arr = Priority.array(Priority.DEFAULT, 10);
        int_vector vec = Priority.array2vector(arr);
        assertEquals(arr.length, vec.size());

        for (int i = 0; i < arr.length; i++) {
            assertEquals(Priority.DEFAULT.swig(), vec.get(i));
        }
    }

    @Test
    public void testVector2Array() {
        int_vector v = new int_vector();

        for (int i = 0; i < 10; i++) {
            v.push_back(Priority.DEFAULT.swig());
        }

        Priority[] arr = Priority.vector2array(v);
        assertEquals(arr.length, v.size());

        for (int i = 0; i < arr.length; i++) {
            assertEquals(Priority.DEFAULT, arr[i]);
        }
    }
}
