/*
 * Copyright (c) 2018-2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.demo;

import org.libtorrent4j.*;
import org.libtorrent4j.alerts.*;
import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.libtorrent;
import org.libtorrent4j.swig.torrent_flags_t;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class ResumeTest {

    public static void main(String[] args) throws Throwable {
        File torrentFile = new File("/Users/aldenml/Downloads/ubuntu-24.04.2-desktop-amd64.iso.torrent");

        final SessionManager s = new SessionManager();
        final CountDownLatch signal = new CountDownLatch(10);
        final CountDownLatch signalResumeData = new CountDownLatch(1);
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
                        s.swig().post_torrent_updates();
                        break;
                    case TORRENT_FINISHED:
                        System.out.println("Torrent finished");
                        //((TorrentFinishedAlert) alert).handle().saveResumeData(TorrentHandle.SAVE_INFO_DICT);
                        break;
                    case TORRENT_PAUSED:
                        System.out.println("Torrent paused");
                        s.swig().post_torrent_updates();
                        break;
                    case SAVE_RESUME_DATA:
                        System.out.println("Torrent saveResumeData");
                        serializeResumeData((SaveResumeDataAlert) alert);
                        signalResumeData.countDown();
                        s.swig().post_torrent_updates();
                        break;
                    case STATE_UPDATE:
                        StateUpdateAlert sua = (StateUpdateAlert) alert;
                        sua.status().forEach(ts -> {
                            System.out.println(String.format("state update: name:%s seeding time=%d\nactive time=%d\n",
                                ts.name(),
                                ts.seedingDuration(),
                                ts.activeDuration()));

                            TorrentHandle th = new TorrentHandle(ts.swig().getHandle());
                            if (th.status().isFinished()) {
                                signal.countDown();
                            }
                        });
//                    case STATS:
//                        TorrentHandle th = ((StatsAlert) alert).handle();
//                        if (th.status().isFinished()) {
//                            TorrentStatus ts = th.status();
//                            System.out.println(String.format("seeding time=%d\nactive time=%d\n",
//                                    ts.seedingDuration(), ts.activeDuration()));
//                            signal.countDown();
//                        }
//                        break;
//                    default:
//                        System.out.println(alert);
//                        break;
                }
            }
        });

        s.start();
        TorrentInfo ti = new TorrentInfo(torrentFile);
        s.download(ti, torrentFile.getParentFile());
        signal.await();

        // save resume data just before restarting session
        s.find(ti.infoHash()).saveResumeData(TorrentHandle.SAVE_INFO_DICT);

        signalResumeData.await();

        System.out.println(Entry.bdecode(new File("resume.dat")).toString());

        s.restart();
        s.download(ti, torrentFile.getParentFile(), new File("resume.dat"), null, null, new torrent_flags_t());

        System.in.read();
        s.stop();
    }

    private static void serializeResumeData(SaveResumeDataAlert alert) {
        File resume = new File("resume.dat");
        if (resume.exists())
            return;
        byte_vector data = libtorrent.write_resume_data(alert.params().swig()).bencode();
        try {
            Utils.writeByteArrayToFile(resume, Vectors.byte_vector2bytes(data), false);
        } catch (IOException e) {
            System.err.println("Error saving resume data");
        }
    }
}
