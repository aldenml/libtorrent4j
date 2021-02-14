#!/bin/bash

rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/libjuice/build-*
rm -rf /libtorrent4j/swig/deps/libtorrent/deps/libdatachannel/deps/usrsctp/build-*

alias ranlib='/android-toolchain-arm/bin/arm-linux-androideabi-ranlib'
export ANDROID_TOOLCHAIN=/android-toolchain-arm
export PATH=${ANDROID_TOOLCHAIN}/arm-linux-androideabi/bin:${PATH}
export BOOST_ROOT=/boost
export OPENSSL_ROOT=/openssl-arm
export LIBTORRENT_ROOT=/libtorrent4j/swig/deps/libtorrent
export CXX=${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-clang++
export CC=${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-clang
cd /libtorrent4j/swig
${BOOST_ROOT}/b2 -j2 --user-config=config/android-arm-config.jam variant=release toolset=clang-linux-arm target-os=android location=bin/release/android/armeabi-v7a
${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-objcopy --only-keep-debug bin/release/android/armeabi-v7a/libtorrent4j.so bin/release/android/armeabi-v7a/libtorrent4j.so.debug
${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-strip --strip-unneeded -x -g bin/release/android/armeabi-v7a/libtorrent4j.so
${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-readelf -d bin/release/android/armeabi-v7a/libtorrent4j.so
