%ignore libtorrent::stats_metric::name;
%ignore libtorrent::find_metric_idx;

%include "libtorrent/session_stats.hpp"

namespace libtorrent {

%extend stats_metric
{
    std::string get_name()
    {
        return std::string($self->name);
    }
}

}
