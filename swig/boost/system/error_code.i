namespace boost {
namespace system {

class error_code
{
public:

    error_code();
    void clear();
    int value();
    std::string message();
    bool failed();
    operator bool() const;
};

}}
