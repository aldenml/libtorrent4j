namespace libtorrent {

%rename(tcp_endpoint) tcp::endpoint;
%rename(udp_endpoint) udp::endpoint;

namespace tcp {

    class endpoint
    {
    public:
        endpoint();
        endpoint(address address, unsigned short port);
        endpoint(endpoint const& other);

        unsigned short port();
        address address();
    };
};

namespace udp {

    class endpoint {
    public:
        endpoint();
        endpoint(address address, unsigned short port);
        endpoint(endpoint const& other);

        unsigned short port();
        address address();
    };
}

}
