package org.libtorrent4j;

import org.libtorrent4j.swig.string_string_pair;
import org.libtorrent4j.swig.string_string_pair_vector;
import org.libtorrent4j.swig.web_seed_entry;

import java.util.ArrayList;

/**
 * The web_seed_entry holds information about a web seed (also known
 * as URL seed or HTTP seed). It is essentially a URL with some state
 * associated with it. For more information, see `BEP 17`_ and `BEP 19`_.
 *
 * @author gubatron
 * @author aldenml
 */
public final class WebSeedEntry {

    private final web_seed_entry e;

    public WebSeedEntry(web_seed_entry e) {
        this.e = e;
    }

    public web_seed_entry swig() {
        return e;
    }

    /**
     * The URL of the web seed.
     *
     *
     */
    public String url() {
        return e.getUrl();
    }

    /**
     * Optional authentication. If this is set, it's passed
     * in as HTTP basic auth to the web seed. The format is:
     * username:password.
     *
     *
     */
    public String auth() {
        return e.getAuth();
    }

    /**
     * Any extra HTTP headers that need to be passed to the web seed.
     *
     *
     */
    public ArrayList<Pair<String, String>> extraHeaders() {
        string_string_pair_vector v = e.getExtra_headers();
        int size = (int) v.size();

        ArrayList<Pair<String, String>> l = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            string_string_pair p = v.get(i);
            l.add(new Pair<>(p.getFirst(), p.getSecond()));
        }

        return l;
    }
}
