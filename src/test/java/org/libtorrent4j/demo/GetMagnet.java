/*
 * Copyright (c) 2018-2022, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.demo;

import org.libtorrent4j.*;
import org.libtorrent4j.alerts.Alert;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author gubatron
 * @author aldenml
 */
public final class GetMagnet {

    public static void main(String[] args) throws Throwable {

        //String uri = "magnet:?xt=urn:btih:86d0502ead28e495c9e67665340f72aa72fe304e&dn=Frostwire.5.3.6.+%5BWindows%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Fopen.demonii.com%3A1337";
        String uri = "magnet:?xt=urn:btih:3b245504cf5f11bbdbe1201cea6a6bf45aee1bc0";

        final SessionManager s = new SessionManager();
        //final SessionManager s = new SessionManager(true);

        /*s.addListener(new AlertListener() {
            @Override
            public int[] types() {
                return null;
            }

            @Override
            public void alert(Alert<?> alert) {
                System.out.println(alert);
            }
        });*/

        SettingsPack sp = new SettingsPack();
        //sp.listenInterfaces("0.0.0.0:43567");
        //sp.listenInterfaces("[::]:43567");
        //sp.listenInterfaces("0.0.0.0:43567,[::]:43567");
        //sp.setString(settings_pack.string_types.dht_bootstrap_nodes.swigValue(), "router.silotis.us:6881");
        //sp.setString(settings_pack.string_types.dht_bootstrap_nodes.swigValue(), "router.bittorrent.com:6881");
        //sp.setString(settings_pack.string_types.dht_bootstrap_nodes.swigValue(), "dht.transmissionbt.com:6881");

        SessionParams params = new SessionParams(sp);

        s.start(params);

        final CountDownLatch signal = new CountDownLatch(1);

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long nodes = s.stats().dhtNodes();
                // wait for at least 10 nodes in the DHT.
                if (nodes >= 10) {
                    System.out.println("DHT contains " + nodes + " nodes");
                    signal.countDown();
                    timer.cancel();
                }
            }
        }, 0, 1000);

        System.out.println("Waiting for nodes in DHT (10 seconds)...");
        boolean r = signal.await(40, TimeUnit.SECONDS);
        if (!r) {
            System.out.println("DHT bootstrap timeout");
            System.exit(0);
        }

        System.out.println("Fetching the magnet uri, please wait...");
        byte[] data = s.fetchMagnet(uri, 30, new File("/tmp"));

        if (data != null) {
            System.out.println(Entry.bdecode(data));
        } else {
            System.out.println("Failed to retrieve the magnet");
        }

        s.stop();
    }
}
