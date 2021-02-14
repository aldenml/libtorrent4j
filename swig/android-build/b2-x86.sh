#!/bin/bash

rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/libjuice/build-*
rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/usrsctp/build-*

alias ranlib='/android-toolchain-x86/bin/i686-linux-android-ranlib'
export ANDROID_TOOLCHAIN=/android-toolchain-x86
export PATH=${ANDROID_TOOLCHAIN}/i686-linux-android/bin:${PATH}
export BOOST_ROOT=/boost
export OPENSSL_ROOT=/openssl-x86
export LIBTORRENT_ROOT=/libtorrent4j/swig/deps/libtorrent
export CXX=${ANDROID_TOOLCHAIN}/bin/i686-linux-android-clang++
export CC=${ANDROID_TOOLCHAIN}/bin/i686-linux-android-clang
cd /libtorrent4j/swig
${BOOST_ROOT}/b2 -j2 --user-config=config/android-x86-config.jam variant=release toolset=clang-x86 target-os=android location=bin/release/android/x86
${ANDROID_TOOLCHAIN}/bin/i686-linux-android-objcopy --only-keep-debug bin/release/android/x86/libtorrent4j.so bin/release/android/x86/libtorrent4j.so.debug
${ANDROID_TOOLCHAIN}/bin/i686-linux-android-strip --strip-unneeded -x -g bin/release/android/x86/libtorrent4j.so
${ANDROID_TOOLCHAIN}/bin/i686-linux-android-readelf -d bin/release/android/x86/libtorrent4j.so
