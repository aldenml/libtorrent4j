package org.libtorrent4j.swig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.libtorrent4j.TorrentInfo;
import org.libtorrent4j.Utils;
import org.libtorrent4j.Vectors;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.libtorrent4j.swig.libtorrent.add_files_ex;
import static org.libtorrent4j.swig.libtorrent.set_piece_hashes_ex;

/**
 * @author aldenml
 */
public class PosixWrapperTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testSetPosixWrapper() throws IOException {
        AtomicBoolean called = new AtomicBoolean(false);
        posix_wrapper p = new posix_wrapper() {

            @Override
            public long opendir(String name) {
                called.set(true);
                return super.opendir(name);
            }
        };

        libtorrent.set_posix_wrapper(p);

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

        libtorrent.set_posix_wrapper(null);
        assertTrue(called.get());
    }
}
