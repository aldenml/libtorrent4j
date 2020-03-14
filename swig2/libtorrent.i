%module (jniclassname="libtorrent_jni", directors="1") libtorrent

// Overloaded method <name> ignored, using <name> instead.
#pragma SWIG nowarn=516

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

#include "libtorrent/client_data.hpp"
#include "libtorrent/sha1_hash.hpp"
#include "libtorrent/info_hash.hpp"
#include "libtorrent/storage_defs.hpp"
#include "libtorrent/bitfield.hpp"
#include "libtorrent/address.hpp"
#include "libtorrent/socket.hpp"
#include "libtorrent/operations.hpp"
#include "libtorrent/error_code.hpp"
#include "libtorrent/announce_entry.hpp"
#include "libtorrent/file_storage.hpp"
#include "libtorrent/peer_request.hpp"
#include "libtorrent/bdecode.hpp"
#include "libtorrent/torrent_info.hpp"
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
%apply std::int64_t { std::ptrdiff_t };
%apply std::int64_t { std::time_t };

%define TYPE_INTEGRAL_CONVERSION_EX(name, underlying_type, api_type, java_type)
%typemap(jni) name, const name& "java_type"
%typemap(jtype) name, const name& "java_type"
%typemap(jstype) name, const name& "java_type"

%typemap(in) name {
    $1 = name(static_cast<underlying_type>($input));
}
%typemap(out) name {
    $result = static_cast<api_type>(static_cast<underlying_type>($1));
}
%typemap(javain) name, const name& "$javainput"
%typemap(javaout) name, const name& {
    return $jnicall;
  }
%enddef

%define TYPE_INTEGRAL_CONVERSION(name, underlying_type, java_type)
TYPE_INTEGRAL_CONVERSION_EX(name, underlying_type, underlying_type, java_type)
%enddef

TYPE_INTEGRAL_CONVERSION(torrent_flags_t, std::uint64_t, long)
TYPE_INTEGRAL_CONVERSION(piece_index_t, std::int32_t, int)
TYPE_INTEGRAL_CONVERSION(file_index_t, std::int32_t, int)
// TYPE_INTEGRAL_CONVERSION_EX(peer_class_t, std::uint32_t, std::int32_t, int)
// TYPE_INTEGRAL_CONVERSION(port_mapping_t, int, int)
// TYPE_INTEGRAL_CONVERSION(queue_position_t, int, int)
// TYPE_INTEGRAL_CONVERSION(disconnect_severity_t, std::uint8_t, int)

// template definitions
%template(string_int_pair) std::pair<std::string, int>;
%template(string_string_pair) std::pair<std::string, std::string>;

%template(string_vector) std::vector<std::string>;
%template(int_vector) std::vector<int>;
%template(byte_vector) std::vector<std::int8_t>;
%template(bool_vector) std::vector<bool>;
%template(string_int_pair_vector) std::vector<std::pair<std::string, int>>;
%template(string_string_pair_vector) std::vector<std::pair<std::string, std::string>>;

%template(tcp_endpoint_vector) std::vector<libtorrent::tcp::endpoint>;
%template(announce_endpoint_vector) std::vector<libtorrent::announce_endpoint>;
%template(announce_entry_vector) std::vector<libtorrent::announce_entry>;
%template(web_seed_entry_vector) std::vector<libtorrent::web_seed_entry>;
%template(file_slice_vector) std::vector<libtorrent::file_slice>;

%template(bool_vector_vector) std::vector<std::vector<bool>>;
%template(sha256_hash_vector_vector) std::vector<std::vector<libtorrent::digest32<256>>>;

%template(int_string_map) std::map<int, std::string>;
%template(int_bitfield_map) std::map<int, libtorrent::bitfield>;

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
%rename(op_bool) operator bool;

// includes
%include "boost/system/error_code.i"

%include "libtorrent/client_data.i"
%include "libtorrent/sha1_hash.i"
%include "libtorrent/info_hash.hpp"
%include "libtorrent/storage_defs.i"
%include "libtorrent/bitfield.i"
%include "libtorrent/address.i"
%include "libtorrent/socket.i"
%include "libtorrent/operations.i"
%include "libtorrent/error_code.i"
%include "libtorrent/announce_entry.i"
%include "libtorrent/file_storage.i"
%include "libtorrent/peer_request.i"
%include "libtorrent/bdecode.i"
%include "libtorrent/torrent_info.i"
%include "libtorrent/add_torrent_params.i"
