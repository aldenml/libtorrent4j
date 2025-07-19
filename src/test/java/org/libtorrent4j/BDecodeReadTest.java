/*
 * Copyright (c) 2018-2025, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.bdecode_node;
import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.error_code;
import org.libtorrent4j.swig.torrent_info;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author gubatron
 * @author aldenml
 */
public class BDecodeReadTest {

    @Test
    public void testRead() throws IOException {
        byte[] data = Utils.resourceBytes("test5.torrent");

        byte_vector buffer = Vectors.bytes2byte_vector(data);
        bdecode_node e = new bdecode_node();
        error_code ec = new error_code();
        int ret = bdecode_node.bdecode(buffer, e, ec);

        assertEquals("failed to decode torrent: " + ec.message(), ret, 0);

        ec.clear();
        torrent_info ti = torrent_info.create_torrent_info(e, ec);
        buffer.clear(); // prevents GC

        assertEquals("failed to create torrent info: " + ec.message(), ret, 0);
    }

    /**
     * To address <a href="https://github.com/aldenml/libtorrent4j/pull/244">Fix SIGSEGV in bdecode_node if the pointer is null</a>
     */
    @Test
    public void testReadNone() throws IOException {
        byte[] data = Utils.resourceBytes("test5.torrent");

        byte_vector buffer = Vectors.bytes2byte_vector(data);
        bdecode_node e = new bdecode_node();
        error_code ec = new error_code();
        int ret = bdecode_node.bdecode(buffer, e, ec);

        assertEquals("failed to decode torrent: " + ec.message(), ret, 0);

        bdecode_node n1 = e.dict_find_ex("info");
        assertEquals(n1.type(), bdecode_node.type_t.dict_t);
        // { 'length': , 'name': , 'piece length': , 'pieces': }
        assertEquals(n1.dict_size(), 4);

        bdecode_node n2 = e.dict_find_list_ex("any-key");
        assertEquals(n2.type(), bdecode_node.type_t.none_t);
        // if (n2.type() != bdecode_node.type_t.none_t)
        //    assertEquals(n2.list_size(), <size>);

        ec.clear();
        buffer.clear(); // prevents GC
    }
}
