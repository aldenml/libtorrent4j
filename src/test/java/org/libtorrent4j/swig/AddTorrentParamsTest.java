/*
 * Copyright (c) 2018-2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.swig;

import org.junit.Test;
import org.libtorrent4j.Utils;
import org.libtorrent4j.Vectors;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class AddTorrentParamsTest {

    @Test
    public void testEmptyFilePriorities() {
        add_torrent_params params = new add_torrent_params();

        byte_vector empty = params.get_file_priorities();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testSetFilePriorities() {
        add_torrent_params params = new add_torrent_params();

        byte_vector p = new byte_vector(4, (byte) 3);

        params.set_file_priorities(p);

        assertEquals(p, params.get_file_priorities());
    }

    @Test
    public void testEmptyPiecePriorities() {
        add_torrent_params params = new add_torrent_params();

        byte_vector empty = params.get_piece_priorities();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testSetPiecePriorities() {
        add_torrent_params params = new add_torrent_params();

        byte_vector p = new byte_vector(4, (byte) 3);

        params.set_piece_priorities(p);

        assertEquals(p, params.get_piece_priorities());
    }

    @Test
    public void testEmptyMerkleTrees() {
        add_torrent_params params = new add_torrent_params();

        sha256_hash_vector_vector trees = params.get_merkle_trees();
        assertTrue(trees.isEmpty());
    }

    @Test
    public void testSetMerkleTrees() {
        add_torrent_params params = new add_torrent_params();

        sha256_hash_vector_vector trees = new sha256_hash_vector_vector();
        sha256_hash_vector v = new sha256_hash_vector();
        sha256_hash hash = sha256_hash.from_hex("c7615aa7ed5c23f60141a1b8ade0ef17719dcbac3bf07ee496ffee024e3208a6");
        v.add(sha256_hash.min());
        v.add(sha256_hash.max());
        v.add(2, hash);
        trees.add(new sha256_hash_vector());
        trees.add(1, v);

        params.set_merkle_trees(trees);

        sha256_hash_vector_vector rt = params.get_merkle_trees();
        assertTrue(hash.eq(rt.get(1).get(2)));
    }

    @Test
    public void testSetHavePieces() {
        add_torrent_params params = new add_torrent_params();

        bitfield bf = new bitfield(8);
        bf.set_bit(5);

        params.set_have_pieces(bf);
        bitfield r = params.get_have_pieces();

        assertTrue(r.get_bit(5));
    }

    @Test
    public void testDefaultName() {
        add_torrent_params params = new add_torrent_params();

        assertEquals("", params.getName());
    }

    @Test
    public void testLoadTorrentFromBuffer() throws IOException {
        byte[] bytes = Utils.resourceBytes("Honey_Larochelle_Hijack_FrostClick_FrostWire_MP3_May_06_2016.torrent");
        error_code ec = new error_code();
        byte_vector buffer = Vectors.bytes2byte_vector(bytes);
        add_torrent_params params = add_torrent_params.load_torrent_buffer(buffer, ec);
        assertEquals("83e37aea34581ce105af93c0955e7c7d4194ae47", params.getInfo_hashes().getV1().to_hex());
        assertEquals(0, ec.value());
    }

    @Test
    public void testLoadTorrentFromNativeBuffer() throws IOException {
        byte[] bytes = Utils.resourceBytes("Honey_Larochelle_Hijack_FrostClick_FrostWire_MP3_May_06_2016.torrent");
        ByteBuffer bb = ByteBuffer.allocateDirect(bytes.length);
        bb.put(bytes);
        bb.position(0);

        long ptr = libtorrent_jni.directBufferAddress(bb);
        long size = libtorrent_jni.directBufferCapacity(bb);

        error_code ec = new error_code();
        add_torrent_params params = add_torrent_params.load_torrent_native_buffer(ptr, (int) size, ec);
        assertEquals("83e37aea34581ce105af93c0955e7c7d4194ae47", params.getInfo_hashes().getV1().to_hex());
        assertEquals(0, ec.value());
    }
}
