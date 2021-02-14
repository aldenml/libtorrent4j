#!/bin/bash

docker run --rm -it -v "$PWD/../../":/libtorrent4j lt4j:latest "/b2-arm64.sh"

pushd ../../
./gradlew clean
./gradlew jar
./gradlew nativeAndroidArm64Jar
popd
