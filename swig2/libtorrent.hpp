#ifndef LIBTORRENT_HPP
#define LIBTORRENT_HPP

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

#endif
