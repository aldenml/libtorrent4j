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
#include "libtorrent/add_torrent_params.hpp"

using namespace libtorrent;

// END common set include ------------------------------------------------------
%}

%include "libtorrent/add_torrent_params.hpp"
