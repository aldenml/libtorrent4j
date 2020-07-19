/*
 * Copyright (c) 2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class SessionParamsTest {

    @Test
    public void testSetSettings() {
        SessionParams params = new SessionParams();

        SettingsPack settings = new SettingsPack();
        settings.setPeerFingerprint("test".getBytes(StandardCharsets.US_ASCII));

        params.setSettings(settings);

        settings = params.getSettings();

        byte[] fingerprint = settings.getPeerFingerprint();

        String value = new String(fingerprint, 0, 4, StandardCharsets.US_ASCII);

        assertEquals("test", value);
    }
}
