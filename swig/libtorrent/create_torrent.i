%ignore libtorrent::set_piece_hashes;
%ignore libtorrent::create_torrent::add_url_seed(string_view);
%ignore libtorrent::create_torrent::add_tracker(string_view);
%ignore libtorrent::create_torrent::add_tracker(string_view, int);
%ignore libtorrent::create_torrent::add_collection(string_view);
%ignore libtorrent::create_torrent::set_root_cert(string_view);
%ignore libtorrent::create_torrent::set_hash2(file_index_t, piece_index_t::diff_type, sha256_hash const&);
%ignore libtorrent::create_torrent::piece_range;
%ignore libtorrent::create_torrent::file_range;
%ignore libtorrent::create_torrent::file_piece_range;
%ignore libtorrent::create_torrent::file_list;
%ignore libtorrent::create_torrent::generate_buf;
%ignore libtorrent::list_files;

%include "libtorrent/create_torrent.hpp"

namespace libtorrent {

struct create_flags_tag;
%template(create_flags_t) flags::bitfield_flag<std::uint32_t, create_flags_tag>;

%extend create_torrent
{

    void add_url_seed(std::string const& url)
    {
        $self->add_url_seed(url);
    }

    void add_tracker(std::string const& url)
    {
        $self->add_tracker(url);
    }

    void add_tracker(std::string const& url, int tier)
    {
        $self->add_tracker(url, tier);
    }

    void add_collection(std::string const& c)
    {
        $self->add_collection(c);
    }

    void set_root_cert(std::vector<std::int8_t> const& cert)
    {
        std::string v{cert.begin(), cert.end()};
        $self->set_root_cert(v);
    }

    void set_hash2(file_index_t file, int piece, sha256_hash const& h)
    {
        $self->set_hash2(file, lt::piece_index_t::diff_type{piece}, h);
    }
}

}
