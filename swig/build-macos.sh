#!/bin/bash

export BOOST_ROOT=$DEVELOPMENT_ROOT/boost_1_73_0
export LIBTORRENT_ROOT=$DEVELOPMENT_ROOT/libtorrent
export OPENSSL_ROOT=$DEVELOPMENT_ROOT/openssl-macos

# minor fix to libtorrent build
rm -rf $LIBTORRENT_ROOT/deps/libdatachannel/deps/libjuice/build
rm -rf $LIBTORRENT_ROOT/deps/libdatachannel/deps/usrsctp/build

$BOOST_ROOT/b2 -j8 --user-config=config/macos-x86_64-config.jam variant=release toolset=darwin-x86_64 target-os=darwin location=bin/release/macos/x86_64
dsymutil bin/release/macos/x86_64/libtorrent4j.dylib -o bin/release/macos/x86_64/libtorrent4j.dSYM
strip -x bin/release/macos/x86_64/libtorrent4j.dylib
cp bin/release/macos/x86_64/libtorrent4j.dylib ../
