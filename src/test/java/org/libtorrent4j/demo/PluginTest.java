package org.libtorrent4j.demo;

import org.libtorrent4j.alerts.Alert;
import org.libtorrent4j.*;

/**
 * @author gubatron
 * @author aldenml
 */
public final class PluginTest {

    public static void main(String[] args) throws Throwable {

        SessionManager s = new SessionManager();

        s.addListener(new AlertListener() {
            @Override
            public int[] types() {
                return null;
            }

            @Override
            public void alert(Alert<?> alert) {
                System.out.println(alert);
            }
        });

        s.start();

        SessionHandle h = new SessionHandle(s.swig());
        h.addExtension(new Plugin() {
            @Override
            public boolean onDhtRequest(String query, UdpEndpoint source, BDecodeNode message, Entry response) {
                System.out.println("DHT MSG: " + query + ", from: " + source);
                return false;
            }
        });

        System.out.println("Press ENTER to exit");
        System.in.read();

        s.stop();
    }
}
