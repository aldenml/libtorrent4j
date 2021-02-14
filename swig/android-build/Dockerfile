FROM ubuntu:20.04

ENV DEBIAN_FRONTEND noninteractive
RUN apt update -y \
    && apt install -y \
    wget unzip less \
    python perl make cmake \
    g++

ENV BOOST_DOT_VERSION="1.75.0"
ENV BOOST_VERSION="1_75_0"
ENV NDK_VERSION="r21d"
ENV OPENSSL_VERSION="1.1.1i"
ENV OPENSSL_NO_OPTS="no-deprecated no-shared no-makedepend -fno-strict-aliasing -fvisibility=hidden -O3 -fPIC"

RUN wget -nv -O boost.tar.gz https://dl.bintray.com/boostorg/release/${BOOST_DOT_VERSION}/source/boost_${BOOST_VERSION}.tar.gz \
    && tar xzf boost.tar.gz \
    && mv boost_${BOOST_VERSION} boost \
    && cd boost \
    && ./bootstrap.sh \
    && cd ..

RUN wget -nv -O android-ndk.zip https://dl.google.com/android/repository/android-ndk-${NDK_VERSION}-linux-x86_64.zip \
    && unzip -qq android-ndk.zip \
    && mv android-ndk-${NDK_VERSION} android-ndk

RUN wget -nv -O openssl.tar.gz https://www.openssl.org/source/openssl-${OPENSSL_VERSION}.tar.gz \
    && tar xzf openssl.tar.gz \
    && mv openssl-${OPENSSL_VERSION} openssl-src

RUN android-ndk/build/tools/make_standalone_toolchain.py --arch arm --api 19 --stl libc++ --install-dir android-toolchain-arm \
    && android-ndk/build/tools/make_standalone_toolchain.py --arch arm64 --api 21 --stl libc++ --install-dir android-toolchain-arm64 \
    && android-ndk/build/tools/make_standalone_toolchain.py --arch x86 --api 19 --stl libc++ --install-dir android-toolchain-x86 \
    && android-ndk/build/tools/make_standalone_toolchain.py --arch x86_64 --api 21 --stl libc++ --install-dir android-toolchain-x86_64

RUN export CC=/android-toolchain-arm/bin/arm-linux-androideabi-clang \
    && export PATH=/android-toolchain-arm/arm-linux-androideabi/bin:${PATH} \
    && cd openssl-src \
    && ./Configure linux-armv4 ${OPENSSL_NO_OPTS} -march=armv7-a -mfpu=neon --prefix=/openssl-arm \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN export CC=/android-toolchain-arm64/bin/aarch64-linux-android-clang \
    && export PATH=/android-toolchain-arm64/aarch64-linux-android/bin:${PATH} \
    && cd openssl-src \
    && ./Configure linux-aarch64 ${OPENSSL_NO_OPTS} -march=armv8-a+crypto -mfpu=neon --prefix=/openssl-arm64 \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN export CC=/android-toolchain-x86/bin/i686-linux-android-clang \
    && export PATH=/android-toolchain-x86/i686-linux-android/bin:${PATH} \
    && cd openssl-src \
    && ./Configure linux-elf ${OPENSSL_NO_OPTS} --prefix=/openssl-x86 \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN export CC=/android-toolchain-x86_64/bin/x86_64-linux-android-clang \
    && export PATH=/android-toolchain-x86_64/x86_64-linux-android/bin:${PATH} \
    && cd openssl-src \
    && ./Configure linux-x86_64 ${OPENSSL_NO_OPTS} --prefix=/openssl-x86_64 \
    && make clean \
    && make \
    && make install_sw \
    && cd ..

RUN cd openssl-src \
    && make clean \
    && cd ..

RUN sed -i 's/POSIX_FADV_RANDOM 1/POSIX_FADV_RANDOM_NOOP 0/g' android-toolchain-arm/sysroot/usr/include/linux/fadvise.h \
    && sed -i 's/24/19/g' android-toolchain-arm/sysroot/usr/include/stdio.h \
    && sed -i 's/24/19/g' android-toolchain-arm/sysroot/usr/include/ifaddrs.h \
    && sed -i 's/28/19/g' android-toolchain-arm/sysroot/usr/include/sys/random.h \
    && sed -i 's/24/21/g' android-toolchain-arm64/sysroot/usr/include/stdio.h \
    && sed -i 's/24/21/g' android-toolchain-arm64/sysroot/usr/include/ifaddrs.h \
    && sed -i 's/28/21/g' android-toolchain-arm64/sysroot/usr/include/sys/random.h \
    && sed -i 's/POSIX_FADV_RANDOM 1/POSIX_FADV_RANDOM_NOOP 0/g' android-toolchain-x86/sysroot/usr/include/linux/fadvise.h \
    && sed -i 's/24/19/g' android-toolchain-x86/sysroot/usr/include/stdio.h \
    && sed -i 's/24/19/g' android-toolchain-x86/sysroot/usr/include/ifaddrs.h \
    && sed -i 's/28/19/g' android-toolchain-x86/sysroot/usr/include/sys/random.h \
    && sed -i 's/24/21/g' android-toolchain-x86_64/sysroot/usr/include/stdio.h \
    && sed -i 's/24/21/g' android-toolchain-x86_64/sysroot/usr/include/ifaddrs.h \
    && sed -i 's/28/21/g' android-toolchain-x86_64/sysroot/usr/include/sys/random.h \
    && sed -i 's/RANLIB = ranlib/RANLIB = "\/android-toolchain-x86_64\/bin\/x86_64-linux-android-ranlib"/g' /boost/tools/build/src/tools/gcc.jam

COPY b2-arm.sh b2-arm64.sh b2-x86.sh b2-x86_64.sh /
