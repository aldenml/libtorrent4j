package org.libtorrent4j;

/**
 * @author aldenml
 */
public final class AnnounceFlags {

    private AnnounceFlags() {
    }

    /**
     * Announce to DHT as a seed.
     */
    public static final byte SEED = 1; // 1 << 0

    /**
     * Announce to DHT with the implied-port flag set. This tells the network to use
     * your source UDP port as your listen port, rather than the one specified in
     * the message. This may improve the chances of traversing NATs when using uTP.
     */
    public static final byte IMPLIED_PORT = (1 << 1);

    /**
     * Specify the port number for the SSL listen socket in the DHT announce.
     */
    public static final byte SSL_TORRENT = 1 << 2;
}
