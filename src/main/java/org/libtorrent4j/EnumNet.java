/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 *
 * Licensed under the MIT License.
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gubatron
 * @author aldenml
 */
public final class EnumNet {

    private EnumNet() {
    }

    public static List<IpInterface> enumInterfaces(session s) {
        ip_interface_vector v = libtorrent.enum_net_interfaces(s);
        int size = v.size();
        ArrayList<IpInterface> l = new ArrayList<>(size);

        for (ip_interface iface : v) {
            l.add(new IpInterface(iface));
        }

        return l;
    }

    public static List<IpRoute> enumRoutes(session s) {
        ip_route_vector v = libtorrent.enum_routes(s);
        int size = v.size();
        ArrayList<IpRoute> l = new ArrayList<>(size);

        for (ip_route ip_route : v) {
            l.add(new IpRoute(ip_route));
        }

        return l;
    }

    public static Address getGateway(IpInterface iface, List<IpRoute> routes) {
        ip_route_vector v = new ip_route_vector();
        for (IpRoute route : routes) {
            v.add(route.toSwig());
        }
        address addr = libtorrent.get_gateway(iface.toSwig(), v);
        return new Address(addr);
    }

    public static String deviceForAddress(session s, Address addr) {
        error_code ec = new error_code();
        String dev = libtorrent.device_for_address(s, addr.swig(), ec);
        if (ec.value() != 0) {
            throw new IllegalArgumentException(ec.message());
        }
        return dev;
    }

    public static final class IpInterface {

        private final Address interfaceAddress;
        private final Address netmask;
        private final String name;
        private final String friendlyName;
        private final String description;
        private final boolean preferred;

        IpInterface(ip_interface iface) {
            this.interfaceAddress = new Address(iface.getInterface_address());
            this.netmask = new Address(iface.getNetmask());
            this.name = Vectors.byte_vector2ascii(iface.getName());
            this.friendlyName = Vectors.byte_vector2ascii(iface.getFriendly_name());
            this.description = Vectors.byte_vector2ascii(iface.getDescription());
            this.preferred = iface.getPreferred();
        }

        public Address interfaceAddress() {
            return interfaceAddress;
        }

        public Address netmask() {
            return netmask;
        }

        public String name() {
            return name;
        }

        public String friendlyName() {
            return friendlyName;
        }

        public String description() {
            return description;
        }

        public boolean preferred() {
            return preferred;
        }

        public ip_interface toSwig() {
            ip_interface r = new ip_interface();
            r.setInterface_address(interfaceAddress.swig());
            r.setNetmask(netmask.swig());
            r.setName(Vectors.ascii2byte_vector(name));
            r.setFriendly_name(Vectors.ascii2byte_vector(friendlyName));
            r.setDescription(Vectors.ascii2byte_vector(description));
            r.setPreferred(preferred);
            return r;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("address: ").append(interfaceAddress);
            sb.append(", netmask: ").append(netmask);
            sb.append(", name: ").append(name);
            sb.append(", friendlyName: ").append(friendlyName);
            sb.append(", description: ").append(description);
            sb.append(", preferred: ").append(preferred);

            return sb.toString();
        }
    }

    public static final class IpRoute {

        private final Address destination;
        private final Address netmask;
        private final Address gateway;
        private final Address sourceHint;
        private final String name;
        private final int mtu;

        IpRoute(ip_route route) {
            this.destination = new Address(route.getDestination());
            this.netmask = new Address(route.getNetmask());
            this.gateway = new Address(route.getGateway());
            this.sourceHint = new Address(route.getSource_hint());
            this.name = Vectors.byte_vector2ascii(route.getName());
            this.mtu = route.getMtu();
        }

        public Address destination() {
            return destination;
        }

        public Address netmask() {
            return netmask;
        }

        public Address gateway() {
            return gateway;
        }

        public Address sourceHint() {
            return sourceHint;
        }

        public String name() {
            return name;
        }

        public int mtu() {
            return mtu;
        }

        public ip_route toSwig() {
            ip_route r = new ip_route();
            r.setDestination(destination.swig());
            r.setNetmask(netmask.swig());
            r.setGateway(gateway.swig());
            r.setSource_hint(sourceHint.swig());
            r.setName(Vectors.ascii2byte_vector(name));
            r.setMtu(mtu);
            return r;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("destination: ").append(destination);
            sb.append(", netmask: ").append(netmask);
            sb.append(", gateway: ").append(gateway);
            sb.append(", name: ").append(name);
            sb.append(", mtu: ").append(mtu);

            return sb.toString();
        }
    }
}
