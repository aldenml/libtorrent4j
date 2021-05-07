%ignore libtorrent::add_files(file_storage&, std::string const&, std::function<bool(std::string)>, create_flags_t);
%ignore libtorrent::add_files(file_storage&, std::string const&, std::function<bool(std::string)>);
%ignore libtorrent::file_storage::file_storage(file_storage&&);
%ignore libtorrent::file_storage::file_path_hash;
%ignore libtorrent::file_storage::all_path_hashes;
%ignore libtorrent::file_storage::file_name_ptr;
%ignore libtorrent::file_storage::file_name_len;
%ignore libtorrent::file_storage::apply_pointer_offset;
%ignore libtorrent::file_storage::file_range;
%ignore libtorrent::file_storage::piece_range;
%ignore libtorrent::file_storage::add_file_borrow;
%ignore libtorrent::file_storage::add_file;
%ignore libtorrent::file_storage::file_name;
%ignore libtorrent::file_storage::paths;
%ignore libtorrent::file_storage::file_piece_range;
%ignore libtorrent::file_storage::internal_symlink;
%ignore libtorrent::file_storage::remove_tail_padding;

namespace libtorrent {

struct peer_request;

}

%include "libtorrent/file_storage.hpp"

namespace libtorrent {

struct file_flags_tag;
%template(file_flags_t) flags::bitfield_flag<std::uint8_t, file_flags_tag>;

%extend file_storage
{
    void add_file_ex(error_code& ec, std::string const& path, std::int64_t file_size
        , libtorrent::file_flags_t file_flags = {}
        , std::time_t mtime = 0, std::string symlink_path = {})
        //, char const* root_hash = nullptr)
    {
        $self->add_file(ec, path, file_size, file_flags, mtime, symlink_path);
    }

    std::string file_name_ex(int index)
    {
        return std::string{$self->file_name(lt::file_index_t{index})};
    }
}

}
