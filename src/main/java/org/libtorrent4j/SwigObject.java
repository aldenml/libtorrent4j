/*
 * Copyright (c) 2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

/**
 * Represents an object that it is wrapper of a native
 * one.
 *
 * @author aldenml
 */
public class SwigObject<T> {

    // the native object handler
    protected final T h;

    /**
     * @param handler the native object handler
     */
    public SwigObject(T handler) {
        this.h = handler;
    }

    /**
     * Returns a reference to the native object handler.
     *
     * @return the internal native handle.
     */
    public final T swig() {
        return h;
    }
}
