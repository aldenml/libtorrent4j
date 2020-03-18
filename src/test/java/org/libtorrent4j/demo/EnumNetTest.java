package org.libtorrent4j.demo;

import org.libtorrent4j.EnumNet;
import org.libtorrent4j.swig.session;

import java.util.List;

/**
 * @author aldenml
 */
public final class EnumNetTest {

    public static void main(String[] args) {
        session s = new session();

        System.out.println("Enum routers");
        List<EnumNet.IpRoute> routes = EnumNet.enumRoutes(s);
        for (EnumNet.IpRoute route : routes) {
            System.out.println(route);
        }

        System.out.println("Enum interfaces");
        List<EnumNet.IpInterface> ipInterfaces = EnumNet.enumInterfaces(s);
        for (EnumNet.IpInterface iface : ipInterfaces) {
            System.out.println(iface);
            System.out.println("Gateway: " + EnumNet.getGateway(iface, routes));
        }

        System.out.println("Press ENTER to exit");
    }
}
