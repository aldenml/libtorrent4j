namespace libtorrent {
namespace dht {

using node_ids_t = std::vector<std::pair<address, node_id>>;

struct TORRENT_EXPORT dht_state
{
    node_ids_t nids;

    std::vector<udp::endpoint> nodes;
    std::vector<udp::endpoint> nodes6;

    void clear();
};

}
}
