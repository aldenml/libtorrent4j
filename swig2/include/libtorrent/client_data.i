namespace libtorrent {

struct client_data_t
{
    client_data_t();

    client_data_t(void*);

    %extend
    {
        void* get()
        {
            return $self->get<void>();
        }
    }
};

}
