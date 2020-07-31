#!/bin/bash

export NDK=${PWD}/android-ndk
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
