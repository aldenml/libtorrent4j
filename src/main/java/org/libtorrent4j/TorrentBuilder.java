package org.libtorrent4j;

import org.libtorrent4j.swig.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.libtorrent4j.swig.libtorrent.add_files_ex;
import static org.libtorrent4j.swig.libtorrent.set_piece_hashes_ex;

/**
 * @author gubatron
 * @author aldenml
 */
public final class TorrentBuilder {

    private File path;
    private int pieceSize;
    private create_flags_t flags;
    private int alignment;

    private String comment;
    private String creator;
    private Long creationDate;
    private List<String> urlSeeds;
    private List<Pair<String, Integer>> nodes;
    private List<Pair<String, Integer>> trackers;
    private boolean priv;

    private List<Sha1Hash> similarTorrents;
    private List<String> collections;

    private Listener listener;

    public TorrentBuilder() {
        this.pieceSize = 0;
        this.flags = new create_flags_t();
        this.alignment = -1;

        this.urlSeeds = new LinkedList<>();
        this.nodes = new LinkedList<>();
        this.trackers = new LinkedList<>();

        this.similarTorrents = new LinkedList<>();
        this.collections = new LinkedList<>();
    }

    /**
     *
     */
    public File path() {
        return path;
    }

    /**
     * Adds the file specified by {@code value}
     *
     * @param value
     *
     */
    public TorrentBuilder path(File value) {
        this.path = value;
        return this;
    }

    /**
     *
     */
    public int pieceSize() {
        return pieceSize;
    }

    /**
     * The size of each piece in bytes. It must
     * be a multiple of 16 kiB. If a piece size of 0 is specified, a
     * {@code pieceSize} will be calculated such that the torrent file is roughly 40 kB.
     *
     * @param value
     *
     */
    public TorrentBuilder pieceSize(int value) {
        this.pieceSize = value;
        return this;
    }

    /**
     *
     */
    public create_flags_t flags() {
        return flags;
    }

    /**
     * Specifies options for the torrent creation. It can
     * be any combination of the flags defined by {@link create_flags_t}
     *
     * @param value
     *
     */
    public TorrentBuilder flags(create_flags_t value) {
        this.flags = value;
        return this;
    }

    /**
     *
     */
    public int alignment() {
        return alignment;
    }

    /**
     * Used when pad files are enabled. This is the size
     * eligible files are aligned to. The default is -1, which means the
     * piece size of the torrent.
     *
     * @param value
     *
     */
    public TorrentBuilder alignment(int value) {
        this.alignment = value;
        return this;
    }

    /**
     * The comment for the torrent. The comment in a torrent file is optional.
     *
     *
     */
    public String comment() {
        return comment;
    }

    /**
     * Sets the comment for the torrent. The comment in a torrent file is optional.
     *
     * @param value
     *
     */
    public TorrentBuilder comment(String value) {
        this.comment = value;
        return this;
    }

    /**
     * The creator of the torrent. This is optional.
     *
     *
     */
    public String creator() {
        return creator;
    }

    /**
     * Sets the creator of the torrent. This is optional.
     *
     * @param value
     *
     */
    public TorrentBuilder creator(String value) {
        this.creator = value;
        return this;
    }

    /**
     * The "creation time" field. Defaults to the system clock at the
     * time of construction.
     *
     * The timestamp is specified in seconds, posix time. If the creation
     * date is set to 0, the "creation date" field will be omitted from
     * the generated torrent.
     */
    public long creationDate() {
        return creationDate;
    }

    /**
     * Set the "creation time" field. Defaults to the system clock at the
     * time of construction.
     *
     * The timestamp is specified in seconds, posix time. If the creation
     * date is set to 0, the "creation date" field will be omitted from
     * the generated torrent.
     */
    public TorrentBuilder creationDate(long timestamp) {
        this.creationDate = timestamp;
        return this;
    }

