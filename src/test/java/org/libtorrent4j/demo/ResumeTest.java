package org.libtorrent4j.demo;

import org.libtorrent4j.AlertListener;
import org.libtorrent4j.Entry;
import org.libtorrent4j.SessionManager;
import org.libtorrent4j.TorrentHandle;
import org.libtorrent4j.TorrentInfo;
import org.libtorrent4j.Utils;
import org.libtorrent4j.Vectors;
import org.libtorrent4j.alerts.AddTorrentAlert;
import org.libtorrent4j.alerts.Alert;
import org.libtorrent4j.alerts.AlertType;
import org.libtorrent4j.alerts.SaveResumeDataAlert;
import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.libtorrent;
import org.libtorrent4j.swig.torrent_flags_t;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class ResumeTest {

    public static void main(String[] args) throws Throwable {
        File torrentFile = new File("/Users/aldenml/Downloads/ubuntu-19.10-desktop-amd64.iso.torrent");

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
                        break;
                    case TORRENT_FINISHED:
                        System.out.println("Torrent finished");
                        //((TorrentFinishedAlert) alert).handle().saveResumeData(TorrentHandle.SAVE_INFO_DICT);
                        break;
                    case TORRENT_PAUSED:
                        System.out.println("Torrent paused");
                        break;
                    case SAVE_RESUME_DATA:
                        System.out.println("Torrent saveResumeData");
                        serializeResumeData((SaveResumeDataAlert) alert);
                        signalResumeData.countDown();
                        break;
//                    case STATS:
//                        TorrentHandle th = ((StatsAlert) alert).handle();
//                        if (th.status().isFinished()) {
//                            TorrentStatus ts = th.status();
//                            System.out.println(String.format("seeding time=%d\nactive time=%d\n",
//                                    ts.seedingDuration(), ts.activeDuration()));
//                            signal.countDown();
//                        }
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
