%ignore libtorrent::from_span;
%ignore libtorrent::from_span_t;
%ignore libtorrent::load_torrent_limits;
%ignore libtorrent::torrent_info::torrent_info(char const*, int, error_code&);
%ignore libtorrent::torrent_info::torrent_info(char const*, int, error_code&, int);
%ignore libtorrent::torrent_info::torrent_info(span<char const>, error_code&, from_span_t);
%ignore libtorrent::torrent_info::metadata;
%ignore libtorrent::torrent_info::load;
%ignore libtorrent::torrent_info::unload;
%ignore libtorrent::torrent_info::hash_for_piece_ptr;
%ignore libtorrent::torrent_info::parse_info_section;
%ignore libtorrent::torrent_info::swap;
%ignore libtorrent::torrent_info::add_merkle_nodes;
%ignore libtorrent::torrent_info::build_merkle_list;
%ignore libtorrent::torrent_info::parse_torrent_file;
%ignore libtorrent::torrent_info::piece_range;
%ignore libtorrent::torrent_info::internal_set_creator;
%ignore libtorrent::torrent_info::internal_set_creation_date;
%ignore libtorrent::torrent_info::internal_set_comment;
%ignore libtorrent::torrent_info::ssl_cert;
%ignore libtorrent::torrent_info::merkle_trees;
%ignore libtorrent::torrent_info::file_merkle_tree;
%ignore libtorrent::aux::sanitize_append_path_element;
%ignore libtorrent::aux::verify_encoding;

%include "libtorrent/torrent_info.hpp"

namespace libtorrent {

%extend torrent_info
{
    std::vector<std::vector<sha256_hash>>& get_merkle_trees()
    {
        auto* v = &$self->merkle_trees();
        return *reinterpret_cast<std::vector<std::vector<libtorrent::sha256_hash>>*>(v);
    }

    std::vector<sha256_hash>& get_file_merkle_tree(int file)
    {
        auto* v = &$self->file_merkle_tree(libtorrent::file_index_t{file});
        return *reinterpret_cast<std::vector<libtorrent::sha256_hash>*>(v);
    }
};

}

%shared_ptr(libtorrent::torrent_info)
