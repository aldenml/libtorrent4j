#ifndef LIBTORRENT_HPP
#define LIBTORRENT_HPP

struct alert_notify_callback {

    virtual ~alert_notify_callback()
    {}

    virtual void on_alert()
    {}
};

#endif
