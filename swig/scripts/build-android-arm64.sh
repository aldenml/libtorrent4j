#!/bin/bash

extract_packages() {

  NDK_VERSION=r21d
  BOOST_VERSION=1_75_0
  OPENSSL_VERSION=1.1.1j

  NDK_PKG=${PWD}/../../android-ndk-${NDK_VERSION}-darwin-x86_64.zip
  BOOST_PKG=${PWD}/../../boost_${BOOST_VERSION}.tar.gz
  OPENSSL_PKG=${PWD}/../../openssl-${OPENSSL_VERSION}.tar.gz

  rm -rf build
  mkdir build

  pushd build

  echo "Extracting NDK..."
  unzip -qq ${NDK_PKG}
  echo "Extracting BOOST..."
  tar xzf ${BOOST_PKG}
  echo "Extracting OpenSSL..."
  tar xzf ${OPENSSL_PKG}
  echo "Done extraction"

  mv android-ndk-${NDK_VERSION} android-ndk
  mv boost_${BOOST_VERSION} boost-src
  mv openssl-${OPENSSL_VERSION} openssl-src

  popd

  pushd build/boost-src
  ./bootstrap.sh --prefix=../boost
  popd
}

compile_boost() {

  pushd build/boost-src

  ./b2 -d0 --user-config=../../config/android-arm64-config.jam --prefix=../boost --with-headers --with-system install variant=release toolset=clang-arm64 target-os=android link=static

  popd
}

compile_openssl() {

  pushd build/openssl-src

  OPENSSL_OPTS="no-deprecated no-shared no-makedepend no-static-engine no-stdio no-posix-io no-threads no-ui-console no-zlib no-zlib-dynamic -fno-strict-aliasing -fvisibility=hidden -O3 -fPIC"

  ./Configure linux-aarch64 ${OPENSSL_OPTS} -march=armv8-a+crypto --prefix=${PWD}/../openssl
  echo "Compiling openssl..."
  make -j8 &> /dev/null
  make install_sw &> /dev/null

  popd
}

extract_packages

export NDK=${PWD}/build/android-ndk
export TOOLCHAIN=${NDK}/toolchains/llvm/prebuilt/darwin-x86_64
export TARGET=aarch64-linux-android
export API=24
export AR=${TOOLCHAIN}/bin/$TARGET-ar
export AS=${TOOLCHAIN}/bin/$TARGET-as
export CC=${TOOLCHAIN}/bin/$TARGET$API-clang
export CXX=${TOOLCHAIN}/bin/$TARGET$API-clang++
export LD=${TOOLCHAIN}/bin/$TARGET-ld
export RANLIB=${TOOLCHAIN}/bin/$TARGET-ranlib
export STRIP=${TOOLCHAIN}/bin/$TARGET-strip

shopt -s expand_aliases
alias ranlib=${RANLIB}

compile_boost
compile_openssl

cmake \
  -DCMAKE_TOOLCHAIN_FILE=$NDK/build/cmake/android.toolchain.cmake \
  -DANDROID_ABI=arm64-v8a \
  -DANDROID_NATIVE_API_LEVEL=24 \
  -DANDROID_STL=c++_static \
  -DBoost_INCLUDE_DIR=${PWD}/build/boost/include \
  -DBoost_SYSTEM_LIBRARY_RELEASE=${PWD}/build/boost/lib \
  -DOPENSSL_INCLUDE_DIR=${PWD}/build/openssl/include \
  -DOPENSSL_CRYPTO_LIBRARY=${PWD}/build/openssl/lib/libcrypto.a \
  -DOPENSSL_SSL_LIBRARY=${PWD}/build/openssl/lib/libssl.a \
  -DCMAKE_BUILD_TYPE=Debug \
  -B build \
  -G "CodeBlocks - Unix Makefiles" \
  .

cmake --build build --config Debug --parallel 8
