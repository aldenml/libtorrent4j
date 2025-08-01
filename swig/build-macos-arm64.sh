#!/bin/bash

export BOOST_ROOT=$DEVELOPMENT_ROOT/boost_1_88_0
export LIBTORRENT_ROOT=$PWD/deps/libtorrent
export OPENSSL_ROOT=$DEVELOPMENT_ROOT/openssl-macos

$BOOST_ROOT/b2 -j8 --user-config=config/macos-arm64-config.jam variant=release toolset=darwin-arm64 target-os=darwin location=bin/release/macos/arm64
dsymutil bin/release/macos/arm64/libtorrent4j.dylib -o bin/release/macos/arm64/libtorrent4j.dSYM
strip -x bin/release/macos/arm64/libtorrent4j.dylib
cp bin/release/macos/arm64/libtorrent4j.dylib ../

rm -rf deps/libtorrent/deps/libdatachannel/deps/libjuice/build-*
rm -rf deps/libtorrent/deps/libdatachannel/deps/usrsctp/build-*
