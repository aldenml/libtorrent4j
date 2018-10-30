libtorrent4j
=====================

[![Build Status](https://travis-ci.com/aldenml/libtorrent4j.svg?branch=master)](https://travis-ci.com/aldenml/libtorrent4j)

A swig Java interface for libtorrent.

Develop libtorrent based apps with the joy of coding in Java.

Using
========

Download [the latest JAR](https://search.maven.org/classic/remote_content?g=org.libtorrent4j&a=libtorrent4j&v=LATEST) or get the dependency via Maven:
```xml
<dependency>
  <groupId>org.libtorrent4j</groupId>
  <artifactId>libtorrent4j</artifactId>
  <version>1.2.x.x</version>
</dependency>
```
or Gradle:
```groovy
compile 'org.libtorrent4j:libtorrent4j:1.2.x.x'
```

If you use ProGuard to obfuscate/minify make sure to add the following statement

`-keep class org.libtorrent4j.swig.libtorrent_jni {*;}`


Note that there are multiple version of libtorrent4j for different platforms: `libtorrent4j`, `libtorrent4j-windows`, `libtorrent4j-linux`, `libtorrent4j-macosx` and `libtorrent4j-android-<arch>`. These are all different artifacts.

For examples look at https://github.com/aldenml/libtorrent4j/tree/master/src/test/java/org/libtorrent4j/demo

Architectures supported:

- Android (armeabi-v7a, arm64-v8a, x86, x86_64)
- Linux (x86, x86_64)
- Windows (x86, x86_64)
- Mac OS X (x86_64)

Building
========

You need:

- Setup a travis account at http://travis-ci.org and get familiar with
the service if necessary.
- Open an account with Amazon Web Services (AWS) and get familiar with
S3 (for storage) and IAM (for users).
- Some familiarity with `git` commands.

The process is:

- Create a user in amazon IAM, let's suppose it is `user1`. Download
credentials for the keys.
- Create a bucket in amazon S3, let's suppose it is `libtorrent4j1`.
- Set the permission of the bucket according to your workflow, but at
least the `user1` should have permission to put/upload to the bucket.
See for example this bucket policy:
```json
{
	"Statement": [
		{
			"Effect": "Allow",
			"Principal": {"AWS":"arn:aws:iam::<user1's ARN here>:user/user1"},
			"Action": "s3:PutObject",
			"Resource": "arn:aws:s3:::libtorrent4j1/*"
		},
		{
			"Effect": "Allow",
			"Principal": "*",
			"Action": "s3:GetObject",
			"Resource": "arn:aws:s3:::libtorrent4j1/*"
		}
	]
}
```
- Fork the project in github.
- Go to travis and enable the repository.
- Go to 'More options' > 'Settings' > 'Environment Variables' and set the
`S3_ACCESS_KEY, S3_SECRET_KEY, S3_BUCKET` variables using the values in the
credentials file for the user you created and the bucket name you created.
- Clone locally your repo, let's assume to the `libtorrent4j` folder and
checkout the stable branch:
```bash
$ git clone <your fork repo url> libtorrent4j
$ cd libtorrent4j
$ git checkout master
```
- Verify in your travis online if the build already started. The build
 could take about 40 minutes, be patient.
- When finished, check your s3 bucket for the binaries.
- To trigger a new build, just make a change or merge new changes from
 the stable branch, commit and push.

Projects using libtorrent4j
==========================
TODO

License
========

This software is offered under the MIT License, available [here](License.md).
