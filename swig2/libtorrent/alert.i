%ignore libtorrent::alert::timestamp;

%include "libtorrent/alert.hpp"

namespace libtorrent {

struct alert_category_tag;
%template(alert_category_t) flags::bitfield_flag<std::uint32_t, alert_category_tag>;

%extend alert {

    std::int64_t get_timestamp() {
        return libtorrent::total_milliseconds($self->timestamp().time_since_epoch());
    }
}

}
