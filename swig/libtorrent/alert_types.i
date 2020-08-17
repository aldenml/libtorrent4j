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
%ignore libtorrent::performance_alert::deprecated_bittyrant_with_no_uplimit;
%ignore libtorrent::dht_mutable_item_alert::key;
%ignore libtorrent::dht_mutable_item_alert::signature;
%ignore libtorrent::dht_put_alert::public_key;
%ignore libtorrent::dht_put_alert::signature;
%ignore libtorrent::performance_warning_str;

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

%extend dht_pkt_alert
{

    udp::endpoint get_node()
    {
        return $self->node;
    }

    std::vector<std::int8_t> get_pkt_buf()
    {
        auto buf = $self->pkt_buf();
        return {buf.begin(), buf.end()};
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

%extend dht_lookup {

    std::string get_type() {
        return std::string($self->type);
    }
}

%extend portmap_alert {

    int get_mapping() {
        return static_cast<int>($self->mapping);
    }
}

%extend portmap_error_alert {

    int get_mapping() {
        return static_cast<int>($self->mapping);
    }
}

%extend dht_mutable_item_alert {

    std::array<std::int8_t, 32> get_key()
    {
        std::array<char, 32> arr = $self->key;
        return *reinterpret_cast<std::array<std::int8_t, 32>*>(&arr);
    }

    std::array<std::int8_t, 64> get_signature()
    {
        std::array<char, 64> arr = $self->signature;
        return *reinterpret_cast<std::array<std::int8_t, 64>*>(&arr);
    }

    int64_t get_seq()
    {
        return int64_t($self->seq);
    }

    std::vector<std::int8_t> get_salt()
    {
        std::string s = $self->salt;
        return std::vector<std::int8_t>(s.begin(), s.end());
    }
}

%extend dht_put_alert {

    std::array<std::int8_t, 32> get_public_key()
    {
        std::array<char, 32> arr = $self->public_key;
        return *reinterpret_cast<std::array<std::int8_t, 32>*>(&arr);
    }

    std::array<std::int8_t, 64> get_signature()
    {
        std::array<char, 64> arr = $self->signature;
        return *reinterpret_cast<std::array<std::int8_t, 64>*>(&arr);
    }

    std::vector<std::int8_t> get_salt()
    {
        std::string s = $self->salt;
        return std::vector<std::int8_t>(s.begin(), s.end());
    }

    int64_t get_seq()
    {
        return int64_t($self->seq);
    }
}

%extend session_stats_alert {
    long long get_value(int index) {
        return $self->counters()[index];
    }
}

%extend read_piece_alert {

    int64_t buffer_ptr() {
        return reinterpret_cast<int64_t>($self->buffer.get());
    }
}

%extend peer_log_alert {
    std::string get_event_type() {
        return std::string($self->event_type);
    }
}

%extend listen_failed_alert
{
    int get_socket_type()
    {
        return static_cast<int>($self->socket_type);
    }
}

%extend listen_succeeded_alert
{
    int get_socket_type()
    {
        return static_cast<int>($self->socket_type);
    }
}

%extend dht_stats_alert
{
    udp::endpoint get_local_endpoint()
    {
        return $self->local_endpoint;
    }
}

}
