package org.libtorrent4j.demo;

import org.libtorrent4j.LibTorrent;
import org.libtorrent4j.StatsMetric;

/**
 * @author gubatron
 * @author aldenml
 */
public final class PrintMetrics {

    public static void main(String[] args) throws Throwable {

        for (StatsMetric m : LibTorrent.sessionStatsMetrics()) {
            System.out.println(m);
        }
    }
}
