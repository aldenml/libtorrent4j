/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.swig;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class SessionParamsTest {

    @Test
    public void testReadWriteSessionParams() {
        settings_pack sp = new settings_pack();
        sp.set_str(settings_pack.string_types.peer_fingerprint.swigValue(), "test");
        session_params params = new session_params(sp);

        entry e1 = session_params.write_session_params(params);
        bdecode_node n = new bdecode_node();
        error_code ec = new error_code();
        bdecode_node.bdecode(e1.bencode(), n, ec);
        session_params p1 = session_params.read_session_params(n);
        byte_vector buf = session_params.write_session_params_buf(p1);
        entry e2 = entry.bdecode(buf);

        assertEquals(e1.to_string(), e2.to_string());
    }
}
