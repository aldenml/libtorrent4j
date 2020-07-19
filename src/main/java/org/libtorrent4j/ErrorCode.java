/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.error_code;

/**
 * @author gubatron
 * @author aldenml
 */
public final class ErrorCode {

    private int value;
    private String message;
    private boolean isError;

    /**
     * @param ec the native object
     */
    public ErrorCode(error_code ec) {
        assign(ec);
    }

    /**
     * @return the internal error code value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns if this error code actually represents an error.
     *
     * @return true if an actual error
     */
    public boolean isError() {
        return isError;
    }

    void assign(error_code ec) {
        value = ec.value();
        message = ec.message();
        isError = ec.to_bool();
    }
}
