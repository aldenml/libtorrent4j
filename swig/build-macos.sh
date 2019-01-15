#!/usr/bin/env bash

export DEVELOPMENT_ROOT=~/Development
export BOOST_ROOT=$DEVELOPMENT_ROOT/boost_1_69_0
export LIBTORRENT_ROOT=$DEVELOPMENT_ROOT/libtorrent
export OPENSSL_ROOT=$DEVELOPMENT_ROOT/openssl-macos

$BOOST_ROOT/b2 -j8 --user-config=config/macosx-x86_64-config.jam variant=release toolset=darwin-x86_64 target-os=darwin location=bin/release/macosx/x86_64
strip -S -x bin/release/macosx/x86_64/libtorrent4j.dylib
cp bin/release/macosx/x86_64/libtorrent4j.dylib ../

export ANDROID_TOOLCHAIN=$DEVELOPMENT_ROOT/android-toolchain-arm
export OPENSSL_ROOT=$DEVELOPMENT_ROOT/openssl-arm
export PATH=$ANDROID_TOOLCHAIN/arm-linux-androideabi/bin:$PATH
#$BOOST_ROOT/b2 -j8 --user-config=config/android-arm-config.jam variant=release toolset=clang-linux-arm target-os=android location=bin/release/android/armeabi-v7a
#${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-objcopy --only-keep-debug bin/release/android/armeabi-v7a/libtorrent4j.so bin/release/android/armeabi-v7a/libtorrent4j.so.debug
#${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-strip --strip-unneeded -x -g bin/release/android/armeabi-v7a/libtorrent4j.so
