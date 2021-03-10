package org.libtorrent4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.libtorrent4j.swig.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.libtorrent4j.swig.libtorrent.add_files_ex;
import static org.libtorrent4j.swig.libtorrent.set_piece_hashes_ex;

/**
 * @author gubatron
 * @author aldenml
 */
public class CreateTorrentTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testFromFile() throws IOException {
        final File f = folder.newFile("test.txt");
        Utils.writeByteArrayToFile(f, new byte[]{0}, false);

        file_storage fs = new file_storage();
        add_files_listener l1 = new add_files_listener() {
            @Override
            public boolean pred(String p) {
                assertEquals(f.getAbsolutePath(), p);
                return true;
            }
        };
        add_files_ex(fs, f.getAbsolutePath(), l1, new create_flags_t());
        create_torrent ct = new create_torrent(fs);
        set_piece_hashes_listener l2 = new set_piece_hashes_listener() {
            @Override
            public void progress(int i) {
                assertTrue(i >= 0);
            }
        };
        error_code ec = new error_code();
        set_piece_hashes_ex(ct, f.getParent(), l2, ec);
        assertEquals(ec.value(), 0);
        entry e = ct.generate();
        byte_vector buffer = e.bencode();
        TorrentInfo ti = TorrentInfo.bdecode(Vectors.byte_vector2bytes(buffer));
        assertEquals(1, ti.numFiles());
    }

    @Test
    public void testFromDir() throws IOException {
        File dir = folder.newFolder();
        File f1 = new File(dir, "test.txt");
        Utils.writeByteArrayToFile(f1, new byte[]{0}, false);
        File f2 = new File(dir, "test1.txt");
        Utils.writeByteArrayToFile(f2, new byte[]{0}, false);

        file_storage fs = new file_storage();
        add_files_listener l1 = new add_files_listener() {
            @Override
            public boolean pred(String p) {
                return true;
            }
        };
        add_files_ex(fs, dir.getAbsolutePath(), l1, new create_flags_t());
        create_torrent ct = new create_torrent(fs);
        set_piece_hashes_listener l2 = new set_piece_hashes_listener() {
            @Override
            public void progress(int i) {
                assertTrue(i >= 0);
            }
        };
        error_code ec = new error_code();
        set_piece_hashes_ex(ct, dir.getParent(), l2, ec);
        assertEquals(ec.value(), 0);
        entry e = ct.generate();
        byte_vector buffer = e.bencode();
        TorrentInfo ti = TorrentInfo.bdecode(Vectors.byte_vector2bytes(buffer));
        assertEquals(3, ti.numFiles());
    }

    @Test
    public void testUsingBuilder() throws IOException {
        File dir = folder.newFolder();
        File f1 = new File(dir, "test.txt");
        Utils.writeByteArrayToFile(f1, new byte[]{0}, false);
        File f2 = new File(dir, "test1.txt");
        Utils.writeByteArrayToFile(f2, new byte[]{0}, false);

        TorrentBuilder b = new TorrentBuilder();
        TorrentBuilder.Result r = b.path(dir)
            .comment("comment")
            .creator("creator")
            .creationDate(1000)
            .addUrlSeed("http://urlseed/")
            .addNode(new Pair<>("1.1.1.1", 1))
            .addTracker("udp://tracker/")
            .setPrivate(true)
            .addSimilarTorrent(Sha1Hash.min())
            .addCollection("collection")
            .generate();

        TorrentInfo ti = TorrentInfo.bdecode(r.entry().bencode());
        assertEquals("comment", ti.comment());
        assertEquals("creator", ti.creator());
        assertEquals(1000, ti.creationDate());

        ArrayList<WebSeedEntry> seeds = ti.webSeeds();
        for (WebSeedEntry e : seeds) {
            assertEquals("http://urlseed/", e.url());
        }

        assertEquals("1.1.1.1", ti.nodes().get(0).first);
        assertEquals("udp://tracker/", ti.trackers().get(0).url());
        assertTrue(ti.isPrivate());
        assertTrue(ti.similarTorrents().get(0).isAllZeros());
        assertEquals("collection", ti.collections().get(0));
        assertEquals(3, ti.numFiles());
    }

    @Test
    public void testBuilderListener() throws IOException {
        File dir = folder.newFolder();
        File f1 = new File(dir, "test.txt");
        Utils.writeByteArrayToFile(f1, new byte[]{0, 0}, false);
        File f2 = new File(dir, "test1.txt");
        Utils.writeByteArrayToFile(f2, new byte[]{0, 0}, false);

        final AtomicBoolean b1 = new AtomicBoolean();
        final AtomicBoolean b2 = new AtomicBoolean();

        TorrentBuilder b = new TorrentBuilder();
        TorrentBuilder.Result r = b.path(dir)
            .listener(new TorrentBuilder.Listener() {
                @Override
                public boolean accept(String filename) {
                    b1.set(true);
                    return true;
                }

                @Override
                public void progress(int piece, int total) {
                    b2.set(true);
                }
            })
            .generate();

        TorrentInfo ti = TorrentInfo.bdecode(r.entry().bencode());
        assertEquals(3, ti.numFiles());
        assertTrue(b1.get());
        assertTrue(b2.get());

        assertEquals(16386, ti.totalSize());
        assertEquals(4, ti.sizeOnDisk());
    }
}
