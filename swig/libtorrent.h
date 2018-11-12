#ifndef _WIN32
#include <dlfcn.h>
#endif

#include <stdexcept>
#include <string>
#include <vector>
#include <array>
#include <map>
#include <algorithm>

#include <boost/version.hpp>

#include <boost/asio/ip/address.hpp>
#include <boost/asio/ip/address_v4.hpp>
#include <boost/asio/ip/address_v6.hpp>
#include <boost/asio/ip/tcp.hpp>
#include <boost/asio/ip/udp.hpp>

#include <openssl/opensslv.h>

#include <libtorrent/config.hpp>
#include <libtorrent/time.hpp>
#include <libtorrent/buffer.hpp>
#include <libtorrent/utp_stream.hpp>
#include <libtorrent/socket_io.hpp>
#include <libtorrent/read_resume_data.hpp>
#include <libtorrent/write_resume_data.hpp>
#include <libtorrent/hex.hpp>
#include <libtorrent/extensions.hpp>
#include <libtorrent/bloom_filter.hpp>
#include <libtorrent/announce_entry.hpp>
#include <libtorrent/enum_net.hpp>

#include <libtorrent/kademlia/dht_tracker.hpp>
#include <libtorrent/kademlia/node_entry.hpp>
#include <libtorrent/kademlia/node.hpp>
#include <libtorrent/kademlia/node_id.hpp>
#include <libtorrent/kademlia/get_peers.hpp>
#include <libtorrent/kademlia/item.hpp>
#include <libtorrent/kademlia/ed25519.hpp>

#include <libtorrent/aux_/cpuid.hpp>

std::vector<int8_t> ed25519_create_seed() {
    std::array<char, 32> seed = libtorrent::dht::ed25519_create_seed();
    return std::vector<int8_t>(seed.data(), seed.end());
}

std::pair<std::vector<int8_t>, std::vector<int8_t>> ed25519_create_keypair(
    std::vector<int8_t>& seed) {
    using namespace libtorrent::dht;

    public_key pk;
    secret_key sk;

    std::array<char, 32> s;
    std::copy_n(seed.begin(), 32, s.begin());

    std::tie(pk, sk) = ed25519_create_keypair(s);

    return std::make_pair(std::vector<int8_t>(pk.bytes.begin(), pk.bytes.end()),
        std::vector<int8_t>(sk.bytes.begin(), sk.bytes.end()));
}

std::vector<int8_t> ed25519_sign(std::vector<int8_t>& msg,
    std::vector<int8_t>& pk, std::vector<int8_t>& sk) {
    using namespace libtorrent::dht;

    public_key pk1((char*)pk.data());
    secret_key sk1((char*)sk.data());

    signature sig = ed25519_sign({reinterpret_cast<char const*>(msg.data()), msg.size()},
        pk1, sk1);
    return std::vector<int8_t>(sig.bytes.begin(), sig.bytes.end());
}

bool ed25519_verify(std::vector<int8_t>& sig,
    std::vector<int8_t>& msg,
    std::vector<int8_t>& pk) {
    using namespace libtorrent::dht;

    signature sig1((char*)sig.data());
    public_key pk1((char*)pk.data());

    return ed25519_verify(sig1, {reinterpret_cast<char const*>(msg.data()), msg.size()}, pk1);
}

std::vector<int8_t> ed25519_add_scalar_public(std::vector<int8_t>& pk,
    std::vector<int8_t>& scalar) {
    using namespace libtorrent::dht;

    public_key pk1((char*)pk.data());

    std::array<char, 32> s;
    std::copy_n(scalar.begin(), 32, s.begin());

    public_key ret = ed25519_add_scalar(pk1, s);
    return std::vector<int8_t>(ret.bytes.begin(), ret.bytes.end());
}

std::vector<int8_t> ed25519_add_scalar_secret(std::vector<int8_t>& sk,
    std::vector<int8_t>& scalar) {
    using namespace libtorrent::dht;

    secret_key sk1((char*)sk.data());

    std::array<char, 32> s;
    std::copy_n(scalar.begin(), 32, s.begin());

    secret_key ret = ed25519_add_scalar(sk1, s);
    return std::vector<int8_t>(ret.bytes.begin(), ret.bytes.end());
}

std::vector<int8_t> ed25519_key_exchange(std::vector<int8_t>& pk,
    std::vector<int8_t>& sk) {
    using namespace libtorrent::dht;

    public_key pk1((char*)pk.data());
    secret_key sk1((char*)sk.data());

    std::array<char, 32> secret = ed25519_key_exchange(pk1, sk1);
    return std::vector<int8_t>(secret.begin(), secret.end());
}

