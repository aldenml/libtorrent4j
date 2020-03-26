#ifndef LIBTORRENT_HPP
#define LIBTORRENT_HPP

#include <boost/version.hpp>
#include <openssl/opensslv.h>

#include <libtorrent/aux_/cpuid.hpp>
#include <libtorrent/kademlia/ed25519.hpp>
#include <libtorrent/enum_net.hpp>

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
    auto v = libtorrent::enum_net_interfaces(s->get_context(), ec);
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
    auto v = libtorrent::enum_routes(s->get_context(), ec);
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
    lt::ip_interface lt_iface{};
    lt_iface.interface_address = iface.interface_address;
    lt_iface.netmask = iface.netmask;
    lt_iface.preferred = iface.preferred;

    mem_copy(iface.name, lt_iface.name, 64);
    mem_copy(iface.friendly_name, lt_iface.friendly_name, 128);
    mem_copy(iface.description, lt_iface.description, 128);

    std::vector<lt::ip_route> lt_routes;
    for (auto const& r : routes) {
        lt::ip_route lt_ip_route{};
        lt_ip_route.destination = r.destination;
        lt_ip_route.netmask = r.netmask;
        lt_ip_route.gateway = r.gateway;
        lt_ip_route.source_hint = r.source_hint;
        lt_ip_route.mtu = r.mtu;
        mem_copy(r.name, lt_ip_route.name, 64);
        lt_routes.push_back(lt_ip_route);
    }

    return lt::get_gateway(lt_iface, lt_routes)
        .value_or(lt::address{});
}

std::string device_for_address(libtorrent::session* s
    , libtorrent::address addr, boost::system::error_code& ec)
{
    return lt::device_for_address(addr, s->get_context(), ec);
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

#if !defined TORRENT_WINDOWS
#define POSIX_WRAPPER 1
#else
#define POSIX_WRAPPER 0
#endif

struct posix_stat_t {
    int64_t size;
    int64_t atime;
    int64_t mtime;
    int64_t ctime;
    int mode;
};

#if POSIX_WRAPPER
DIR* posix_opendir(const char *name);
int posix_open(const char* path, int flags, int mode);
int posix_stat(const char *path, struct ::stat *buf);
int posix_mkdir(const char *path, mode_t mode);
int posix_remove(const char *path);
#endif

struct posix_wrapper {

    virtual ~posix_wrapper() {
    }

    virtual std::int64_t opendir(const char *name)
    {
#if POSIX_WRAPPER
        return (std::int64_t)::opendir(name);
#else
        return -1;
#endif
    }

    virtual int open(const char* path, int flags, int mode) {
#if POSIX_WRAPPER
        return ::open(path, flags, mode);
#else
        return -1;
#endif
    }

    virtual int stat(const char *path, posix_stat_t *buf) {
#if POSIX_WRAPPER
        struct ::stat t;
        int r = ::stat(path, &t);
        buf->size = t.st_size;
        buf->atime = t.st_atime;
        buf->mtime = t.st_mtime;
        buf->ctime = t.st_ctime;
        buf->mode = t.st_mode;
        return r;
#else
        return -1;
#endif
    }

    virtual int mkdir(const char *path, int mode) {
#if POSIX_WRAPPER
        return ::mkdir(path, mode);
#else
        return -1;
#endif
    }

    virtual int remove(const char *path) {
#if POSIX_WRAPPER
        return ::remove(path);
#else
        return -1;
#endif
    }
};

posix_wrapper* g_posix_wrapper = nullptr;

void set_posix_wrapper(posix_wrapper *obj) {
    g_posix_wrapper = obj;
}

void set_posix_errno(int val)
{
#if POSIX_WRAPPER
    errno = val;
#endif
}

#if POSIX_WRAPPER
DIR* posix_opendir(const char *name)
{
    return g_posix_wrapper != nullptr
        ? (DIR*)g_posix_wrapper->opendir(name)
        : ::opendir(name);
}

int posix_open(const char* path, int flags, int mode)
{
    return g_posix_wrapper != nullptr
        ? g_posix_wrapper->open(path, flags, mode)
        : ::open(path, flags, mode);
}

int posix_stat(const char *path, struct ::stat *buf)
{
    if (g_posix_wrapper != nullptr)
    {
        posix_stat_t t;
        int r = g_posix_wrapper->stat(path, &t);
        buf->st_size = t.size;
        buf->st_atime = t.atime;
        buf->st_mtime = t.mtime;
        buf->st_ctime = t.ctime;
        buf->st_mode = t.mode;
        return r;
    }
    else
    {
        return ::stat(path, buf);
    }
}

int posix_mkdir(const char *path, mode_t mode)
{
    return g_posix_wrapper != nullptr
        ? g_posix_wrapper->mkdir(path, mode)
        : ::mkdir(path, mode);
}

int posix_remove(const char *path)
{
    return g_posix_wrapper != nullptr
        ? g_posix_wrapper->remove(path)
        : ::remove(path);
}
#endif // POSIX_WRAPPER

#endif
