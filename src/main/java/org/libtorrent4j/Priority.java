/*
 * Copyright (c) 2018-2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.byte_vector;

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
        this.swigValue = (byte) swigValue;
    }

    private final byte swigValue;

    /**
     * @return the native value
     */
    public byte swig() {
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

    /**
     * Creates an array of `size` elements with the specified `value.
     *
     * @param value the value of each array element.
     * @param size the size of the new array.
     * @return an array of `size` elements with the specified `value.
     */
    public static Priority[] array(Priority value, int size) {
        Priority[] arr = new Priority[size];

        for (int i = 0; i < size; i++) {
            arr[i] = value;
        }

        return arr;
    }

    static byte_vector array2vector(Priority[] arr) {
        byte_vector v = new byte_vector();

        for (int i = 0; i < arr.length; i++) {
            Priority p = arr[i];
            v.add(p.swig());
        }

        return v;
    }

    static Priority[] vector2array(byte_vector v) {
        int size = v.size();
        Priority[] arr = new Priority[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Priority.fromSwig(v.get(i));
        }
        return arr;
    }
}
