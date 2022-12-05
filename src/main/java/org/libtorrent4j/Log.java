/*
 * Copyright (c) 2018-2022, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

/**
 * @author aldenml
 */
final class Log {

    private static final Logger LOGGER = Logger.getLogger("lt4j");

    private Log() {
    }

    public static void error(String message, Throwable thrown) {
        LOGGER.log(SEVERE, message, thrown);
    }

    public static void error(String message) {
        LOGGER.log(SEVERE, message);
    }

    public static void warn(String message, Throwable thrown) {
        LOGGER.log(WARNING, message, thrown);
    }

    public static void warn(String message) {
        LOGGER.log(WARNING, message);
    }
}
