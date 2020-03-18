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

bool arm_neon_support()
{
    return libtorrent::aux::arm_neon_support;
}

#if defined TORRENT_ANDROID
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
int posix_open(const char* path, int flags, int mode);
int posix_stat(const char *path, struct ::stat *buf);
int posix_mkdir(const char *path, mode_t mode);
int posix_remove(const char *path);
#endif

struct posix_wrapper {

    virtual ~posix_wrapper() {
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
#endif
