namespace libtorrent {

struct torrent_info
{
    torrent_info(std::string const& filename, boost::system::error_code& ec);
};

}

%shared_ptr(libtorrent::torrent_info)
