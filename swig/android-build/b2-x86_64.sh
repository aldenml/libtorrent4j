#!/bin/bash

rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/libjuice/build-*
rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/usrsctp/build-*

alias ranlib='/android-ndk/toolchains/llvm/prebuilt/linux-x86_64/bin/llvm-ranlib'
export ANDROID_TOOLCHAIN=/android-ndk/toolchains/llvm/prebuilt/linux-x86_64
export BOOST_ROOT=/boost
export OPENSSL_ROOT=/openssl-x86_64
export LIBTORRENT_ROOT=/libtorrent4j/swig/deps/libtorrent
export CXX=${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android21-clang++
export CC=${ANDROID_TOOLCHAIN}/bin/x86_64-linux-android21-clang
export AR=${ANDROID_TOOLCHAIN}/bin/llvm-ar
export LD=${ANDROID_TOOLCHAIN}/bin/ld
export RANLIB=${ANDROID_TOOLCHAIN}/bin/llvm-ranlib

cd /libtorrent4j/swig
${BOOST_ROOT}/b2 -j2 --user-config=config/android-x86_64-config.jam variant=release toolset=clang-x86_64 target-os=android location=bin/release/android/x86_64
${ANDROID_TOOLCHAIN}/bin/llvm-objcopy --only-keep-debug bin/release/android/x86_64/libtorrent4j.so bin/release/android/x86_64/libtorrent4j.so.debug
${ANDROID_TOOLCHAIN}/bin/llvm-strip --strip-unneeded -x bin/release/android/x86_64/libtorrent4j.so
${ANDROID_TOOLCHAIN}/bin/llvm-readelf -d bin/release/android/x86_64/libtorrent4j.so
