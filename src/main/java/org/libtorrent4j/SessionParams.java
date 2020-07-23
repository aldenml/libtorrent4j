/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.bdecode_node;
import org.libtorrent4j.swig.byte_vector;
import org.libtorrent4j.swig.error_code;
import org.libtorrent4j.swig.session_params;

import java.io.File;
import java.io.IOException;

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

    public SessionParams(File data) {
        this(bdecode0(data));
    }

    public SessionParams(byte[] data) {
        this(bdecode0(data));
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

    private static session_params bdecode0(File file) {
        try {
            byte[] data = Files.bytes(file);
            return bdecode0(data);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't decode data from file: " + file, e);
        }
    }

    private static session_params bdecode0(byte[] data) {
        byte_vector buffer = Vectors.bytes2byte_vector(data);
        bdecode_node n = new bdecode_node();
        error_code ec = new error_code();
        int ret = bdecode_node.bdecode(buffer, n, ec);

        if (ret == 0) {
            session_params params = session_params.read_session_params(n);
            buffer.clear(); // prevents GC
            return params;
        } else {
            throw new IllegalArgumentException("Can't decode data: " + ec.message());
        }
    }
}
