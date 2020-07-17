%ignore libtorrent::session_handle::session_handle(aux::session_impl*);
%ignore libtorrent::session_handle::session_handle(session_handle&&);
%ignore libtorrent::session_handle::get_torrent_status;
%ignore libtorrent::session_handle::get_io_service;
%ignore libtorrent::session_handle::get_connection_queue;
%ignore libtorrent::session_handle::add_extension;
%ignore libtorrent::session_handle::dht_put_item(std::array<char, 32>, std::function<void(entry&, std::array<char,64>&, std::int64_t&, std::string const&)>, std::string);
%ignore libtorrent::session_handle::dht_put_item(std::array<char, 32>, std::function<void(entry&, std::array<char,64>&, std::int64_t&, std::string const&)>);
%ignore libtorrent::session_handle::dht_get_item(std::array<char, 32>, std::string);
%ignore libtorrent::session_handle::dht_get_item(std::array<char, 32>);
%ignore libtorrent::session_handle::dht_direct_request(udp::endpoint const&, entry const&, void*);
%ignore libtorrent::session_handle::set_load_function;
%ignore libtorrent::session_handle::set_alert_notify;
%ignore libtorrent::session_handle::native_handle;
%ignore libtorrent::session_handle::set_dht_storage;
%ignore libtorrent::session_handle::get_cache_info;
%ignore libtorrent::session_handle::wait_for_alert;
%ignore libtorrent::session_handle::add_torrent(add_torrent_params&&, error_code&);
%ignore libtorrent::session_handle::async_add_torrent(add_torrent_params&&);
%ignore libtorrent::session_handle::apply_settings(settings_pack&&);
%ignore libtorrent::session_handle::get_context;
%ignore libtorrent::session_handle::add_port_mapping;
%ignore libtorrent::session_handle::delete_port_mapping;
%ignore libtorrent::session_handle::dht_announce;
%ignore libtorrent::session_handle::delete_peer_class;
%ignore libtorrent::session_handle::get_peer_class;
%ignore libtorrent::session_handle::set_peer_class;
%ignore libtorrent::session_handle::global_peer_class_id;
%ignore libtorrent::session_handle::tcp_peer_class_id;
%ignore libtorrent::session_handle::local_peer_class_id;
%ignore libtorrent::session_handle::create_peer_class;

%include "libtorrent/session_handle.hpp"

namespace libtorrent {

%extend session_handle {

    void dht_get_item(std::array<std::int8_t, 32>& key, std::vector<std::int8_t>& salt)
    {
        std::array<char, 32> pk;
        std::copy_n(key.begin(), 32, pk.begin());

        $self->dht_get_item(pk, std::string(salt.begin(), salt.end()));
    }

    void dht_put_item(std::array<std::int8_t, 32>& key, std::array<std::int8_t, 64>& sk, entry& data, std::vector<int8_t>& salt)
    {
        std::array<char, 32> pk;
        std::copy_n(key.begin(), 32, pk.begin());

        using namespace std::placeholders;
        using namespace libtorrent::dht;

        $self->dht_put_item(pk, std::bind(&dht_put_item_cb, _1, _2, _3, _4,
            public_key((char*)key.data()), secret_key((char*)sk.data()), data),
            std::string(salt.begin(), salt.end()));
    }

    void dht_direct_request(udp::endpoint const& ep, entry const& e, std::int64_t userdata)
    {
        $self->dht_direct_request(ep, e, lt::client_data_t{(void*)userdata});
    }

    alert* wait_for_alert_ms(std::int64_t max_wait)
    {
        return $self->wait_for_alert(libtorrent::milliseconds(max_wait));
    }

    void set_alert_notify_callback(alert_notify_callback* cb) {
        $self->set_alert_notify(std::bind(&alert_notify_callback::on_alert, cb));
    }

    void dht_announce_ex(sha1_hash const& info_hash, int port = 0, std::int8_t flags = {})
    {
        $self->dht_announce(info_hash, port, libtorrent::dht::announce_flags_t{static_cast<std::uint8_t>(flags)});
    }

    std::vector<int> add_port_mapping_ex(libtorrent::portmap_protocol t
        , int external_port, int local_port)
    {
        auto mapping = $self->add_port_mapping(t, external_port, local_port);
        std::vector<int> r;
        for (auto m : mapping)
            r.push_back(static_cast<int>(m));
        return r;
    }

    void delete_port_mapping_ex(int handle)
    {
        $self->delete_port_mapping(libtorrent::port_mapping_t{handle});
    }
}

}
