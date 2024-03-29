/*
 * Copyright (c) 2018-2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.bdecode_node;
import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.error_code;

/**
 * @author gubatron
 * @author aldenml
 */
public final class BDecodeNode {

    private final bdecode_node n;
    private final byte_vector buffer;

    /**
     * @param n the native object
     */
    public BDecodeNode(bdecode_node n) {
        this(n, null);
    }

    /**
     * Used to keep the buffer reference around.
     *
     * @param n      the native object
     * @param buffer the buffer backing up the native object
     */
    public BDecodeNode(bdecode_node n, byte_vector buffer) {
        this.n = n;
        this.buffer = buffer;
    }

    /**
     * @return the native object
     */
    public bdecode_node swig() {
        return n;
    }

    /**
     * This method returns the internal buffer or null
     * if it was constructed without one.
     * <p>
     * This also prevent premature garbage collection in case
     * the node was created from a constructed buffer.
     *
     * @return the pinned buffer
     */
    public byte_vector buffer() {
        return buffer;
    }

    /**
     * A JSON style string representation
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return bdecode_node.to_string(n, false, 2);
    }

    public static BDecodeNode bdecode(byte[] data) {
        byte_vector buffer = Vectors.bytes2byte_vector(data);
        bdecode_node n = new bdecode_node();
        error_code ec = new error_code();
        int ret = bdecode_node.bdecode(buffer, n, ec);

        if (ret == 0) {
            return new BDecodeNode(n, buffer);
        } else {
            throw new IllegalArgumentException("Can't decode data: " + ec.message());
        }
    }
}
