#!/bin/bash

export BOOST_ROOT=$DEVELOPMENT_ROOT/boost_1_72_0
export LIBTORRENT_ROOT=$DEVELOPMENT_ROOT/libtorrent
export OPENSSL_ROOT=$DEVELOPMENT_ROOT/openssl-macos

$BOOST_ROOT/b2 -j8 --user-config=config/macosx-x86_64-config.jam variant=release toolset=darwin-x86_64 target-os=darwin location=bin/release/macosx/x86_64
dsymutil bin/release/macosx/x86_64/libtorrent4j.dylib -o bin/release/macosx/x86_64/libtorrent4j.dSYM
strip -x bin/release/macosx/x86_64/libtorrent4j.dylib
cp bin/release/macosx/x86_64/libtorrent4j.dylib ../
