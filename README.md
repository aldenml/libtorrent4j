# libtorrent4j

[![macOS](https://github.com/aldenml/libtorrent4j/workflows/macOS/badge.svg)](https://github.com/aldenml/libtorrent4j/actions?query=workflow%3AmacOS)
[![Linux](https://github.com/aldenml/libtorrent4j/workflows/Linux/badge.svg)](https://github.com/aldenml/libtorrent4j/actions?query=workflow%3ALinux)
[![Windows](https://github.com/aldenml/libtorrent4j/workflows/Windows/badge.svg)](https://github.com/aldenml/libtorrent4j/actions?query=workflow%3AWindows)
[![Android](https://github.com/aldenml/libtorrent4j/workflows/Android/badge.svg)](https://github.com/aldenml/libtorrent4j/actions?query=workflow%3AAndroid)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5dda1f00528e4d93864eb8694c702bba)](https://app.codacy.com/manual/aldenml/libtorrent4j/dashboard)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/5dda1f00528e4d93864eb8694c702bba)](https://app.codacy.com/manual/aldenml/libtorrent4j/dashboard)
[![Maven Central](https://img.shields.io/maven-central/v/org.libtorrent4j/libtorrent4j.svg?label=maven)](https://search.maven.org/search?q=g:%22org.libtorrent4j%22%20AND%20a:%22libtorrent4j%22)
[![Open Hub](https://www.openhub.net/p/libtorrent4j/widgets/project_thin_badge.gif)](https://www.openhub.net/p/libtorrent4j)

A swig Java interface for [libtorrent](https://github.com/arvidn/libtorrent).

| Features |   |
|---|---|
| Support for WebTorrent | https://webtorrent.io |
| Sequential downloading |  |
| Torrents queueing and prioritizing |  |
| Torrent content selection and prioritizing | |
| NAT-PMP and UPnP support | |
| Fast resume support | |
| HTTP proxies and basic authentication | |
| IP filter | |
| Torrents over SSL |  |
| `lt_donthave` extension | [BEP 54](https://www.bittorrent.org/beps/bep_0054.html) |
| Magnet URI extension - specify indices to download | [BEP 53](https://www.bittorrent.org/beps/bep_0053.html) |
| BitTorrent Protocol v2 | [BEP 52](https://www.bittorrent.org/beps/bep_0052.html) |
| DHT Infohash Indexing | [BEP 51](https://www.bittorrent.org/beps/bep_0051.html) |
| Tracker Protocol Extension: Scrape | [BEP 48](https://www.bittorrent.org/beps/bep_0048.html) |
| Padding files and attributes | [BEP 47](https://www.bittorrent.org/beps/bep_0047.html) |
| Multiple-address operation for the DHT | [BEP 45](https://www.bittorrent.org/beps/bep_0045.html) |
| Storing arbitrary data in the DHT | [BEP 44](https://www.bittorrent.org/beps/bep_0044.html) |
| Read-only DHT Nodes | [BEP 43](https://www.bittorrent.org/beps/bep_0043.html) |
| IPv6 extension for DHT | [BEP 32](https://www.bittorrent.org/beps/bep_0032.html) |
| uTorrent transport protocol (uTP) | [BEP 29](https://www.bittorrent.org/beps/bep_0029.html) |
| Private Torrents | [BEP 27](https://www.bittorrent.org/beps/bep_0027.html) |
| Tracker Returns External IP | [BEP 24](https://www.bittorrent.org/beps/bep_0024.html) |
| Tracker Returns Compact Peer Lists | [BEP 23](https://www.bittorrent.org/beps/bep_0023.html) |
| Extension for Partial Seeds | [BEP 21](https://www.bittorrent.org/beps/bep_0021.html) |
| HTTP/FTP Seeding (GetRight-style) | [BEP 19](https://www.bittorrent.org/beps/bep_0019.html) |
| Superseeding | [BEP 16](https://www.bittorrent.org/beps/bep_0016.html) |
| UDP Tracker Protocol | [BEP 15](https://www.bittorrent.org/beps/bep_0015.html) |
| Local Service Discovery (LSD) | [BEP 14](https://www.bittorrent.org/beps/bep_0014.html) |
| Multitracker Metadata Extension | [BEP 12](https://www.bittorrent.org/beps/bep_0012.html) |
| Peer Exchange (PEX) | [BEP 11](https://www.bittorrent.org/beps/bep_0011.html) |
| Extension Protocol | [BEP 10](https://www.bittorrent.org/beps/bep_0010.html) |
| Magnet links | [BEP 9](https://www.bittorrent.org/beps/bep_0009.html) |
| IPv6 Tracker Extension | [BEP 7](https://www.bittorrent.org/beps/bep_0007.html) |
| Distributed hash table (DHT) | [BEP 5](https://www.bittorrent.org/beps/bep_0005.html) |

## Using

Download [the latest JAR](https://search.maven.org/classic/remote_content?g=org.libtorrent4j&a=libtorrent4j&v=LATEST) or get the dependency via Maven:
```xml
<dependency>
  <groupId>org.libtorrent4j</groupId>
  <artifactId>libtorrent4j</artifactId>
  <version>2.x.x</version>
</dependency>
```
or Gradle:
```groovy
compile 'org.libtorrent4j:libtorrent4j:2.x.x'
```

If you use ProGuard to obfuscate/minify make sure to add the following statement

`-keep class org.libtorrent4j.swig.libtorrent_jni {*;}`

Note that there are multiple versions of libtorrent4j for different platforms:
```
libtorrent4j
libtorrent4j-android-<arch>
libtorrent4j-macos
libtorrent4j-linux
libtorrent4j-windows
```
These are all different artifacts, you need to select according to your architecture.

For examples look at [demos](https://github.com/aldenml/libtorrent4j/tree/master/demo)
and [tests](https://github.com/aldenml/libtorrent4j/tree/master/src/test/java/org/libtorrent4j).

Architectures supported:

- Android (armeabi-v7a, arm64-v8a, x86, x86_64)
- macOS (x86_64)
- Linux (x86_64)
- Windows (x86_64)

#### About stability

This library tracks libtorrent [`master`](https://github.com/arvidn/libtorrent/tree/master) branch.
The branch is very stable, runs a lot of tests, and receives bug fixes quickly.

## Android local builds

It's possible to build android binaries locally. The solution is docker based, you
need to have Docker installed and running (see https://docs.docker.com/engine/install/).

Go to the folder `swig/android-build` and perform all the operations inside it.

1 - Build the docker image just one time (takes a long time):
```
docker build -t lt4j:latest .
```

2 - Select your architecture and run the build script, for example:
```
./build-arm.sh
```

3 - Collect the jars in `build/libs` at the root of the project. Repeat
the step 2) for the desired architectures.

## License

Licensed under the terms of the MIT license, available [here](LICENSE.md).
