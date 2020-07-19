/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.session_params;

/**
 * This is a parameters pack for configuring the session
 * before it's started.
 *
 * @author aldenml
 */
public final class SessionParams
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
     * The settings to configure the session with.
     *
     * @return the settings pack
     */
    public SettingsPack getSettings() {
        return new SettingsPack(h.getSettings());
    }

    /**
     * The settings to configure the session with.
     *
     * @param settings the settings pack
     */
    public void setSettings(SettingsPack settings) {
        h.setSettings(settings.swig());
    }
}
