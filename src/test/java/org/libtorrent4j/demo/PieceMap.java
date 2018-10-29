package org.libtorrent4j.demo;

import org.libtorrent4j.PiecesTracker;
import org.libtorrent4j.TorrentInfo;

import java.io.File;

/**
 * @author gubatron
 * @author aldenml
 */
public final class PieceMap {


    public static void main(String[] args) throws Throwable {

        // comment this line for a real application
        args = new String[]{"/Users/aldenml/Downloads/ReSet_Resynthformation_SOSEP051_FrostClick_FrostWire_6_28_2014.torrent"};

        File torrentFile = new File(args[0]);

        TorrentInfo ti = new TorrentInfo(torrentFile);

        int numFiles = ti.numFiles();
        int numPieces = ti.numPieces();

        System.out.println("Num Pieces: " + numPieces);

        PiecesTracker tracker = new PiecesTracker(ti);

        for (int i = 0; i < numPieces / 2; i++) {
            tracker.setComplete(i, true);
        }

        for (int i = 0; i < numFiles; i++) {
            System.out.println("File index (seq)completed: " + tracker.getSequentialDownloadedBytes(i));
        }
    }
}
