%ignore libtorrent::announce_infohash::next_announce;
%ignore libtorrent::announce_infohash::min_announce;
%ignore libtorrent::announce_entry::announce_entry(string_view);
%ignore libtorrent::announce_endpoint::info_hashes;

%include "libtorrent/announce_entry.hpp"
