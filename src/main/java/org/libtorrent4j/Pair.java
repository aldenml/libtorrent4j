/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.string_int_pair;
import org.libtorrent4j.swig.string_string_pair;

import java.util.Objects;

/**
 * Utility function to mirror the C++ std::pair class
 *
 * @author gubatron
 * @author aldenml
 */
public final class Pair<T1, T2> {

    /**
     * @param first  first element
     * @param second second element
     */
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * the first element
     */
    public final T1 first;

    /**
     * the second element
     */
    public final T2 second;

    /**
     * @return a native object
     */
    string_string_pair to_string_string_pair() {
        if (!String.class.equals(first.getClass()) || !String.class.equals(second.getClass())) {
            throw new IllegalArgumentException("Incompatible types");
        }

        return new string_string_pair((String) first, (String) second);
    }

    /**
     * @return a native object
     */
    string_int_pair to_string_int_pair() {
        if (!String.class.equals(first.getClass()) || !Integer.class.equals(second.getClass())) {
            throw new IllegalArgumentException("Incompatible types");
        }

        return new string_int_pair((String) first, (Integer) second);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair<?, ?>)) {
            return false;
        }

        Pair<?, ?> p = (Pair<?, ?>) obj;

        return first.equals(p.first) && second.equals(p.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second) {
        return new Pair<>(first, second);
    }
}
