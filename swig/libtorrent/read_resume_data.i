%ignore libtorrent::read_resume_data(span<char const>, error_code&, load_torrent_limits const&);
%ignore libtorrent::read_resume_data(span<char const>, error_code&);
%ignore libtorrent::read_resume_data(bdecode_node const&, int);
%ignore libtorrent::read_resume_data(bdecode_node const&);
%ignore libtorrent::read_resume_data(span<char const>, load_torrent_limits const&);
%ignore libtorrent::read_resume_data(span<char const>);

%include "libtorrent/read_resume_data.hpp"
