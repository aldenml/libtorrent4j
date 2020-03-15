%ignore libtorrent::read_piece_alert::read_piece_alert;
%ignore libtorrent::read_piece_alert::buffer;
%ignore libtorrent::peer_log_alert::event_type;
%ignore libtorrent::dht_lookup::type;

%rename("$ignore", regextarget=1, %$isconstructor) ".*_alert$";

%include "libtorrent/alert_types.hpp"

namespace libtorrent {

struct picker_flags_tag;
%template(picker_flags_t) flags::bitfield_flag<std::uint32_t, picker_flags_tag>;

}
