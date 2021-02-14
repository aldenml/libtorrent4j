#!/bin/bash

rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/libjuice/build-*
rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/usrsctp/build-*

alias ranlib='/android-toolchain-x86_64/bin/x86_64-linux-android-ranlib'
export ANDROID_TOOLCHAIN=/android-toolchain-x86_64
export PATH=${ANDROID_TOOLCHAIN}/x86_64-linux-android/bin:${PATH}
export BOOST_ROOT=/boost
export OPENSSL_ROOT=/openssl-x86_64
export LIBTORRENT_ROOT=/libtorrent4j/swig/deps/libtorrent
export CXX=${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android-clang++
export CC=${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android-clang
cd /libtorrent4j/swig
${BOOST_ROOT}/b2 -j2 --user-config=config/android-x86_64-config.jam variant=release toolset=clang-x86_64 target-os=android location=bin/release/android/x86_64
${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android-objcopy --only-keep-debug bin/release/android/x86_64/libtorrent4j.so bin/release/android/x86_64/libtorrent4j.so.debug
${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android-strip --strip-unneeded -x bin/release/android/x86_64/libtorrent4j.so
${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android-readelf -d bin/release/android/x86_64/libtorrent4j.so
