package org.libtorrent4j.demo;

import org.libtorrent4j.BDecodeNode;
import org.libtorrent4j.Utils;

import java.io.File;

/**
 * @author gubatron
 * @author aldenml
 */
public final class ReadBEncoded {

    public static void main(String[] args) throws Throwable {
        args = new String[]{"/Users/aldenml/Downloads/ubuntu-19.10-desktop-amd64.iso.torrent"};

        byte[] data = Utils.readFileToByteArray(new File(args[0]));

        BDecodeNode n = BDecodeNode.bdecode(data);

        System.out.println(n);
    }
}
