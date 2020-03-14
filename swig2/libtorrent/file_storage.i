namespace libtorrent {

struct file_slice
{
    file_index_t file_index;

    std::int64_t offset;

    std::int64_t size;
};

class file_storage
{
};

}
