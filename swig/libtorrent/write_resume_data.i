%ignore libtorrent::write_resume_data_buf(add_torrent_params const& atp);
%ignore libtorrent::write_torrent_file_buf(add_torrent_params const& atp, write_torrent_flags_t flags);

namespace libtorrent {

struct write_torrent_flags_tag;
%template(write_torrent_flags_t) flags::bitfield_flag<std::uint32_t, write_torrent_flags_tag>;

}

%include "libtorrent/write_resume_data.hpp"
