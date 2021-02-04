%module (jniclassname="libtorrent_jni", directors="1") libtorrent

// Overloaded method <name> ignored, using <name> instead.
#pragma SWIG nowarn=516
// Specialization of non-template '<name>'.
#pragma SWIG nowarn=317

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

    public static final native long directBufferAddress(java.nio.Buffer buffer);
    public static final native long directBufferCapacity(java.nio.Buffer buffer);
%}

%exception {
    try {
        $action
    } catch (std::exception& e) {
        SWIG_JavaThrowException(jenv, SWIG_JavaRuntimeException, e.what());
        return $null;
    } catch (...) {
        SWIG_JavaThrowException(jenv, SWIG_JavaRuntimeException, "Unknown exception type");
        return $null;
    }
}

%{
// BEGIN common set include ----------------------------------------------------

#include "libtorrent/flags.hpp"
#include "libtorrent/address.hpp"
#include "libtorrent/socket.hpp"
#include "libtorrent/kademlia/dht_state.hpp"
#include "libtorrent/client_data.hpp"
#include "libtorrent/sha1_hash.hpp"
#include "libtorrent/info_hash.hpp"
#include "libtorrent/storage_defs.hpp"
#include "libtorrent/bitfield.hpp"
#include "libtorrent/operations.hpp"
#include "libtorrent/error_code.hpp"
#include "libtorrent/announce_entry.hpp"
#include "libtorrent/file_storage.hpp"
#include "libtorrent/peer_request.hpp"
#include "libtorrent/bdecode.hpp"
#include "libtorrent/torrent_info.hpp"
#include "libtorrent/torrent_flags.hpp"
#include "libtorrent/add_torrent_params.hpp"
#include "libtorrent/close_reason.hpp"
#include "libtorrent/peer_info.hpp"
#include "libtorrent/pex_flags.hpp"
#include "libtorrent/torrent_status.hpp"
#include "libtorrent/torrent_handle.hpp"
#include "libtorrent/performance_counters.hpp"
#include "libtorrent/portmap.hpp"
#include "libtorrent/piece_block.hpp"
#include "libtorrent/socket_type.hpp"
#include "libtorrent/entry.hpp"
#include "libtorrent/tracker_event.hpp"
#include "libtorrent/alert.hpp"
#include "libtorrent/alert_types.hpp"
#include "libtorrent/settings_pack.hpp"
#include "libtorrent/peer_class.hpp"
#include "libtorrent/peer_class_type_filter.hpp"
#include "libtorrent/ip_filter.hpp"
#include "libtorrent/session_types.hpp"
#include "libtorrent/session_params.hpp"
#include "libtorrent/session_handle.hpp"
#include "libtorrent/session.hpp"
#include "libtorrent/file_storage.hpp"
#include "libtorrent/create_torrent.hpp"
#include "libtorrent/session_stats.hpp"
#include "libtorrent/version.hpp"
#include "libtorrent/magnet_uri.hpp"
#include "libtorrent/fingerprint.hpp"
#include "libtorrent/read_resume_data.hpp"
#include "libtorrent/write_resume_data.hpp"

#include <libtorrent/hex.hpp>
#include <libtorrent/bencode.hpp>

namespace lt = libtorrent;

using piece_index_t = libtorrent::piece_index_t;
using file_index_t = libtorrent::file_index_t;
using queue_position_t = libtorrent::queue_position_t;

#include "libtorrent.hpp"

template <typename IndexType>
using typed_bitfield = libtorrent::typed_bitfield<IndexType>;

// END common set include ------------------------------------------------------
%}

