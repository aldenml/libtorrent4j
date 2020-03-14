#!/bin/bash

BOOST_ROOT=$DEVELOPMENT_ROOT/boost_1_72_0
LIBTORRENT_ROOT=$DEVELOPMENT_ROOT/libtorrent

JAVA_SRC_OUTPUT=../src/main/java/org/libtorrent4j/swig2

rm -rf ${JAVA_SRC_OUTPUT}
mkdir -p ${JAVA_SRC_OUTPUT}

swig -c++ -java -o libtorrent_jni.cpp \
    -outdir ${JAVA_SRC_OUTPUT} \
    -package org.libtorrent4j.swig2 \
    -I${BOOST_ROOT} \
    -I${LIBTORRENT_ROOT}/include \
    -DBOOST_ASIO_DECL="" \
    -DBOOST_NO_TYPEID=1 \
    -DBOOST_NO_EXCEPTIONS \
    -DBOOST_POSIX_API=1 \
    -DBOOST_SYSTEM_NOEXCEPT="" \
    -DBOOST_SYSTEM_DECL="" \
    -DBOOST_SYSTEM_NO_DEPRECATED=1 \
    -DBOOST_SYSTEM_CONSTEXPR \
    -DBOOST_NO_IOSTREAM \
    -DBOOST_SYMBOL_VISIBLE \
    -DBOOST_NOEXCEPT="" \
    -DBOOST_NOEXCEPT_OR_NOTHROW="" \
    -DTORRENT_ABI_VERSION=3 \
    -DTORRENT_VERSION_NAMESPACE_2="" \
    -DTORRENT_VERSION_NAMESPACE_2_END="" \
    -DTORRENT_VERSION_NAMESPACE_3="" \
    -DTORRENT_VERSION_NAMESPACE_3_END="" \
    -DTORRENT_IPV6_NAMESPACE="" \
    -DTORRENT_IPV6_NAMESPACE_END="" \
    -DTORRENT_CFG="TORRENT_CFG" \
    -DTORRENT_NO_DEPRECATE \
    -DTORRENT_DEPRECATED_EXPORT="" \
    -DTORRENT_DEPRECATED_MEMBER="" \
    -DTORRENT_DEPRECATED_ENUM="" \
    -DTORRENT_DEPRECATED \
    -DTORRENT_EXPORT="" \
    -DTORRENT_EXTRA_EXPORT="" \
    -DTORRENT_FORMAT\(x,y\)="" \
    -DNDEBUG=1 \
    -D_bit="" \
    -Dfinal="" \
    libtorrent.i
