#!/bin/bash

wget -nv -O android-ndk.zip https://dl.google.com/android/repository/android-ndk-${NDK_VERSION}-linux-x86_64.zip
unzip -qq android-ndk.zip
mv android-ndk-${NDK_VERSION} android-ndk
