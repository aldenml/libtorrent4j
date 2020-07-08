package org.libtorrent4j;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

/**
 * INTERNAL
 *
 * @author aldenml
 */
public final class Log {

    private static final Logger LOGGER = Logger.getLogger("lt4j");

    private Log() {
    }

    public static void error(String message, Throwable thrown) {
        LOGGER.log(SEVERE, message, thrown);
    }

    public static void warn(String message, Throwable thrown) {
        LOGGER.log(WARNING, message, thrown);
    }
}
