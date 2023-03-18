%ignore libtorrent::torrent_flags::deprecated_override_trackers;
%ignore libtorrent::torrent_flags::deprecated_override_web_seeds;

%include "libtorrent/torrent_flags.hpp"

namespace libtorrent {

struct torrent_flags_tag;
%template(torrent_flags_t) flags::bitfield_flag<std::uint64_t, torrent_flags_tag>;

}
