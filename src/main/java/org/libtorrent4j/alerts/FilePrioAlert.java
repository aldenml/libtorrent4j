/*
 * Copyright (c) 2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.Operation;
import org.libtorrent4j.TorrentHandle;
import org.libtorrent4j.swig.file_prio_alert;

/**
 * Posted when a {@link TorrentHandle#prioritizeFiles} or
 * {@link TorrentHandle#filePriority} update of the file
 * priorities complete, which requires a round-trip to the disk
 * thread.
 * <p>
 * If the disk operation fails this alert won't be posted, but a
 * {@link FileErrorAlert} is posted instead, and the torrent is stopped.
 *
 * @author aldenml
 */
public class FilePrioAlert extends TorrentAlert<file_prio_alert> {

    FilePrioAlert(file_prio_alert alert) {
        super(alert);
    }

    /**
     * The error code describing the error.
     *
     * @return the error.
     */
    public ErrorCode error() {
        return new ErrorCode(alert.getError());
    }

    /**
     * Indicates which underlying operation that failed.
     *
     * @return the operation.
     */
    public Operation operation() {
        return Operation.fromSwig(alert.getOp());
    }
}
