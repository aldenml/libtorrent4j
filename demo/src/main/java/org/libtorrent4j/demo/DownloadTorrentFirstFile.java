/*
 * Copyright (c) 2022, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.demo;

import org.libtorrent4j.*;
import org.libtorrent4j.alerts.AddTorrentAlert;
import org.libtorrent4j.alerts.Alert;
import org.libtorrent4j.alerts.AlertType;
import org.libtorrent4j.alerts.BlockFinishedAlert;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * @author aldenml
 */
public final class DownloadTorrentFirstFile {

    public static void main(String[] args) throws Throwable {

        File torrentFile = new File(args[0]);

        System.out.println("Using libtorrent version: " + LibTorrent.version());

        final SessionManager s = new SessionManager();

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
                        System.out.println("Progress: " + p + " for torrent name: " + a.torrentName());
                        System.out.println(s.stats().totalDownload());
                        break;
                    case TORRENT_FINISHED:
                        System.out.println("Torrent finished");
                        signal.countDown();
                        break;
                }
            }
        });

        s.start();

        TorrentInfo ti = new TorrentInfo(torrentFile);

        Priority[] priorities = Priority.array(Priority.IGNORE, ti.numFiles());
        priorities[0] = Priority.TOP_PRIORITY;
        s.download(ti, torrentFile.getParentFile(), null, priorities, null, TorrentFlags.SEQUENTIAL_DOWNLOAD);

        signal.await();

        s.stop();
    }
}
