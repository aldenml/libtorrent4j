/*
 * Copyright (c) 2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.demo;

import org.libtorrent4j.*;
import org.libtorrent4j.alerts.AddTorrentAlert;
import org.libtorrent4j.alerts.Alert;
import org.libtorrent4j.alerts.AlertType;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * To test issue <a href="https://github.com/aldenml/libtorrent4j/issues/231">#231</a>
 *
 * @author aldenml
 */
public final class MagnetTrackers {

    public static void main(String[] args) {

        // code taken from
        // https://github.com/aldenml/libtorrent4j/issues/231#issuecomment-1484044863
        // author proninyaroslav

        // File torrentFile = new File(args[0]);
        File parentDir = new File("/Users/aldenml/Downloads");// torrentFile.getParentFile();
        String magnetUri = "magnet:?xt=urn:btih:3b245504cf5f11bbdbe1201cea6a6bf45aee1bc0&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80";

        final SessionManager s = new SessionManager();

        final CountDownLatch signal = new CountDownLatch(2);

        s.addListener(new AlertListener() {
            @Override
            public int[] types() {
                return null;
            }

            @Override
            public void alert(Alert<?> alert) {
                AlertType type = alert.type();

                switch (type) {
                    case ADD_TORRENT:
                        TorrentHandle th = ((AddTorrentAlert) alert).handle();
                        th.pause();
                        System.out.println("Torrent added: " + th.getName());
                        System.out.println("Trackers:");
                        for (AnnounceEntry tracker : th.trackers()) {
                            System.out.println(tracker.url());
                        }
                        signal.countDown();
                        break;
                    case SESSION_STATS:
                        s.postDhtStats();
                        break;
                }
            }
        });

        s.start();
        s.postDhtStats();

        TorrentInfo ti;
        // Add torrent file
        //TorrentInfo ti = new TorrentInfo(torrentFile);
        //s.download(ti, parentDir);

        // Fetching the magnet uri, waiting 30 seconds max
        byte[] data = s.fetchMagnet(magnetUri, 30, new File("/tmp"));
        BDecodeNode n = BDecodeNode.bdecode(data);
        System.out.println(n);

        // Add magnet
        ti = new TorrentInfo(data);
        s.download(ti, parentDir);

        try {
            signal.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        s.stop();
    }
}
