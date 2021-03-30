/*
 * Copyright (c) 2020-2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class SettingsPackTest {

    @Test
    public void testDefaultSettings() {
        SettingsPack settings = SettingsPack.defaultSettings();

        byte[] fingerprint = settings.getPeerFingerprint();

        String value = new String(fingerprint, 0, 8, StandardCharsets.US_ASCII);

        assertEquals("-LT2030-", value);
    }

    @Test
    public void testEnableDht() {
        SettingsPack settings = SettingsPack.defaultSettings();

        assertTrue(settings.isEnableDht());

        settings.setEnableDht(false);

        assertFalse(settings.isEnableDht());
    }

    @Test
    public void testEnableLsd() {
        SettingsPack settings = SettingsPack.defaultSettings();

        assertTrue(settings.isEnableLsd());

        settings.setEnableLsd(false);

        assertFalse(settings.isEnableLsd());
    }

    @Test
    public void testMaxMetadataSize() {
        SettingsPack settings = SettingsPack.defaultSettings();

        assertEquals(31457280, settings.getMaxMetadataSize());

        settings.setMaxMetadataSize(1);

        assertEquals(1, settings.getMaxMetadataSize());
    }
}
