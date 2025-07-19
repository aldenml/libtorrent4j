/*
 * Copyright (c) 2023-2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.demo;

import org.libtorrent4j.*;
import org.libtorrent4j.alerts.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

/**
 * @author aldenml
 */
public final class DownloadWebTorrent {

    public static void main(String[] args) throws Throwable {

        File torrentFile = new File(args[0]);

        System.out.println("Using libtorrent version: " + LibTorrent.version());

        final SessionManager s = new SessionManager(false);
        s.stopDht();

        final CountDownLatch signal = new CountDownLatch(1);

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
                        System.out.println("Torrent added");
                        ((AddTorrentAlert) alert).handle().resume();
                        break;
                    case BLOCK_FINISHED:
                        BlockFinishedAlert a = (BlockFinishedAlert) alert;
                        int p = (int) (a.handle().status().progress() * 100);
                        System.out.println("Progress: " + p + " for torrent name: " + a.handle().getName());
                        System.out.println(s.stats().totalDownload());
                        break;
                    case TORRENT_FINISHED:
                        System.out.println("Torrent finished");
                        signal.countDown();
                        break;
                    case PEER_LOG:
                        PeerLogAlert peerLogAlert = (PeerLogAlert) alert;
                        //System.out.println("PEER LOG: " + peerLogAlert.logMessage());
                        break;
                    case TORRENT_LOG:
                        TorrentLogAlert torrentLogAlert = (TorrentLogAlert) alert;
                        //System.out.println("TORRENT LOG: " + torrentLogAlert.logMessage());
                        break;
                }
            }
        });

        s.start();

        TorrentInfo ti = new TorrentInfo(torrentFile);
        s.download(ti, torrentFile.getParentFile());

        TorrentHandle th = s.find(ti.infoHash());
        for (AnnounceEntry t: th.trackers()) {
            System.out.println("Using tracker: " + t.url());
        }

        signal.await();

        s.stop();
    }
}
