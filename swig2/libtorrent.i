%module (jniclassname="libtorrent_jni", directors="1") libtorrent

%pragma(java) jniclasscode=%{

    static {
        try {
            String path = System.getProperty("libtorrent4j.jni.path", "");
            if ("".equals(path)) {
                String libname = "torrent4j";
                String os = System.getProperty("os.name");
                if (os != null && os.toLowerCase(java.util.Locale.US).contains("windows"))
                    libname = "lib" + libname;

                System.loadLibrary(libname);
            } else {
                System.load(path);
            }
        } catch (LinkageError e) {
            throw new LinkageError(
                "Look for your architecture binary instructions at: https://github.com/aldenml/libtorrent4j", e);
        }
    }
%}

%{
// BEGIN common set include ----------------------------------------------------

#include "libtorrent/torrent_info.hpp"
#include "libtorrent/client_data.hpp"
#include "libtorrent/sha1_hash.hpp"
#include "libtorrent/info_hash.hpp"
#include "libtorrent/storage_defs.hpp"
#include "libtorrent/add_torrent_params.hpp"

#include "libtorrent/hex.hpp"

using namespace libtorrent;

// END common set include ------------------------------------------------------
%}

%include <stdint.i>
%include <typemaps.i>
%include <std_string.i>
%include <std_pair.i>
%include <std_vector.i>
%include <std_map.i>
%include <std_shared_ptr.i>

%apply std::int8_t { char };
%apply std::int64_t { void* };
%apply std::int32_t { std::ptrdiff_t };
%apply std::int64_t { std::time_t };

// template definitions
%template(string_int_pair) std::pair<std::string, int>;

%template(string_vector) std::vector<std::string>;
%template(int_vector) std::vector<int>;
%template(byte_vector) std::vector<std::int8_t>;
%template(bool_vector) std::vector<bool>;
%template(string_int_pair_vector) std::vector<std::pair<std::string, int>>;

%template(tcp_endpoint_vector) std::vector<tcp::endpoint>;

%template(bool_vector_vector) std::vector<std::vector<bool>>;
%template(sha256_hash_vector_vector) std::vector<std::vector<libtorrent::digest32<256>>>;

%template(int_string_map) std::map<int, std::string>;
%template(int_bitfield_map) std::map<int, bitfield>;

%shared_ptr(torrent_info)

// ignore of operators
%ignore operator=;

// rename of operators
%rename(op_eq) operator==;
%rename(op_ne) operator!=;
%rename(op_lt) operator<;
%rename(op_gt) operator>;
%rename(op_lte) operator<=;
%rename(op_gte) operator>=;
%rename(op_neg) operator~;
%rename(op_xor) operator^;
%rename(op_xor_mut) operator^=;
%rename(op_and) operator&;
%rename(op_and_mut) operator&=;
%rename(op_or_mut) operator|=;
%rename(op_shl_mut) operator<<=;
%rename(op_shr_mut) operator>>=;
%rename(op_at) operator[];

// includes
%include "libtorrent/client_data.i"
%include "libtorrent/sha1_hash.i"
%include "libtorrent/info_hash.hpp"
%include "libtorrent/storage_defs.i"
%include "libtorrent/add_torrent_params.i"
