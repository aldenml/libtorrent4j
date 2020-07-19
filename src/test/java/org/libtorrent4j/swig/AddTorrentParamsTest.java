/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.swig;

import org.junit.Test;

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
}
