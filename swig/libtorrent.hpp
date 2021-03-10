#ifndef LIBTORRENT_HPP
#define LIBTORRENT_HPP

#include <boost/version.hpp>
#include <openssl/opensslv.h>

#include <libtorrent/aux_/cpuid.hpp>
#include <libtorrent/kademlia/ed25519.hpp>
#include <libtorrent/kademlia/item.hpp>
#include <libtorrent/aux_/enum_net.hpp>
#include <libtorrent/aux_/random.hpp>

namespace lt = libtorrent;

struct alert_notify_callback
{

    virtual ~alert_notify_callback()
    {}

    virtual void on_alert()
    {}
};

int find_metric_idx_ex(std::string name)
{
    return lt::find_metric_idx(name);
}

const char* boost_lib_version()
{
    return BOOST_LIB_VERSION;
}

const char* openssl_version_text()
{
    return OPENSSL_VERSION_TEXT;
}

bool arm_neon_support()
{
    return libtorrent::aux::arm_neon_support;
}

std::array<std::int8_t, 32> ed25519_create_seed()
{
    auto seed = lt::dht::ed25519_create_seed();
    return *reinterpret_cast<std::array<std::int8_t, 32>*>(&seed);
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

    signature sig = ed25519_sign({reinterpret_cast<char const*>(msg.data()), static_cast<long>(msg.size())},
        pk1, sk1);
    return std::vector<int8_t>(sig.bytes.begin(), sig.bytes.end());
}

bool ed25519_verify(std::vector<int8_t>& sig,
    std::vector<int8_t>& msg,
    std::vector<int8_t>& pk) {
    using namespace libtorrent::dht;

    signature sig1((char*)sig.data());
    public_key pk1((char*)pk.data());

    return ed25519_verify(sig1, {reinterpret_cast<char const*>(msg.data()), static_cast<long>(msg.size())}, pk1);
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
    libtorrent::address source_hint;
    std::vector<std::int8_t> name;
    int mtu;
};

std::vector<ip_interface> enum_net_interfaces(libtorrent::session* s)
{
    std::vector<ip_interface> ret;
    boost::system::error_code ec;
    auto v = libtorrent::aux::enum_net_interfaces(s->get_context(), ec);
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
    auto v = libtorrent::aux::enum_routes(s->get_context(), ec);
    for (auto& e : v)
    {
        ip_route r;
        r.destination = e.destination;
        r.netmask = e.netmask;
        r.gateway = e.gateway;
        r.source_hint = e.source_hint;
        r.name = {e.name, e.name + sizeof(e.name)};
        r.mtu = e.mtu;
        ret.push_back(r);
    }
    return ret;
}

void mem_copy(std::vector<std::int8_t> source
    , char* target, std::size_t target_size)
{
    std::memset(target, 0, target_size);
    std::memcpy(target, source.data(), std::min(source.size(), target_size));
}

libtorrent::address get_gateway(ip_interface const& iface
    , std::vector<ip_route>& routes)
{
    lt::aux::ip_interface lt_iface{};
    lt_iface.interface_address = iface.interface_address;
    lt_iface.netmask = iface.netmask;
    lt_iface.preferred = iface.preferred;

    mem_copy(iface.name, lt_iface.name, 64);
    mem_copy(iface.friendly_name, lt_iface.friendly_name, 128);
    mem_copy(iface.description, lt_iface.description, 128);

    std::vector<lt::aux::ip_route> lt_routes;
    for (auto const& r : routes) {
        lt::aux::ip_route lt_ip_route{};
        lt_ip_route.destination = r.destination;
        lt_ip_route.netmask = r.netmask;
        lt_ip_route.gateway = r.gateway;
        lt_ip_route.source_hint = r.source_hint;
        lt_ip_route.mtu = r.mtu;
        mem_copy(r.name, lt_ip_route.name, 64);
        lt_routes.push_back(lt_ip_route);
    }

    return lt::aux::get_gateway(lt_iface, lt_routes)
        .value_or(lt::address{});
}

std::string device_for_address(libtorrent::session* s
    , libtorrent::address addr, boost::system::error_code& ec)
{
    return lt::aux::device_for_address(addr, s->get_context(), ec);
}

struct add_files_listener
{

    virtual ~add_files_listener()
    {}

    virtual bool pred(std::string const& p)
    {
        return true;
    }
};

void add_files_ex(libtorrent::file_storage& fs, std::string const& file
    , add_files_listener* listener, libtorrent::create_flags_t flags)
{
    add_files(fs, file, std::bind(&add_files_listener::pred
        , listener, std::placeholders::_1), flags);
}

struct set_piece_hashes_listener
{

    virtual ~set_piece_hashes_listener()
    {}

    virtual void progress(int i)
    {}

    void progress_index(piece_index_t i)
    {
        progress(static_cast<int>(i));
    }
};

void set_piece_hashes_ex(libtorrent::create_torrent& t, std::string const& p
    , set_piece_hashes_listener* listener, libtorrent::error_code& ec)
{
    set_piece_hashes(t, p, std::bind(&set_piece_hashes_listener::progress_index
        , listener, std::placeholders::_1), ec);
}

void dht_put_item_cb(libtorrent::entry& e, std::array<char, 64>& sig, std::int64_t& seq,
    std::string salt, libtorrent::dht::public_key pk, libtorrent::dht::secret_key sk,
    libtorrent::entry data)
{
    using namespace libtorrent::dht;

    e = data;
    std::vector<char> buf;
    bencode(std::back_inserter(buf), e);
    signature sign;
    ++seq;
    sign = sign_mutable_item(buf, salt, sequence_number(seq), pk, sk);
    sig = sign.bytes;
}

lt::add_torrent_params read_resume_data_ex(std::vector<std::int8_t> const& buffer
    , lt::error_code& ec, lt::load_torrent_limits const& cfg = {})
{
    return lt::read_resume_data({(char const*)&buffer[0], static_cast<long>(buffer.size())}, ec, cfg);
}

std::vector<std::int8_t> write_resume_data_buf_ex(lt::add_torrent_params const& atp)
{
    auto v = lt::write_resume_data_buf(atp);
    return {v.begin(), v.end()};
}

lt::add_torrent_params parse_magnet_uri(std::string const& uri, lt::error_code& ec)
{
    return lt::parse_magnet_uri(uri, ec);
}

#if defined(__ANDROID__) || defined(ANDROID)

#include <dlfcn.h>
#include <unistd.h> // lseek
#include <stdio.h> // fileno

void* get_libc()
{
    static void* h = dlopen("libc.so", RTLD_NOW);
    return h;
}

// NOTE: remove getifaddrs and freeifaddrs when supported API >= 24
extern "C" int getifaddrs(struct ifaddrs** __list_ptr)
{
    typedef int func_t(struct ifaddrs**);
    static func_t* f = (func_t*) dlsym(get_libc(), "getifaddrs");
    return f != NULL ? f(__list_ptr) : -1;
}

extern "C" void freeifaddrs(struct ifaddrs* __ptr)
{
    typedef void func_t(struct ifaddrs*);
    static func_t* f = (func_t*) dlsym(get_libc(), "freeifaddrs");
    if (f != NULL) f(__ptr);
}

// NOTE: remove getrandom when supported API >= 28
extern "C" ssize_t getrandom(void* __buffer, size_t __buffer_size, unsigned int __flags)
{
    lt::aux::random_bytes({static_cast<char*>(__buffer), static_cast<std::ptrdiff_t>(__buffer_size)});
    return __buffer_size;
}

#endif

#endif
