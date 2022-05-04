/*
 * Copyright (c) 2022, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.oversized_file_alert;

/**
 * This alert may be posted when the initial checking of resume data and files
 * on disk (just existence, not piece hashes) completes. If a file belonging
 * to the torrent is found on disk, but is larger than the file in the
 * torrent, that's when this alert is posted.
 * <p>
 * The client may want to call truncate_files() in that case, or perhaps
 * interpret it as a sign that some other file is in the way, that shouldn't
 * be overwritten.
 *
 * @author aldenml
 */
public final class OversizedFileAlert extends TorrentAlert<oversized_file_alert> {

    OversizedFileAlert(oversized_file_alert alert) {
        super(alert);
    }
}
