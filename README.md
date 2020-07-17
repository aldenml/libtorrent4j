# libtorrent4j

[![Build Status](https://travis-ci.com/aldenml/libtorrent4j.svg?branch=master)](https://travis-ci.com/aldenml/libtorrent4j)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5dda1f00528e4d93864eb8694c702bba)](https://app.codacy.com/manual/aldenml/libtorrent4j/dashboard)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/5dda1f00528e4d93864eb8694c702bba)](https://app.codacy.com/manual/aldenml/libtorrent4j/dashboard)
[![Maven Central](https://img.shields.io/maven-central/v/org.libtorrent4j/libtorrent4j.svg?label=maven)](https://search.maven.org/search?q=g:%22org.libtorrent4j%22%20AND%20a:%22libtorrent4j%22)

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
| HTTP Seeding (Hoffman-style) | [BEP 17](https://www.bittorrent.org/beps/bep_0017.html) |
| Superseeding | [BEP 16](https://www.bittorrent.org/beps/bep_0016.html) |
| UDP Tracker Protocol | [BEP 15](https://www.bittorrent.org/beps/bep_0015.html) |
| Local Service Discovery (LSD) | [BEP 14](https://www.bittorrent.org/beps/bep_0014.html) |
| Multitracker Metadata Extension | [BEP 12](https://www.bittorrent.org/beps/bep_0012.html) |
| Peer Exchange (PEX) | [BEP 11](https://www.bittorrent.org/beps/bep_0014.html) |
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

For examples look at [demos](https://github.com/aldenml/libtorrent4j/tree/master/src/test/java/org/libtorrent4j/demo).

Architectures supported:

- Android (armeabi-v7a, arm64-v8a, x86, x86_64)
- macOS (x86_64)
- Linux (x86_64)
- Windows (x86_64)

## Projects using libtorrent4j

Submit a PR to add a link here.
 - [LibreTorrent](https://gitlab.com/proninyaroslav/libretorrent)

## License

Licensed under the terms of the MIT license, available [here](LICENSE.md).
