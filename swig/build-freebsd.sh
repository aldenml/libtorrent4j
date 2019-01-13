#!/usr/bin/env bash

# requirements:
# FreeBSD 11.1
# bash
# git
# openjdk8
# gradle
# wget

# result:
# you need to copy these libraries together
# from bin/release/freebsd/x86_64/
#
# libboost_system.so.1.69.0
# libtorrent.so.1.2.0
# libtorrent4j.so

# boost: download and bootstrap
rm -rf boost_1_69_0
wget -nv --show-progress -O boost.zip https://dl.bintray.com/boostorg/release/1.69.0/source/boost_1_69_0.zip
unzip -qq boost.zip
cd boost_1_69_0
./bootstrap.sh
cd ..
export BOOST_ROOT=$PWD/boost_1_69_0

export OPENSSL_ROOT=/usr

# libtorrent: download and checkout revision
rm -rf libtorrent
git clone https://github.com/arvidn/libtorrent
cd libtorrent
git checkout 3a1e546a6c63a056914547ecdbc565fb907b423d
cd ..
export LIBTORRENT_ROOT=$PWD/libtorrent

# compile libtorrent4j
rm -rf bin
export B2_PATH=${BOOST_ROOT}/tools/build/src/engine/bin.freebsdx86_64
${B2_PATH}/b2 --user-config=config/freebsd-x86_64-config.jam iconv=on variant=release toolset=clang-x86_64 target-os=freebsd location=bin/release/freebsd/x86_64
strip --strip-unneeded -x bin/release/freebsd/x86_64/libtorrent4j.so
readelf -d bin/release/freebsd/x86_64/libtorrent4j.so

# cd ../ and run gradle test
cp bin/release/freebsd/x86_64/libboost_system.so.1.69.0 ../
cp bin/release/freebsd/x86_64/libtorrent.so.1.2.0 ../
cp bin/release/freebsd/x86_64/libtorrent4j.so ../
