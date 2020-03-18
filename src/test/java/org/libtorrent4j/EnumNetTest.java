package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.session;

import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * @author aldenml
 */
public class EnumNetTest {

    @Test
    public void testEnumInterfaces() {
        session s = new session();
        List<EnumNet.IpInterface> ifaces = EnumNet.enumInterfaces(s);
        assertFalse(ifaces.isEmpty());
    }
}
