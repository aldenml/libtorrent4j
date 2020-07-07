namespace libtorrent {

template <typename T>
class span
{
public:

    std::int64_t size() const;
    bool empty() const;

    T& front() const;
    T& back() const;

    span<T> first(std::int64_t const n) const;

    span<T> last(std::int64_t const n) const;

    span<T> subspan(std::int64_t const offset) const;

    span<T> subspan(std::int64_t const offset, std::int64_t const count) const;

    T& operator[](std::int64_t const idx) const;

private:
    span(); // disable constructor in java side
};

%template(byte_span) libtorrent::span<std::int8_t const>;

}