// direct buffer code
%{
#ifdef __cplusplus
extern "C" {
#endif

SWIGEXPORT jlong JNICALL Java_org_libtorrent4j_swig_libtorrent_1jni_directBufferAddress(JNIEnv *jenv, jclass jcls, jobject jbuf) {
    try {
        return jlong(jenv->GetDirectBufferAddress(jbuf));
    } catch (std::exception& e) {
      SWIG_JavaThrowException(jenv, SWIG_JavaRuntimeException, e.what());
    } catch (...) {
      SWIG_JavaThrowException(jenv, SWIG_JavaRuntimeException, "Unknown exception type");
    }

    return 0;
}

SWIGEXPORT jlong JNICALL Java_org_libtorrent4j_swig_libtorrent_1jni_directBufferCapacity(JNIEnv *jenv, jclass jcls, jobject jbuf) {
    try {
        return jlong(jenv->GetDirectBufferCapacity(jbuf));
    } catch (std::exception& e) {
      SWIG_JavaThrowException(jenv, SWIG_JavaRuntimeException, e.what());
    } catch (...) {
      SWIG_JavaThrowException(jenv, SWIG_JavaRuntimeException, "Unknown exception type");
    }

    return 0;
}

#ifdef __cplusplus
}
#endif
%}

%include <stdint.i>
%include <typemaps.i>
%include <std_string.i>
%include <std_pair.i>
%include <std_vector.i>
%include <std_map.i>
%include <std_array.i>
%include <std_bitset.i>

%include "boost/boost_map.i"

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

TYPE_INTEGRAL_CONVERSION(piece_index_t, std::int32_t, int)
TYPE_INTEGRAL_CONVERSION(file_index_t, std::int32_t, int)
TYPE_INTEGRAL_CONVERSION(queue_position_t, int, int)

// template definitions
%template(int_byte_pair) std::pair<int, std::int8_t>;
%template(string_int_pair) std::pair<std::string, int>;
%template(string_string_pair) std::pair<std::string, std::string>;
%template(byte_vector_byte_vector_pair) std::pair<std::vector<std::int8_t>, std::vector<std::int8_t>>;

%template(sha1_hash_udp_endpoint_pair) std::pair<libtorrent::digest32<160>, libtorrent::udp::endpoint>;
%template(bdecode_node_bdecode_node_pair) std::pair<libtorrent::bdecode_node, libtorrent::bdecode_node>;
%template(address_sha1_hash_pair) std::pair<libtorrent::address, libtorrent::digest32<160>>;

%template(string_vector) std::vector<std::string>;
%template(int_vector) std::vector<int>;
%template(int64_vector) std::vector<long long>;
%template(byte_vector) std::vector<std::int8_t>;
%template(bool_vector) std::vector<bool>;
%template(int_byte_pair_vector) std::vector<std::pair<int, std::int8_t>>;
%template(string_int_pair_vector) std::vector<std::pair<std::string, int>>;
%template(string_string_pair_vector) std::vector<std::pair<std::string, std::string>>;

%template(tcp_endpoint_vector) std::vector<libtorrent::tcp::endpoint>;
%template(udp_endpoint_vector) std::vector<libtorrent::udp::endpoint>;
%template(announce_endpoint_vector) std::vector<libtorrent::announce_endpoint>;
%template(announce_entry_vector) std::vector<libtorrent::announce_entry>;
%template(web_seed_entry_vector) std::vector<libtorrent::web_seed_entry>;
%template(file_slice_vector) std::vector<libtorrent::file_slice>;
%template(piece_block_vector) std::vector<libtorrent::piece_block>;
%template(torrent_status_vector) std::vector<libtorrent::torrent_status>;
%template(dht_lookup_vector) std::vector<libtorrent::dht_lookup>;
%template(dht_routing_bucket_vector) std::vector<libtorrent::dht_routing_bucket>;
%template(entry_vector) std::vector<libtorrent::entry>;
%template(partial_piece_info_vector) std::vector<libtorrent::partial_piece_info>;
%template(peer_info_vector) std::vector<libtorrent::peer_info>;
%template(torrent_handle_vector) std::vector<libtorrent::torrent_handle>;
%template(alert_ptr_vector) std::vector<libtorrent::alert*>;
%template(stats_metric_vector) std::vector<libtorrent::stats_metric>;
%template(ip_interface_vector) std::vector<ip_interface>;
%template(ip_route_vector) std::vector<ip_route>;

