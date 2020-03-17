#ifndef LIBTORRENT_HPP
#define LIBTORRENT_HPP

#include <boost/version.hpp>
#include <openssl/opensslv.h>

#include <libtorrent/aux_/cpuid.hpp>
#include <libtorrent/kademlia/ed25519.hpp>

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

int boost_version()
{
    return BOOST_VERSION;
}

const char* boost_lib_version()
{
    return BOOST_LIB_VERSION;
}

int openssl_version_number()
{
    return OPENSSL_VERSION_NUMBER;
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

#endif
