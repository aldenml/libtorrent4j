%ignore libtorrent::add_torrent_params::trackers;
%ignore libtorrent::add_torrent_params::tracker_tiers;
%ignore libtorrent::add_torrent_params::dht_nodes;
%ignore libtorrent::add_torrent_params::file_priorities;
%ignore libtorrent::add_torrent_params::piece_priorities;
%ignore libtorrent::add_torrent_params::merkle_trees;
%ignore libtorrent::add_torrent_params::verified_leaf_hashes;
%ignore libtorrent::add_torrent_params::unfinished_pieces;
%ignore libtorrent::add_torrent_params::renamed_files;
%ignore libtorrent::add_torrent_params::have_pieces;
%ignore libtorrent::add_torrent_params::verified_pieces;
%ignore libtorrent::add_torrent_params::extensions;
%ignore libtorrent::add_torrent_params::http_seeds;
%ignore libtorrent::add_torrent_params::url_seeds;
%ignore libtorrent::add_torrent_params::peers;
%ignore libtorrent::add_torrent_params::banned_peers;

%include "libtorrent/add_torrent_params.hpp"

namespace libtorrent {

%extend add_torrent_params
{
    std::vector<std::string> get_trackers()
    {
        return $self->trackers;
    }

    void set_trackers(std::vector<std::string>& v)
    {
        $self->trackers = v;
    }

    std::vector<int> get_tracker_tiers()
    {
        return $self->tracker_tiers;
    }

    void set_tracker_tiers(std::vector<int>& v)
    {
        $self->tracker_tiers = v;
    }

    std::vector<std::pair<std::string, int>> get_dht_nodes()
    {
        return $self->dht_nodes;
    }

    void set_dht_nodes(std::vector<std::pair<std::string, int>>& v)
    {
        $self->dht_nodes = v;
    }

    std::vector<std::int8_t> get_file_priorities()
    {
        auto* v = &$self->file_priorities;
        return *reinterpret_cast<std::vector<std::int8_t>*>(v);
    }

    void set_file_priorities(std::vector<std::int8_t>& v)
    {
        auto* t = reinterpret_cast<std::vector<libtorrent::download_priority_t>*>(&v);
        $self->file_priorities = *t;
    }

    std::vector<std::int8_t> get_piece_priorities()
    {
        auto* v = &$self->piece_priorities;
        return *reinterpret_cast<std::vector<std::int8_t>*>(v);
    }

    void set_piece_priorities(std::vector<std::int8_t>& v)
    {
        auto* t = reinterpret_cast<std::vector<libtorrent::download_priority_t>*>(&v);
        $self->piece_priorities = *t;
    }

    std::vector<std::vector<libtorrent::sha256_hash>> get_merkle_trees()
    {
        auto* v = &$self->merkle_trees;
        return *reinterpret_cast<std::vector<std::vector<libtorrent::sha256_hash>>*>(v);
    }

    void set_merkle_trees(std::vector<std::vector<libtorrent::sha256_hash>>& v)
    {
        auto* t = reinterpret_cast<libtorrent::aux::vector<std::vector<libtorrent::sha256_hash>, libtorrent::file_index_t>*>(&v);
        $self->merkle_trees = *t;
    }

    std::vector<std::vector<bool>> get_verified_leaf_hashes()
    {
        auto* v = &$self->verified_leaf_hashes;
        return *reinterpret_cast<std::vector<std::vector<bool>>*>(v);
    }

    void set_verified_leaf_hashes(std::vector<std::vector<bool>>& v)
    {
        auto* t = reinterpret_cast<libtorrent::aux::vector<std::vector<bool>, libtorrent::file_index_t>*>(&v);
        $self->verified_leaf_hashes = *t;
    }

    std::map<int, bitfield> get_unfinished_pieces()
    {
        auto* v = &$self->unfinished_pieces;
        return *reinterpret_cast<std::map<int, libtorrent::bitfield>*>(v);
    }

    void set_unfinished_pieces(std::map<int, bitfield>& v)
    {
        auto* t = reinterpret_cast<std::map<libtorrent::piece_index_t, libtorrent::bitfield>*>(&v);
        $self->unfinished_pieces = *t;
    }

    std::map<int, std::string> get_renamed_files()
    {
        auto* v = &$self->renamed_files;
        return *reinterpret_cast<std::map<int, std::string>*>(v);
    }

    void set_renamed_files(std::map<int, std::string>& v)
    {
        auto* t = reinterpret_cast<std::map<libtorrent::file_index_t, std::string>*>(&v);
        $self->renamed_files = *t;
    }

    bitfield get_have_pieces()
    {
        auto* v = &$self->have_pieces;
        return *reinterpret_cast<libtorrent::bitfield*>(v);
    }

    void set_have_pieces(bitfield& v)
    {
        auto* t = reinterpret_cast<libtorrent::typed_bitfield<libtorrent::piece_index_t>*>(&v);
        $self->have_pieces = *t;
    }

    bitfield get_verified_pieces()
    {
        auto* v = &$self->verified_pieces;
        return *reinterpret_cast<libtorrent::bitfield*>(v);
    }

    void set_verified_pieces(bitfield& v)
    {
        auto* t = reinterpret_cast<libtorrent::typed_bitfield<libtorrent::piece_index_t>*>(&v);
        $self->verified_pieces = *t;
    }

    std::vector<std::string> get_http_seeds()
    {
        return $self->http_seeds;
    }

    void set_http_seeds(std::vector<std::string>& v)
    {
        $self->http_seeds = v;
    }

    std::vector<std::string> get_url_seeds()
    {
        return $self->url_seeds;
    }

    void set_url_seeds(std::vector<std::string>& v)
    {
        $self->url_seeds = v;
    }

    std::vector<tcp::endpoint> get_peers()
    {
        return $self->peers;
    }

    void set_peers(std::vector<tcp::endpoint>& v)
    {
        $self->peers = v;
    }

    std::vector<tcp::endpoint> get_banned_peers()
    {
        return $self->banned_peers;
    }

    void set_banned_peers(std::vector<tcp::endpoint>& v)
    {
        $self->banned_peers = v;
    }

    static libtorrent::add_torrent_params read_resume_data(libtorrent::bdecode_node const& rd, error_code& ec) {
        return libtorrent::read_resume_data(rd, ec);
    }

    static libtorrent::add_torrent_params read_resume_data(std::vector<int8_t> const& buffer, error_code& ec) {
        return libtorrent::read_resume_data({(char const*)&buffer[0], static_cast<long>(buffer.size())}, ec);
    }

    static libtorrent::entry write_resume_data(add_torrent_params const& atp) {
        return libtorrent::write_resume_data(atp);
    }

    static std::vector<int8_t> write_resume_data_buf(add_torrent_params const& atp) {
        auto v = libtorrent::write_resume_data_buf(atp);
        return {v.begin(), v.end()};
    }

    static add_torrent_params parse_magnet_uri(std::string const& uri, error_code& ec) {
        return libtorrent::parse_magnet_uri(uri, ec);
    }
}

}