%template(bool_vector_vector) std::vector<std::vector<bool>>;
%template(sha256_hash_vector_vector) std::vector<std::vector<libtorrent::digest32<256>>>;
%template(sha1_hash_udp_endpoint_pair_vector) std::vector<std::pair<libtorrent::digest32<160>, libtorrent::udp::endpoint>>;
%template(address_sha1_hash_pair_vector) std::vector<std::pair<libtorrent::address, libtorrent::digest32<160>>>;

%template(byte_array_32) std::array<std::int8_t, 32>;
%template(byte_array_64) std::array<std::int8_t, 64>;

%template(int_string_map) std::map<int, std::string>;
%template(string_string_map) std::map<std::string, std::string>;
%template(int_bitfield_map) std::map<int, libtorrent::bitfield>;
%template(string_entry_map) std::map<std::string, libtorrent::entry>;

%template(boost_string_entry_map) boost::container::map<std::string, libtorrent::entry>;

%template(bitset_128) std::bitset<128>;

// ignore of operators
%ignore operator=;
%ignore operator^=;
%ignore operator&=;
%ignore operator|=;
%ignore operator<<=;
%ignore operator>>=;

// rename of operators
%rename(eq) operator==;
%rename(ne) operator!=;
%rename(lt) operator<;
%rename(gt) operator>;
%rename(lte) operator<=;
%rename(gte) operator>=;
%rename(inv) operator~;
%rename(xor) operator^;
%rename(or_) operator|;
%rename(and_) operator&;
%rename(at) operator[];
%rename(to_bool) operator bool;

// general ignores
%ignore libtorrent::aux;
%ignore mem_copy;

// directors
%feature("director") alert_notify_callback;
%feature("director") add_files_listener;
%feature("director") set_piece_hashes_listener;

// includes
%include "boost/system/error_code.i"

%include "libtorrent/span.i"
%include "libtorrent/flags.i"
%include "libtorrent/address.i"
%include "libtorrent/socket.i"
%include "libtorrent/kademlia/dht_state.i"
%include "libtorrent/client_data.i"
%include "libtorrent/sha1_hash.i"
%include "libtorrent/info_hash.i"
%include "libtorrent/storage_defs.i"
%include "libtorrent/bitfield.i"
%include "libtorrent/operations.i"
%include "libtorrent/error_code.i"
%include "libtorrent/announce_entry.i"
%include "libtorrent/file_storage.i"
%include "libtorrent/peer_request.i"
%include "libtorrent/bdecode.i"
%include "libtorrent/torrent_info.i"
%include "libtorrent/torrent_flags.i"
%include "libtorrent/add_torrent_params.i"
%include "libtorrent/close_reason.i"
%include "libtorrent/peer_info.i"
%include "libtorrent/pex_flags.i"
%include "libtorrent/torrent_status.i"
%include "libtorrent/torrent_handle.i"
%include "libtorrent/performance_counters.i"
%include "libtorrent/portmap.i"
%include "libtorrent/piece_block.i"
%include "libtorrent/socket_type.i"
%include "libtorrent/entry.i"
%include "libtorrent/tracker_event.i"
%include "libtorrent/alert.i"
%include "libtorrent/alert_types.i"
%include "libtorrent/settings_pack.i"
%include "libtorrent/peer_class.i"
%include "libtorrent/peer_class_type_filter.i"
%include "libtorrent/ip_filter.i"
%include "libtorrent/session_types.i"
%include "libtorrent/session_params.i"
%include "libtorrent/session_handle.i"
%include "libtorrent/session.i"
%include "libtorrent/file_storage.i"
%include "libtorrent/create_torrent.i"
%include "libtorrent/session_stats.i"
%include "libtorrent/version.i"
%include "libtorrent/magnet_uri.i"
%include "libtorrent/fingerprint.i"
%include "libtorrent/read_resume_data.i"
%include "libtorrent/write_resume_data.i"

// for libtorrent.hpp
%ignore set_piece_hashes_listener::progress_index;
%ignore dht_put_item_cb;

%include "libtorrent.hpp"
