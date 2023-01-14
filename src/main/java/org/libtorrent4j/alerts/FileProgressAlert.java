/*
 * Copyright (c) 2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.Vectors;
import org.libtorrent4j.swig.file_progress_alert;
import org.libtorrent4j.swig.int64_vector;

/**
 * posted when torrent_handle::post_file_progress() is called
 *
 * @author aldenml
 */
public final class FileProgressAlert extends TorrentAlert<file_progress_alert> {

    FileProgressAlert(file_progress_alert alert) {
        super(alert);
    }

    /**
     * the list of the files in the torrent
     */
    public long[] getFiles() {
        int64_vector v = alert.get_files();
        return Vectors.int64_vector2longs(v);
    }
}
