/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.libtorrent;
import org.libtorrent4j.swig.stats_metric;
import org.libtorrent4j.swig.stats_metric_vector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gubatron
 * @author aldenml
 */
public final class LibTorrent {

    private LibTorrent() {
    }

    /**
     * The version string as reported by libtorrent
     *
     * @return the version string
     */
    public static String version() {
        return libtorrent.version();
    }

    /**
     * The git revision of libtorrent the native library is using.
     * <p>
     * This is not the internal revision libtorrent reports, since
     * that string is updated from time to time. This library can be
     * using an up to date revision, this string is manually
     * hardcoded in each version of libtorrent4j.
     *
     * @return the git revision
     */
    public static String revision() {
        return "d3216f63aeea558ed54c8bcb2dc9ab112db46577";
    }

    public static String boostVersion() {
        return libtorrent.boost_lib_version();
    }

    public static String opensslVersion() {
        return libtorrent.openssl_version_text();
    }

    /**
     * Version of libtorrent4j. It should match your maven
     * artifact version.
     *
     * @return libtorrent4j version.
     */
    public static String libtorrent4jVersion() {
        return "2.0.1-7";
    }

    /**
     * This free function returns the list of available metrics exposed by
     * libtorrent's statistics API. Each metric has a name and a *value index*.
     * The value index is the index into the array in session_stats_alert where
     * this metric's value can be found when the session stats is sampled (by
     * calling post_session_stats()).
     *
     * @return the list of all metrics
     */
    public static List<StatsMetric> sessionStatsMetrics() {
        stats_metric_vector v = libtorrent.session_stats_metrics();

        ArrayList<StatsMetric> l = new ArrayList<>(v.size());

        for (stats_metric m : v) {
            l.add(new StatsMetric(m));
        }

        return l;
    }

    /**
     * given a name of a metric, this function returns the counter index of it,
     * or -1 if it could not be found. The counter index is the index into the
     * values array returned by session_stats_alert.
     *
     * @param name the name of the metric
     * @return the index of the metric
     */
    public static int findMetricIdx(String name) {
        return libtorrent.find_metric_idx_ex(name);
    }

    /**
     * If the native library is an ARM architecture variant, returns true
     * if the running platform has NEON support.
     *
     * @return true if the running platform has NEON support
     */
    public static boolean hasArmNeonSupport() {
        return libtorrent.arm_neon_support();
    }
}
