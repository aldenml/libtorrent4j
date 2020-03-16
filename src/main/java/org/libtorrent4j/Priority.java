package org.libtorrent4j;

import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.int_vector;

/**
 * @author gubatron
 * @author aldenml
 */
public enum Priority {

    /**
     * piece or file is not downloaded at all
     */
    IGNORE(0),

    /**
     *
     */
    LOW(1),

    /**
     * higher than normal priority. Pieces are preferred over pieces with
     * the same availability, but not over pieces with lower availability
     */
    TWO(2),

    /**
     * pieces are as likely to be picked as partial pieces.
     */
    THREE(3),

    /**
     * pieces are preferred over partial pieces, but not over pieces with
     * lower availability
     */
    DEFAULT(4),

    /**
     *
     */
    FIVE(5),

    /**
     *
     */
    SIX(6),

    /**
     * maximum priority, availability is disregarded, the piece is
     * preferred over any other piece with lower priority
     */
    TOP_PRIORITY(7);

    Priority(int swigValue) {
        this.swigValue = swigValue;
    }

    private final int swigValue;

    /**
     * @return the native value
     */
    public int swig() {
        return swigValue;
    }

    /**
     * @param swigValue the native value
     * @return the enum corresponding value
     */
    public static Priority fromSwig(int swigValue) {
        Priority[] enumValues = Priority.class.getEnumConstants();
        for (Priority ev : enumValues) {
            if (ev.swig() == swigValue) {
                return ev;
            }
        }
        throw new IllegalArgumentException("Invalid native value");
    }

    public static Priority[] array(Priority value, int size) {
        Priority[] arr = new Priority[size];

        for (int i = 0; i < size; i++) {
            arr[i] = value;
        }

        return arr;
    }

    static int_vector array2vector(Priority[] arr) {
        int_vector v = new int_vector();

        for (int i = 0; i < arr.length; i++) {
            Priority p = arr[i];
            v.add(p.swig());
        }

        return v;
    }

    static byte_vector array2byte_vector(Priority[] arr) {
        byte_vector v = new byte_vector();

        for (int i = 0; i < arr.length; i++) {
            Priority p = arr[i];
            v.add((byte) p.swig());
        }

        return v;
    }

    static Priority[] vector2array(int_vector v) {
        int size = (int) v.size();
        Priority[] arr = new Priority[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Priority.fromSwig(v.get(i));
        }
        return arr;
    }
}
