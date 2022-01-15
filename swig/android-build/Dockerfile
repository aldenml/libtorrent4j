FROM ubuntu:20.04

ENV DEBIAN_FRONTEND noninteractive
RUN apt update -y \
    && apt install -y \
    wget unzip less \
    python perl make cmake \
    g++

ENV BOOST_DOT_VERSION="1.78.0"
ENV BOOST_VERSION="1_78_0"
ENV NDK_VERSION="r23b"
ENV OPENSSL_VERSION="1.1.1m"
ENV OPENSSL_NO_OPTS="no-deprecated no-shared no-makedepend no-static-engine no-stdio no-posix-io no-threads no-ui-console no-zlib no-zlib-dynamic -fno-strict-aliasing -fvisibility=hidden -O3 -fPIC"

RUN wget -nv -O boost.tar.gz https://boostorg.jfrog.io/artifactory/main/release/${BOOST_DOT_VERSION}/source/boost_${BOOST_VERSION}.tar.gz \
    && tar xzf boost.tar.gz \
    && mv boost_${BOOST_VERSION} boost \
    && cd boost \
    && ./bootstrap.sh \
    && cd ..

RUN wget -nv -O android-ndk.zip https://dl.google.com/android/repository/android-ndk-${NDK_VERSION}-linux.zip \
    && unzip -qq android-ndk.zip \
    && mv android-ndk-${NDK_VERSION} android-ndk

RUN wget -nv -O openssl.tar.gz https://www.openssl.org/source/openssl-${OPENSSL_VERSION}.tar.gz \
    && tar xzf openssl.tar.gz \
    && mv openssl-${OPENSSL_VERSION} openssl-src

ENV TOOLCHAIN="/android-ndk/toolchains/llvm/prebuilt/linux-x86_64"
ENV AR="${TOOLCHAIN}/bin/llvm-ar"
ENV LD="${TOOLCHAIN}/bin/ld"
ENV RANLIB="${TOOLCHAIN}/bin/llvm-ranlib"

RUN export CC=${TOOLCHAIN}/bin/armv7a-linux-androideabi24-clang \
    && cd openssl-src \
    && ./Configure linux-armv4 ${OPENSSL_NO_OPTS} -march=armv7-a -mfpu=neon --prefix=/openssl-arm \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN export CC=${TOOLCHAIN}/bin/aarch64-linux-android24-clang \
    && cd openssl-src \
    && ./Configure linux-aarch64 ${OPENSSL_NO_OPTS} -march=armv8-a+crypto -mfpu=neon --prefix=/openssl-arm64 \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN export CC=${TOOLCHAIN}/bin/i686-linux-android24-clang \
    && cd openssl-src \
    && ./Configure linux-elf ${OPENSSL_NO_OPTS} --prefix=/openssl-x86 \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN export CC=${TOOLCHAIN}/bin/x86_64-linux-android24-clang \
    && cd openssl-src \
    && ./Configure linux-x86_64 ${OPENSSL_NO_OPTS} --prefix=/openssl-x86_64 \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN cd openssl-src \
    && make clean \
    && cd ..

RUN sed -i 's/28/24/g' ${TOOLCHAIN}/sysroot/usr/include/sys/random.h

COPY b2-arm.sh b2-arm64.sh b2-x86.sh b2-x86_64.sh /