    /**
     *
     */
    public List<String> urlSeeds() {
        return urlSeeds;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder addUrlSeeds(List<String> value) {
        if (value != null) {
            this.urlSeeds.addAll(value);
        }
        return this;
    }

    /**
     * This adds a url seed to the torrent. You can have any number of url seeds. For a
     * single file torrent, this should be an HTTP url, pointing to a file with identical
     * content as the file of the torrent. For a multi-file torrent, it should point to
     * a directory containing a directory with the same name as this torrent, and all the
     * files of the torrent in it.
     *
     * @param value
     *
     */
    public TorrentBuilder addUrlSeed(String value) {
        if (value != null) {
            this.urlSeeds.add(value);
        }
        return this;
    }

    /**
     *
     */
    public List<Pair<String, Integer>> nodes() {
        return nodes;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder addNodes(List<Pair<String, Integer>> value) {
        if (value != null) {
            this.nodes.addAll(value);
        }
        return this;
    }

    /**
     * This adds a DHT node to the torrent. This especially useful if you're creating a
     * tracker less torrent. It can be used by clients to bootstrap their DHT node from.
     * The node is a hostname and a port number where there is a DHT node running.
     * You can have any number of DHT nodes in a torrent.
     *
     * @param value
     *
     */
    public TorrentBuilder addNode(Pair<String, Integer> value) {
        if (value != null) {
            this.nodes.add(value);
        }
        return this;
    }

    /**
     *
     */
    public List<Pair<String, Integer>> trackers() {
        return trackers;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder addTrackers(List<Pair<String, Integer>> value) {
        if (value != null) {
            this.trackers.addAll(value);
        }
        return this;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder addTracker(Pair<String, Integer> value) {
        if (value != null) {
            this.trackers.add(value);
        }
        return this;
    }

    /**
     * Adds a tracker to the torrent. This is not strictly required, but most torrents
     * use a tracker as their main source of peers. The url should be an http:// or udp://
     * url to a machine running a bittorrent tracker that accepts announces for this torrent's
     * info-hash. The tier is the fallback priority of the tracker. All trackers with tier 0 are
     * tried first (in any order). If all fail, trackers with tier 1 are tried. If all of those
     * fail, trackers with tier 2 are tried, and so on.
     *
     * @param url
     * @param tier
     *
     */
    public TorrentBuilder addTracker(String url, int tier) {
        return addTracker(new Pair<>(url, tier));
    }

    /**
     * @param url
     *
     */
    public TorrentBuilder addTracker(String url) {
        return addTracker(url, 0);
    }

    /**
     *
     */
    public boolean isPrivate() {
        return priv;
    }

    /**
     * Sets the private flag of the torrent.
     * <p>
     * Torrents with the private flag set ask clients to not use any other
     * sources than the tracker for peers, and to not advertise itself publicly,
     * apart from the tracker.
     *
     * @param value
     *
     */
    public TorrentBuilder setPrivate(boolean value) {
        this.priv = value;
        return this;
    }

    /**
     *
     */
    public List<Sha1Hash> similarTorrents() {
        return similarTorrents;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder addSimilarTorrents(List<Sha1Hash> value) {
        if (value != null) {
            this.similarTorrents.addAll(value);
        }
        return this;
    }

    /**
     * Add similar torrents (by info-hash).
     * <p>
     * Similar torrents are expected to share some files with this torrent.
     * Torrents sharing a collection name with this torrent are also expected
     * to share files with this torrent. A torrent may have more than one
     * collection and more than one similar torrents. For more information,
     * see BEP 38.
     * <p>
     * BEP 38: http://www.bittorrent.org/beps/bep_0038.html
     *
     * @param value
     *
     */
    public TorrentBuilder addSimilarTorrent(Sha1Hash value) {
        if (value != null) {
            this.similarTorrents.add(value);
        }
        return this;
    }

    /**
     *
     */
    public List<String> collections() {
        return collections;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder addCollections(List<String> value) {
        if (value != null) {
            this.collections.addAll(value);
        }
        return this;
    }

    /**
     * Add collections of similar torrents.
     * <p>
     * Similar torrents are expected to share some files with this torrent.
     * Torrents sharing a collection name with this torrent are also expected
     * to share files with this torrent. A torrent may have more than one
     * collection and more than one similar torrents. For more information,
     * see BEP 38.
     * <p>
     * BEP 38: http://www.bittorrent.org/beps/bep_0038.html
     *
     * @param value
     *
     */
    public TorrentBuilder addCollection(String value) {
        if (value != null) {
            this.collections.add(value);
        }
        return this;
    }

    /**
     *
     */
    public Listener listener() {
        return listener;
    }

    /**
     * @param value
     *
     */
    public TorrentBuilder listener(Listener value) {
        this.listener = value;
        return this;
    }

    /**
     * This function will generate a result withe the .torrent file as a bencode tree.
     *
     *
     * @throws IOException
     */
    public Result generate() throws IOException {
        if (path == null) {
            throw new IOException("path can't be null");
        }

        File absPath = path.getAbsoluteFile();

        file_storage fs = new file_storage();
        add_files_listener l1 = new add_files_listener() {
            @Override
            public boolean pred(String p) {
                return listener == null || listener.accept(p);
            }
        };
        add_files_ex(fs, absPath.getPath(), l1, flags);
        if (fs.total_size() == 0) {
            throw new IOException("content total size can't be 0");
        }
        create_torrent t = new create_torrent(fs, pieceSize, flags);
        final int numPieces = t.num_pieces();
        set_piece_hashes_listener l2 = new set_piece_hashes_listener() {
            @Override
            public void progress(int i) {
                if (listener != null) {
                    listener.progress(i, numPieces);
                }
            }
        };
        File parent = absPath.getParentFile();
        if (parent == null) {
            throw new IOException("path's parent can't be null");
        }
        error_code ec = new error_code();
        set_piece_hashes_ex(t, parent.getAbsolutePath(), l2, ec);
        if (ec.value() != 0) {
            throw new IOException(ec.message());
        }

        if (comment != null) {
            t.set_comment(comment);
        }
        if (creator != null) {
            t.set_creator(creator);
        }
        if (creationDate != null) {
            t.set_creation_date(creationDate);
        }
        for (String s : urlSeeds) {
            t.add_url_seed(s);
        }
        for (Pair<String, Integer> n : nodes) {
            t.add_node(n.to_string_int_pair());
        }
        for (Pair<String, Integer> tr : trackers) {
            t.add_tracker(tr.first, tr.second);
        }
        if (priv) {
            t.set_priv(priv);
        }

        if (!similarTorrents.isEmpty()) {
            for (Sha1Hash h : similarTorrents) {
                t.add_similar_torrent(h.swig());
            }
        }
        if (!collections.isEmpty()) {
            for (String s : collections) {
                t.add_collection(s);
            }
        }

        return new Result(t);
    }

    /**
     * This will include the file modification time as part of the torrent.
     * This is not enabled by default, as it might cause problems when you
     * create a torrent from separate files with the same content, hoping to
     * yield the same info-hash. If the files have different modification times,
     * with this option enabled, you would get different info-hashes for the
     * files.
     */
    public static final create_flags_t MODIFICATION_TIME = create_torrent.modification_time;

    /**
     * If this flag is set, files that are symlinks get a symlink attribute
     * set on them and their data will not be included in the torrent. This
     * is useful if you need to reconstruct a file hierarchy which contains
     * symlinks.
     */
    public static final create_flags_t SYMLINKS = create_torrent.symlinks;

    /**
     * Do not generate v1 metadata. The resulting torrent will only be usable by
     * clients which support v2. This requires setting all v2 hashes, with
     * set_hash2() before calling generate(). Setting v1 hashes (with
     * set_hash()) is an error with this flag set.
     */
    public static final create_flags_t V2_ONLY = create_torrent.v2_only;

    /**
     * Do not generate v2 metadata or enforce v2 alignment and padding rules
     * this is mainly for tests, not recommended for production use. This
     * requires setting all v1 hashes, with set_hash(), before calling
     * generate(). Setting v2 hashes (with set_hash2()) is an error with
     * this flag set.
     */
    public static final create_flags_t V1_ONLY = create_torrent.v1_only;

    /**
     * This flag only affects v1-only torrents, and is only relevant
     * together with the v1_only_flag. This flag will force the
     * same file order and padding as a v2 (or hybrid) torrent would have.
     * It has the effect of ordering files and inserting pad files to align
     * them with piece boundaries.
     */
    public static final create_flags_t CANONICAL_FILES = create_torrent.canonical_files;

    /**
     *
     */
    public interface Listener {

        /**
         * @param filename
         *
         */
        boolean accept(String filename);

        /**
         * @param pieceIndex
         * @param numPieces
         */
        void progress(int pieceIndex, int numPieces);
    }

    /**
     *
     */
    public static final class Result {

        private final create_torrent t;
        private final Entry entry;

        private Result(create_torrent t) {
            this.t = t;
            this.entry = new Entry(t.generate());
        }

        /**
         *
         */
        public Entry entry() {
            return entry;
        }

        /**
         *
         */
        public int numPieces() {
            return t.num_pieces();
        }

        /**
         *
         */
        public int pieceLength() {
            return t.piece_length();
        }

        /**
         * @param index
         *
         */
        public int pieceSize(int index) {
            return t.piece_size(index);
        }
    }
}
