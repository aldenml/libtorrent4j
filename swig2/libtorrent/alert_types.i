%ignore libtorrent::read_piece_alert::read_piece_alert;
%ignore libtorrent::read_piece_alert::buffer;
%ignore libtorrent::peer_log_alert::event_type;
%ignore libtorrent::dht_pkt_alert::pkt_buf;
%ignore libtorrent::session_stats_alert::counters;
%ignore libtorrent::dht_lookup::type;
%ignore libtorrent::dht_sample_infohashes_alert::endpoint;
%ignore libtorrent::dht_sample_infohashes_alert::interval;
%ignore libtorrent::dht_announce_alert::ip;
%ignore libtorrent::external_ip_alert::external_address;
%ignore libtorrent::listen_failed_alert::address;
%ignore libtorrent::listen_succeeded_alert::address;
%ignore libtorrent::incoming_connection_alert::endpoint;
%ignore libtorrent::peer_alert::endpoint;
%ignore libtorrent::dht_direct_response_alert::endpoint;
%ignore libtorrent::dht_outgoing_get_peers_alert::endpoint;
%ignore libtorrent::dht_pkt_alert::node;
%ignore libtorrent::udp_error_alert::endpoint;
%ignore libtorrent::portmap_alert::mapping;
%ignore libtorrent::portmap_error_alert::mapping;
%ignore libtorrent::listen_failed_alert::socket_type;
%ignore libtorrent::listen_succeeded_alert::socket_type;
%ignore libtorrent::lsd_error_alert::local_address;
%ignore libtorrent::portmap_alert::local_address;
%ignore libtorrent::portmap_error_alert::local_address;
%ignore libtorrent::portmap_log_alert::local_address;
%ignore libtorrent::socks5_alert::ip;
%ignore libtorrent::tracker_alert::local_endpoint;
%ignore libtorrent::dht_stats_alert::local_endpoint;

%rename("$ignore", regextarget=1, %$isconstructor) ".*_alert$";

%include "libtorrent/alert_types.hpp"

namespace libtorrent {

struct picker_flags_tag;
%template(picker_flags_t) flags::bitfield_flag<std::uint32_t, picker_flags_tag>;

%extend dht_announce_alert {

    address get_ip() {
        return $self->ip;
    }
}

%extend external_ip_alert {

    address get_external_address() {
        return $self->external_address;
    }
}

%extend listen_failed_alert {

    address get_address() {
        return $self->address;
    }
}

%extend listen_succeeded_alert {

    address get_address() {
        return $self->address;
    }
}

%extend incoming_connection_alert {

    tcp::endpoint get_endpoint() {
        return $self->endpoint;
    }
}

%extend peer_alert {

    tcp::endpoint get_endpoint() {
        return $self->endpoint;
    }
}

%extend dht_direct_response_alert {

    udp::endpoint get_endpoint() {
        return $self->endpoint;
    }
}

%extend dht_outgoing_get_peers_alert {

    udp::endpoint get_endpoint() {
        return $self->endpoint;
    }
}

%extend dht_pkt_alert {

    udp::endpoint get_node() {
        return $self->node;
    }
}

%extend udp_error_alert {

    udp::endpoint get_endpoint() {
        return $self->endpoint;
    }
}

%extend dht_sample_infohashes_alert {

    udp::endpoint get_endpoint() {
        return $self->endpoint;
    }

    std::int64_t get_interval() {
        return libtorrent::total_milliseconds($self->interval);
    }
}

%extend tracker_alert {

    tcp::endpoint get_local_endpoint() {
        return $self->local_endpoint;
    }
}

}
