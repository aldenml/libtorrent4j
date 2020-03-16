#ifndef LIBTORRENT_HPP
#define LIBTORRENT_HPP

#include <boost/version.hpp>
#include <openssl/opensslv.h>

#include <libtorrent/aux_/cpuid.hpp>

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

#endif
