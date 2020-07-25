/*
 * Copyright (c) 2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.demo;

import org.libtorrent4j.AlertListener;
import org.libtorrent4j.SessionManager;
import org.libtorrent4j.alerts.Alert;

/**
 * @author gubatron
 * @author aldenml
 */
public final class SessionTest {

    public static void main(String[] args) throws Throwable {

        SessionManager s = new SessionManager();

        s.addListener(new AlertListener() {
            @Override
            public int[] types() {
                return null;
            }

            @Override
            public void alert(Alert<?> alert) {
                System.out.println(alert);
            }
        });

        s.start();

        System.out.println("Press ENTER to exit");
        System.in.read();

        s.stop();
    }
}
