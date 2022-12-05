cmake_minimum_required(VERSION 3.16)

cmake_policy(SET CMP0077 NEW)
cmake_policy(SET CMP0091 NEW)

set(CMAKE_POSITION_INDEPENDENT_CODE ON)
set(CMAKE_MSVC_RUNTIME_LIBRARY "MultiThreaded$<$<CONFIG:Debug>:Debug>")
set(CMAKE_CXX_VISIBILITY_PRESET hidden)

project(libtorrent4j
    DESCRIPTION "libtorrent JNI SWIG binding"
    VERSION 2.0.0
    LANGUAGES CXX)

set(include_files
    jni.h
    libtorrent.hpp
    libtorrent_jni.h)

set(source_files
    libtorrent_jni.cpp)

add_library(torrent4j SHARED
    ${source_files}
    ${include_files})

target_compile_features(torrent4j PUBLIC cxx_std_17)

target_include_directories(torrent4j PUBLIC
    $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}>
    $<INSTALL_INTERFACE:${CMAKE_INSTALL_INCLUDEDIR}>)

option(deprecated-functions "" OFF)
option(BUILD_SHARED_LIBS "" OFF)
option(webtorrent "" ON)
option(USE_JUICE "" ON)
option(USE_NETTLE "" OFF)

set(Boost_USE_STATIC_LIBS ON)
set(OPENSSL_USE_STATIC_LIBS ON)
set(OPENSSL_MSVC_STATIC_RT ON)

macro(install)
endmacro()
macro(export)
endmacro()

add_subdirectory(deps/libtorrent EXCLUDE_FROM_ALL)

target_link_libraries(torrent4j PRIVATE torrent-rasterbar)
target_include_directories(torrent4j PRIVATE /opt/homebrew/opt/openssl\@1.1/include/)

if (CMAKE_CXX_COMPILER_ID MATCHES Clang)
    # nothing
elseif (CMAKE_CXX_COMPILER_ID MATCHES GNU)
    target_link_libraries(torrent4j PRIVATE -static-libgcc -static-libstdc++)
elseif (MSVC)
    # nothing
endif ()
