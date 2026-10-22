/*
 * Copyright (c) 2018-2026, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * Smoke test: many Java threads use the native crypto primitives at the same
 * time, the same way disk hashing threads, the network thread and application
 * threads do in a running session.
 * <p>
 * Parsing a torrent computes its info-hash natively (libtorrent hasher, backed
 * by OpenSSL EVP SHA-1/SHA-256 when built with crypto=openssl), so the first
 * test exercises the concurrent EVP digest init/free path from JNI caller
 * threads; the expected hash is computed independently with the JDK, so a
 * wrong or corrupted native digest is detected. The second test calls the
 * native random generator (OpenSSL RAND_bytes) concurrently. OpenSSL must be
 * built with thread support (the default "threads" configuration) for either
 * to be safe.
 */
public class ConcurrentHashingTest {

    private static final int THREADS = 8;
    private static final int ITERATIONS = 10000;

    @Test
    public void testConcurrentInfoHash() throws Throwable {
        // smallest valid v1 metadata: a single 1-byte file, one piece
        byte[] pieceHash = new byte[20];
        for (int i = 0; i < pieceHash.length; i++) {
            pieceHash[i] = (byte) i;
        }
        byte[] infoDict = concat(
                "d6:lengthi1e4:name4:test12:piece lengthi16384e6:pieces20:".getBytes(StandardCharsets.US_ASCII),
                pieceHash,
                "e".getBytes(StandardCharsets.US_ASCII));
        byte[] torrent = concat(
                "d4:info".getBytes(StandardCharsets.US_ASCII),
                infoDict,
                "e".getBytes(StandardCharsets.US_ASCII));

        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        final Sha1Hash expected = Sha1Hash.fromBytes(sha1.digest(infoDict));

        // sanity check on the calling thread
        assertEquals(expected, TorrentInfo.bdecode(torrent).infoHash());

        final CountDownLatch start = new CountDownLatch(1);
        final AtomicInteger mismatches = new AtomicInteger();
        final List<Throwable> errors = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int t = 0; t < THREADS; t++) {
            Thread th = new Thread(() -> {
                try {
                    start.await();
                    for (int i = 0; i < ITERATIONS; i++) {
                        TorrentInfo ti = TorrentInfo.bdecode(torrent);
                        if (!expected.equals(ti.infoHash())) {
                            mismatches.incrementAndGet();
                        }
                    }
                } catch (Throwable e) {
                    synchronized (errors) {
                        errors.add(e);
                    }
                }
            }, "ConcurrentHashingTest-" + t);
            th.start();
            threads.add(th);
        }

        start.countDown();
        for (Thread th : threads) {
            th.join();
        }

        if (!errors.isEmpty()) {
            throw errors.get(0);
        }
        assertEquals(0, mismatches.get());
    }

    @Test
    public void testConcurrentRandomSeeds() throws Throwable {
        final List<Throwable> errors = new ArrayList<>();
        final AtomicInteger badSeeds = new AtomicInteger();
        final CountDownLatch start = new CountDownLatch(1);
        List<Thread> threads = new ArrayList<>();

        for (int t = 0; t < THREADS; t++) {
            Thread th = new Thread(() -> {
                try {
                    start.await();
                    byte[] previous = null;
                    for (int i = 0; i < ITERATIONS; i++) {
                        byte[] seed = Ed25519.createSeed();
                        if (seed == null || seed.length != Ed25519.SEED_SIZE
                                || (previous != null && Arrays.equals(previous, seed))) {
                            badSeeds.incrementAndGet();
                        }
                        previous = seed;
                    }
                } catch (Throwable e) {
                    synchronized (errors) {
                        errors.add(e);
                    }
                }
            }, "ConcurrentHashingTest-seed-" + t);
            th.start();
            threads.add(th);
        }

        start.countDown();
        for (Thread th : threads) {
            th.join();
        }

        if (!errors.isEmpty()) {
            throw errors.get(0);
        }
        assertEquals(0, badSeeds.get());
    }

    private static byte[] concat(byte[]... parts) {
        int len = 0;
        for (byte[] p : parts) {
            len += p.length;
        }
        byte[] out = new byte[len];
        int pos = 0;
        for (byte[] p : parts) {
            System.arraycopy(p, 0, out, pos, p.length);
            pos += p.length;
        }
        return out;
    }
}
