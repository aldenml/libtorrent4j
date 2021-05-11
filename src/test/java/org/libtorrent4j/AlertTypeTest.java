/*
 * Copyright (c) 2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.alerts.AlertType;
import org.libtorrent4j.swig.file_prio_alert;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class AlertTypeTest {

    @Test
    public void testFromSwig() {

        assertEquals(AlertType.FILE_PRIO, AlertType.fromSwig(file_prio_alert.alert_type));
    }
}
