%ignore libtorrent::load_torrent_buffer(span<char const>, load_torrent_limits const&);
%ignore libtorrent::load_torrent_buffer(span<char const>);

%include "libtorrent/load_torrent.hpp"
