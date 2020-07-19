/*
 * Copyright (c) 2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.settings_pack;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class SettingsPackTest {

    @Test
    public void testDefaultSettings() {
        SettingsPack settings = SettingsPack.defaultSettings();

        byte[] fingerprint = settings.getPeerFingerprint();

        String value = new String(fingerprint, 0, 8, StandardCharsets.US_ASCII);

        assertEquals("-LT2000-", value);
    }
}
