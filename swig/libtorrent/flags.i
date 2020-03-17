namespace libtorrent { namespace flags {

template<typename UnderlyingType, typename Tag>
struct bitfield_flag
{
    static bitfield_flag all();

    %extend
    {
        bool op_bool()
        {
            return $self->operator bool();
        }

        bool op_eq(bitfield_flag const f)
        {
            return $self->operator==(f);
        }

        bool op_ne(bitfield_flag const f)
        {
            return $self->operator!=(f);
        }

        bitfield_flag op_or(bitfield_flag const other)
        {
            return *$self | other;
        }

        bitfield_flag op_and(bitfield_flag const other)
        {
            return *$self & other;
        }

        bitfield_flag xor(bitfield_flag const other)
        {
            return *$self ^ other;
        }

        bitfield_flag inv()
        {
            return $self->operator~();
        }

        int to_int()
        {
            return static_cast<int>(static_cast<UnderlyingType>(*$self));
        }
    }
};

}}
