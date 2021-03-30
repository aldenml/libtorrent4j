/*
 * Copyright (c) 2018-2021, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.Operation;
import org.libtorrent4j.swig.file_error_alert;

/**
 * If the storage fails to read or write files that it needs access
 * to, this alert is generated and the torrent is paused.
 *
 * @author gubatron
 * @author aldenml
 */
public final class FileErrorAlert extends TorrentAlert<file_error_alert> {

    FileErrorAlert(file_error_alert alert) {
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
     * The file that experienced the error.
     *
     * @return te filename.
     */
    public String filename() {
        return alert.filename();
    }

    /**
     * Indicates which underlying operation caused the error.
     *
     * @return the operation.
     */
    public Operation operation() {
        return Operation.fromSwig(alert.getOp());
    }
}
