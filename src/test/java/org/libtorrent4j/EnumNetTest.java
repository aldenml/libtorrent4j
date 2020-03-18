package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.session;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void testEnumRoutes() {
        session s = new session();
        List<EnumNet.IpRoute> routes = EnumNet.enumRoutes(s);
        assertFalse(routes.isEmpty());
    }

    @Test
    public void testGetGateway() {
        session s = new session();
        List<EnumNet.IpInterface> ifaces = EnumNet.enumInterfaces(s);
        List<EnumNet.IpRoute> routes = EnumNet.enumRoutes(s);

        for (EnumNet.IpInterface iface : ifaces) {
            Address addr = EnumNet.getGateway(iface, routes);
            assertNotNull(addr);
        }
    }

    @Test
    public void testDeviceForAddress() {
        session s = new session();
        List<EnumNet.IpInterface> ifaces = EnumNet.enumInterfaces(s);

        for (EnumNet.IpInterface iface : ifaces) {
            String dev = EnumNet.deviceForAddress(s, iface.interfaceAddress());
            assertNotNull(dev);
        }
    }
}
