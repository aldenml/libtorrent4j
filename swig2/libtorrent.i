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
#include "libtorrent/info_hash.hpp"
#include "libtorrent/add_torrent_params.hpp"

using namespace libtorrent;

// END common set include ------------------------------------------------------
%}

%include <stdint.i>
%include <typemaps.i>
%include <std_string.i>
%include <std_pair.i>
%include <std_vector.i>

%apply std::int64_t { void* };
%apply std::int64_t { std::time_t };

// template definitions
%template(string_int_pair) std::pair<std::string, int>;

%template(string_vector) std::vector<std::string>;
%template(int_vector) std::vector<int>;
%template(string_int_pair_vector) std::vector<std::pair<std::string, int>>;

%template(tcp_endpoint_vector) std::vector<tcp::endpoint>;

// ignore of operators
%ignore operator=;

// rename of operators
%rename(op_eq) operator==;
%rename(op_ne) operator!=;
%rename(op_lt) operator<;
%rename(op_gt) operator>;
%rename(op_lte) operator<=;
%rename(op_gte) operator>=;

// includes
%include "libtorrent/client_data.i"
%include "libtorrent/info_hash.hpp"
%include "libtorrent/add_torrent_params.i"
