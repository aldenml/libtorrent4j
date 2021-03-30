%ignore libtorrent::torrent_handle::torrent_handle;
%ignore libtorrent::torrent_handle::add_extension;
%ignore libtorrent::torrent_handle::add_piece;
%ignore libtorrent::torrent_handle::http_seeds;
%ignore libtorrent::torrent_handle::url_seeds;
%ignore libtorrent::torrent_handle::get_storage_impl;
%ignore libtorrent::torrent_handle::file_status;
%ignore libtorrent::torrent_handle::use_interface;
%ignore libtorrent::torrent_handle::native_handle;
%ignore libtorrent::torrent_handle::torrent_file;
%ignore libtorrent::torrent_handle::torrent_file_with_hashes;
%ignore libtorrent::torrent_handle::get_full_peer_list;
%ignore libtorrent::torrent_handle::set_metadata;
%ignore libtorrent::torrent_handle::set_ssl_certificate_buffer;
%ignore libtorrent::torrent_handle::queue_position;
%ignore libtorrent::torrent_handle::queue_position_set;
%ignore libtorrent::torrent_handle::piece_priority;
%ignore libtorrent::torrent_handle::prioritize_pieces;
%ignore libtorrent::torrent_handle::get_piece_priorities;
%ignore libtorrent::torrent_handle::file_priority;
%ignore libtorrent::torrent_handle::prioritize_files;
%ignore libtorrent::torrent_handle::get_file_priorities;
%ignore libtorrent::hash_value;

%include "libtorrent/torrent_handle.hpp"

namespace libtorrent {

struct add_piece_flags_tag;
%template(add_piece_flags_t) flags::bitfield_flag<std::uint8_t, add_piece_flags_tag>;

struct deadline_flags_tag;
%template(deadline_flags_t) flags::bitfield_flag<std::uint8_t, deadline_flags_tag>;

struct file_progress_flags_tag;
%template(file_progress_flags_t) flags::bitfield_flag<std::uint8_t, file_progress_flags_tag>;

struct pause_flags_tag;
%template(pause_flags_t) flags::bitfield_flag<std::uint8_t, pause_flags_tag>;

struct resume_data_flags_tag;
%template(resume_data_flags_t) flags::bitfield_flag<std::uint8_t, resume_data_flags_tag>;

struct reannounce_flags_tag;
%template(reannounce_flags_t) flags::bitfield_flag<std::uint8_t, reannounce_flags_tag>;

struct status_flags_tag;
%template(status_flags_t) flags::bitfield_flag<std::uint32_t, status_flags_tag>;

%extend torrent_handle {

    void add_piece_bytes(int piece, std::vector<int8_t> const& data, add_piece_flags_t flags = {}) {
        $self->add_piece(piece_index_t(piece), (char const*)&data[0], flags);
    }

    libtorrent::torrent_info const* torrent_file_ptr() {
        return $self->torrent_file().get();
    }

    libtorrent::torrent_info const* torrent_file_with_hashes_ptr()
    {
        return $self->torrent_file_with_hashes().get();
    }

    std::vector<std::string> get_url_seeds() const {
        std::set<std::string> s = $self->url_seeds();
        return {s.begin(), s.end()};
    }

    void set_ssl_certificate_buffer_ex(std::vector<int8_t> const& certificate
        , std::vector<int8_t> const& private_key
        , std::vector<int8_t> const& dh_params)
    {
        std::string cert{certificate.begin(), certificate.end()};
        std::string pk{private_key.begin(), private_key.end()};
        std::string dh{dh_params.begin(), dh_params.end()};
        $self->set_ssl_certificate_buffer(cert, pk, dh);
    }

    int queue_position_ex() const
    {
        return static_cast<int>($self->queue_position());
    }

    void queue_position_set_ex(int p)
    {
        $self->queue_position_set(queue_position_t{p});
    }

    std::int8_t piece_priority_ex(piece_index_t index)
    {
        return std::int8_t(static_cast<std::uint8_t>($self->piece_priority(index)));
    }

    void piece_priority_ex(piece_index_t index, std::int8_t priority)
    {
        $self->piece_priority(index, libtorrent::download_priority_t{std::uint8_t(priority)});
    }

    void prioritize_pieces_ex(std::vector<std::int8_t> const& pieces)
    {
        std::vector<libtorrent::download_priority_t> v(pieces.size());
        for (std::size_t i = 0; i < v.size(); i++)
            v[i] = libtorrent::download_priority_t{std::uint8_t(pieces[i])};
        $self->prioritize_pieces(v);
    }

    void prioritize_pieces_ex(std::vector<std::pair<int, std::int8_t>> const& pieces)
    {
        std::vector<std::pair<piece_index_t, libtorrent::download_priority_t>> v(pieces.size());
        for (std::size_t i = 0; i < v.size(); i++)
            v[i] = std::pair<piece_index_t, libtorrent::download_priority_t>(piece_index_t{pieces[i].first}, libtorrent::download_priority_t{std::uint8_t(pieces[i].second)});
        $self->prioritize_pieces(v);
    }

    std::vector<std::int8_t> get_piece_priorities_ex() const
    {
        std::vector<libtorrent::download_priority_t> v = $self->get_piece_priorities();
        std::vector<std::int8_t> r(v.size());
        for (std::size_t i = 0; i < v.size(); i++)
            r[i] = std::int8_t(static_cast<std::uint8_t>(v[i]));
        return r;
    }

    std::int8_t file_priority_ex(file_index_t index)
    {
        return std::int8_t(static_cast<std::uint8_t>($self->file_priority(index)));
    }

    void file_priority_ex(file_index_t index, std::int8_t priority)
    {
        $self->file_priority(index, libtorrent::download_priority_t{std::uint8_t(priority)});
    }

    void prioritize_files_ex(std::vector<std::int8_t> const& files)
    {
        std::vector<libtorrent::download_priority_t> v(files.size());
        for (std::size_t i = 0; i < v.size(); i++)
            v[i] = libtorrent::download_priority_t{std::uint8_t(files[i])};
        $self->prioritize_files(v);
    }

    std::vector<std::int8_t> get_file_priorities_ex() const
    {
        std::vector<libtorrent::download_priority_t> v = $self->get_file_priorities();
        std::vector<std::int8_t> r(v.size());
        for (std::size_t i = 0; i < v.size(); i++)
            r[i] = std::int8_t(static_cast<std::uint8_t>(v[i]));
        return r;
    }
}

}