struct alert_notify_callback {

    virtual ~alert_notify_callback() {
    }

    virtual void on_alert() {
    }
};

struct add_files_listener {

    virtual ~add_files_listener() {
    }

    virtual bool pred(std::string const& p) {
        return true;
    }
};

void add_files_ex(libtorrent::file_storage& fs, std::string const& file,
                add_files_listener* listener, libtorrent::create_flags_t flags) {
    add_files(fs, file, std::bind(&add_files_listener::pred, listener, std::placeholders::_1), flags);
}

struct set_piece_hashes_listener {

    virtual ~set_piece_hashes_listener() {
    }

    virtual void progress(int i) {
    }

    void progress_index(libtorrent::piece_index_t i) {
        progress(static_cast<int>(i));
    }
};

void set_piece_hashes_ex(libtorrent::create_torrent& t, std::string const& p,
                        set_piece_hashes_listener* listener, libtorrent::error_code& ec) {
    set_piece_hashes(t, p, std::bind(&set_piece_hashes_listener::progress_index, listener, std::placeholders::_1), ec);
}

int boost_version() {
    return BOOST_VERSION;
}

const char* boost_lib_version() {
    return BOOST_LIB_VERSION;
}

int openssl_version_number() {
    return OPENSSL_VERSION_NUMBER;
}

const char* openssl_version_text() {
    return OPENSSL_VERSION_TEXT;
}

int find_metric_idx_s(std::string const& name) {
    return libtorrent::find_metric_idx(name);
}

void dht_put_item_cb(libtorrent::entry& e, std::array<char, 64>& sig, std::int64_t& seq,
    std::string salt, libtorrent::dht::public_key pk, libtorrent::dht::secret_key sk,
    libtorrent::entry data) {
    using namespace libtorrent::dht;

	e = data;
	std::vector<char> buf;
	bencode(std::back_inserter(buf), e);
	signature sign;
	++seq;
	sign = sign_mutable_item(buf, salt, sequence_number(seq), pk, sk);
    sig = sign.bytes;
}

struct swig_plugin : libtorrent::plugin {

    virtual ~swig_plugin() {
    }

    libtorrent::feature_flags_t implemented_features() {
        return libtorrent::plugin::dht_request_feature;
    }

    virtual bool on_dht_request(libtorrent::string_view query,
        libtorrent::udp::endpoint const& source,
        libtorrent::bdecode_node const& message, libtorrent::entry& response) {
        return false;
    }
};

// enum_net functions, very useful for networking
struct ip_interface
{
    libtorrent::address interface_address;
    libtorrent::address netmask;
    std::vector<std::int8_t> name;
    std::vector<std::int8_t> friendly_name;
    std::vector<std::int8_t> description;
    bool preferred;
};

struct ip_route
{
    libtorrent::address destination;
    libtorrent::address netmask;
    libtorrent::address gateway;
    std::vector<std::int8_t> name;
    int mtu;
};

std::vector<ip_interface> enum_net_interfaces(libtorrent::session* s)
{
    std::vector<ip_interface> ret;
    boost::system::error_code ec;
    auto v = libtorrent::enum_net_interfaces(s->get_io_service(), ec);
    for (auto& e : v)
    {
        ip_interface iface;
        iface.interface_address = e.interface_address;
        iface.netmask = e.netmask;
        iface.name = {e.name, e.name + sizeof(e.name)};
        iface.friendly_name = {e.friendly_name, e.friendly_name + sizeof(e.friendly_name)};
        iface.description = {e.description, e.description + sizeof(e.description)};
        iface.preferred = e.preferred;
        ret.push_back(iface);
    }
    return ret;
}

std::vector<ip_route> enum_routes(libtorrent::session* s)
{
    std::vector<ip_route> ret;
    boost::system::error_code ec;
    auto v = libtorrent::enum_routes(s->get_io_service(), ec);
    for (auto& e : v)
    {
        ip_route r;
        r.destination = e.destination;
        r.netmask = e.netmask;
        r.gateway = e.gateway;
        r.name = {e.name, e.name + sizeof(e.name)};
        r.mtu = e.mtu;
        ret.push_back(r);
    }
    return ret;
}

libtorrent::address get_default_gateway(libtorrent::session* s
    , std::vector<std::int8_t> device, bool v6)
{
    boost::system::error_code ec;
    return libtorrent::get_default_gateway(s->get_io_service()
        , {reinterpret_cast<char const*>(device.data()), device.size()}
        , v6, ec);
}

bool arm_neon_support()
{
    return libtorrent::aux::arm_neon_support;
}
