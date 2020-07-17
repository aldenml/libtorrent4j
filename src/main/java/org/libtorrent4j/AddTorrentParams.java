package org.libtorrent4j;

import org.libtorrent4j.swig.add_torrent_params;
import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.error_code;
import org.libtorrent4j.swig.int_vector;
import org.libtorrent4j.swig.storage_mode_t;
import org.libtorrent4j.swig.string_int_pair;
import org.libtorrent4j.swig.string_int_pair_vector;
import org.libtorrent4j.swig.string_vector;
import org.libtorrent4j.swig.tcp_endpoint_vector;
import org.libtorrent4j.swig.torrent_flags_t;
import org.libtorrent4j.swig.torrent_info;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link AddTorrentParams} is a parameter pack for adding torrents to a
 * session. The key fields when adding a torrent are:
 * <ul>
 * <li>ti - when you have a .torrent file</li>
 * <li>url - when you have a magnet link or http URL to the .torrent file</li>
 * <li>info_hash - when all you have is an info-hash (this is similar to a magnet link)</li>
 * </ul>
 * One of those fields need to be set. Another mandatory field is
 * {@link #savePath()}. The {@link AddTorrentParams} object is passed into one of the
 * {@link SessionHandle#addTorrent(AddTorrentParams, ErrorCode)} overloads or
 * {@link SessionHandle#asyncAddTorrent(AddTorrentParams)}.
 * <p>
 * If you only specify the info-hash, the torrent file will be downloaded
 * from peers, which requires them to support the metadata extension. It also
 * takes an optional {@link #name()} argument. This may be left empty in case no
 * name should be assigned to the torrent. In case it's not, the name is
 * used for the torrent as long as it doesn't have metadata.
 *
 * @author aldenml
 */
public final class AddTorrentParams
        extends SwigObject<add_torrent_params> {

    /**
     * The native object
     *
     * @param params the native object
     */
    public AddTorrentParams(add_torrent_params params) {
        super(params);
    }

    /**
     * Creates an empty parameters object with the default storage.
     */
    public AddTorrentParams() {
        this(new add_torrent_params());
    }

    /**
     * Filled in by the constructor. It is used for forward binary compatibility.
     *
     * @return the version
     */
    public int version() {
        return h.getVersion();
    }

    /**
     * {@link TorrentInfo} object with the torrent to add.
     *
     * @return the torrent info or null if not set
     */
    public TorrentInfo torrentInfo() {
        torrent_info ti = h.ti_ptr();
        return ti != null && ti.is_valid() ? new TorrentInfo(ti) : null;
    }

    /**
     * {@link TorrentInfo} object with the torrent to add.
     *
     * @param ti the torrent info
     */
    public void torrentInfo(TorrentInfo ti) {
        h.set_ti(ti.swig());
    }

    /**
     * If the torrent doesn't have a tracker, but relies on the DHT to find
     * peers, the {@link #trackers(List)} can specify tracker URLs for the
     * torrent.
     *
     * @return the list of trackers
     */
    public List<String> trackers() {
        return new ArrayList<>(h.getTrackers());
    }

    /**
     * If the torrent doesn't have a tracker, but relies on the DHT to find
     * peers, this method can specify tracker URLs for the torrent.
     *
     * @param value the list of trackers
     */
    public void trackers(List<String> value) {
        string_vector v = new string_vector(value);
        h.setTrackers(v);
    }

    /**
     * The tiers the URLs in {@link #trackers()} belong to. Trackers belonging to
     * different tiers may be treated differently, as defined by the multi
     * tracker extension. This is optional, if not specified trackers are
     * assumed to be part of tier 0, or whichever the last tier was as
     * iterating over the trackers.
     *
     * @return the list of trackers tiers
     */
    public List<Integer> trackerTiers() {
        return new ArrayList<>(h.getTracker_tiers());
    }

    /**
     * The tiers the URLs in {@link #trackers()} belong to. Trackers belonging to
     * different tiers may be treated differently, as defined by the multi
     * tracker extension. This is optional, if not specified trackers are
     * assumed to be part of tier 0, or whichever the last tier was as
     * iterating over the trackers.
     *
     * @param value the list of trackers tiers
     */
    public void trackerTiers(List<Integer> value) {
        int_vector v = new int_vector(value);
        h.setTracker_tiers(v);
    }

    /**
     * A list of hostname and port pairs, representing DHT nodes to be added
     * to the session (if DHT is enabled). The hostname may be an IP address.
     *
     * @return the list of DHT nodes
     */
    public ArrayList<Pair<String, Integer>> dhtNodes() {
        string_int_pair_vector v = h.getDht_nodes();
        int size = v.size();
        ArrayList<Pair<String, Integer>> l = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            string_int_pair n = v.get(i);
            l.add(new Pair<>(n.getFirst(), n.getSecond()));
        }

        return l;
    }

    /**
     * A list of hostname and port pairs, representing DHT nodes to be added
     * to the session (if DHT is enabled). The hostname may be an IP address.
     *
     * @param value the list of DHT nodes
     */
    public void dhtNodes(List<Pair<String, Integer>> value) {
        string_int_pair_vector v = new string_int_pair_vector();

        for (Pair<String, Integer> p : value) {
            v.add(p.to_string_int_pair());
        }

        h.setDht_nodes(v);
    }

    /**
     * @return the name
     */
    public String name() {
        return h.getName();
    }

    /**
     * @param value the name
     */
    public void name(String value) {
        h.setName(value);
    }

    /**
     * The path where the torrent is or will be stored. Note that this may
     * also be stored in resume data. If you want the save path saved in
     * the resume data to be used, you need to set the
     * flag_use_resume_save_path flag.
     * <p>
     * .. note::
     * On windows this path (and other paths) are interpreted as UNC
     * paths. This means they must use backslashes as directory separators
     *
     * @return the save path
     */
    public String savePath() {
        return h.getSave_path();
    }

    /**
     * The path where the torrent is or will be stored. Note that this may
     * also be stored in resume data. If you want the save path saved in
     * the resume data to be used, you need to set the
     * flag_use_resume_save_path flag.
     * <p>
     * .. note::
     * On windows this path (and other paths) are interpreted as UNC
     * paths. This means they must use backslashes as directory separators
     *
     * @param value the save path
     */
    public void savePath(String value) {
        h.setSave_path(value);
    }

    /**
     * @return the storage mode
     * @see StorageMode
     */
    public StorageMode storageMode() {
        return StorageMode.fromSwig(h.getStorage_mode().swigValue());
    }

    /**
     * @param value the storage mode
     * @see StorageMode
     */
    public void storageMode(StorageMode value) {
        h.setStorage_mode(storage_mode_t.swigToEnum(value.swig()));
    }

    /**
     * The default tracker id to be used when announcing to trackers. By
     * default this is empty, and no tracker ID is used, since this is an
     * optional argument. If a tracker returns a tracker ID, that ID is used
     * instead of this.
     *
     * @return the trackerid url parameter
     */
    public String trackerId() {
        return h.getTrackerid();
    }

    /**
     * The default tracker id to be used when announcing to trackers. By
     * default this is empty, and no tracker ID is used, since this is an
     * optional argument. If a tracker returns a tracker ID, that ID is used
     * instead of this.
     *
     * @param value the trackerid url parameter
     */
    public void trackerId(String value) {
        h.setTrackerid(value);
    }

    /**
     * Set this to the info hash of the torrent to add in case the info-hash
     * is the only known property of the torrent. i.e. you don't have a
     * .torrent file nor a magnet link.
     *
     * @return the info-hash
     */
    public InfoHash infoHash() {
        return new InfoHash(h.getInfo_hash());
    }

    /**
     * Set this to the info hash of the torrent to add in case the info-hash
     * is the only known property of the torrent. i.e. you don't have a
     * .torrent file nor a magnet link.
     *
     * @param value the info-hash
     */
    public void infoHash(InfoHash value) {
        h.setInfo_hash(value.swig());
    }

    /**
     * @return max uploads limit
     */
    public int maxUploads() {
        return h.getMax_uploads();
    }

    /**
     * @param value max uploads limit
     */
    public void maxUploads(int value) {
        h.setMax_uploads(value);
    }

    /**
     * @return max connections limit
     */
    public int maxConnections() {
        return h.getMax_connections();
    }

    /**
     * @param value max connections limit
     */
    public void maxConnections(int value) {
        h.setMax_connections(value);
    }

    /**
     * @return upload limit
     */
    public int uploadLimit() {
        return h.getUpload_limit();
    }

    /**
     * @param value upload limit
     */
    public void uploadLimit(int value) {
        h.setUpload_limit(value);
    }

    /**
     * @return download limit
     */
    public int downloadLimit() {
        return h.getDownload_limit();
    }

    /**
     * @param value download limit
     */
    public void downloadLimit(int value) {
        h.setDownload_limit(value);
    }

    /**
     * Flags controlling aspects of this torrent and how it's added.
     *
     * @return the flags
     */
    public torrent_flags_t flags() {
        return h.getFlags();
    }

    /**
     * Flags controlling aspects of this torrent and how it's added.
     *
     * @param flags the flags
     */
    public void flags(torrent_flags_t flags) {
        h.setFlags(flags);
    }

    /**
     * Url seeds to be added to the torrent (`BEP 17`_).
     *
     * @return the url seeds
     */
    public ArrayList<String> urlSeeds() {
        string_vector v = h.getUrl_seeds();
        int size = v.size();
        ArrayList<String> l = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            l.add(v.get(i));
        }

        return l;
    }

    /**
     * Url seeds to be added to the torrent (`BEP 17`_).
     *
     * @param value the url seeds
     */
    public void urlSeeds(List<String> value) {
        string_vector v = new string_vector();

        for (String s : value) {
            v.add(s);
        }

        h.setUrl_seeds(v);
    }

    public Priority[] filePriorities() {
        byte_vector v = h.get_file_priorities();
        return Priority.vector2array(v);
    }

    /**
     * Can be set to control the initial file priorities when adding a
     * torrent. The semantics are the same as for
     * {@link TorrentHandle#prioritizeFiles(Priority[])}.
     *
     * @param priorities the priorities
     */
    public void filePriorities(Priority[] priorities) {
        h.set_file_priorities(Priority.array2byte_vector(priorities));
    }

    public Priority[] piecePriorities() {
        byte_vector v = h.get_piece_priorities();
        return Priority.vector2array(v);
    }

    /**
     * This sets the priorities for each individual piece in the torrent. Each
     * element in the vector represent the piece with the same index. If you
     * set both file- and piece priorities, file priorities will take
     * precedence.
     *
     * @param priorities the priorities
     */
    public void piecePriorities(Priority[] priorities) {
        h.set_piece_priorities(Priority.array2byte_vector(priorities));
    }

    /**
     * Peers to add to the torrent, to be tried to be connected to as
     * bittorrent peers.
     *
     * @return the peers list
     */
    public ArrayList<TcpEndpoint> peers() {
        tcp_endpoint_vector v = h.getPeers();
        int size = v.size();
        ArrayList<TcpEndpoint> l = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            l.add(new TcpEndpoint(v.get(i)));
        }

        return l;
    }

    /**
     * Peers to add to the torrent, to be tried to be connected to as
     * bittorrent peers.
     *
     * @param value the peers list
     */
    public void peers(List<TcpEndpoint> value) {
        tcp_endpoint_vector v = new tcp_endpoint_vector();

        for (TcpEndpoint endp : value) {
            v.add(endp.swig());
        }

        h.setPeers(v);
    }

    /**
     * Peers banned from this torrent. The will not be connected to.
     *
     * @return the peers list
     */
    public ArrayList<TcpEndpoint> bannedPeers() {
        tcp_endpoint_vector v = h.getBanned_peers();
        int size = v.size();
        ArrayList<TcpEndpoint> l = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            l.add(new TcpEndpoint(v.get(i)));
        }

        return l;
    }

    /**
     * Peers banned from this torrent. The will not be connected to.
     *
     * @param value the peers list
     */
    public void bannedPeers(List<TcpEndpoint> value) {
        tcp_endpoint_vector v = new tcp_endpoint_vector();

        for (TcpEndpoint endp : value) {
            v.add(endp.swig());
        }

        h.setBanned_peers(v);
    }

    /**
     * Helper function to parse a magnet uri and fill the parameters.
     *
     * @param uri the magnet uri
     * @return the params object filled with the data from the magnet
     */
    public static AddTorrentParams parseMagnetUri(String uri) {
        error_code ec = new error_code();
        add_torrent_params params = add_torrent_params.parse_magnet_uri(uri, ec);
        if (ec.value() != 0) {
            throw new IllegalArgumentException("Invalid magnet uri: " + ec.message());
        }
        return new AddTorrentParams(params);
    }
}
