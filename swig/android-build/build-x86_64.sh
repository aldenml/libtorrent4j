#!/bin/bash

docker run --rm -it -v "$PWD/../../":/libtorrent4j lt4j:latest "/b2-x86_64.sh"

pushd ../../
./gradlew clean
./gradlew jar
./gradlew nativeAndroidX64Jar
popd
