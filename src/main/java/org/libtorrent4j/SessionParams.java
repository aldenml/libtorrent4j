package org.libtorrent4j;

import org.libtorrent4j.swig.session_params;

/**
 * This is a parameters pack for configuring the session
 * before it's started.
 *
 * @author aldenml
 */
public class SessionParams
    extends SwigObject<session_params> {

    /**
     * @param p the native object
     */
    public SessionParams(session_params p) {
        super(p);
    }

    /**
     * This constructor can be used to start with the default plugins
     * (ut_metadata, ut_pex and smart_ban). The default values in the
     * settings is to start the default features like upnp, nat-pmp,
     * and dht for example.
     */
    public SessionParams() {
        this(new session_params());
    }

    /**
     * This constructor can be used to start with the default plugins
     * (ut_metadata, ut_pex and smart_ban). The default values in the
     * settings is to start the default features like upnp, nat-pmp,
     * and dht for example.
     *
     * @param settings the initial settings pack
     */
    public SessionParams(SettingsPack settings) {
        this(new session_params(settings.swig()));
    }

    /**
     * @return the settings pack
     */
    public SettingsPack settings() {
        return new SettingsPack(swig.getSettings());
    }
}
