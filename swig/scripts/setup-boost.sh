#!/bin/bash

wget -nv -O boost.tar.gz https://dl.bintray.com/boostorg/release/${BOOST_DOT_VERSION}/source/boost_${BOOST_VERSION}.tar.gz
tar xzf boost.tar.gz
mv boost_${BOOST_VERSION} boost-src
pushd boost-src
./bootstrap.sh --prefix=../boost
popd
