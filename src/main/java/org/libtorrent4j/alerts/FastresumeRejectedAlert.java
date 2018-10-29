package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.Operation;
import org.libtorrent4j.swig.fastresume_rejected_alert;

/**
 * This alert is generated when a fastresume file has been passed
 * to {@code addTorrent} but the files on disk did not match the
 * fastresume file. The {@link #error()} explains the reason why
 * the resume file was rejected.
 *
 * @author gubatron
 * @author aldenml
 */
public final class FastresumeRejectedAlert extends TorrentAlert<fastresume_rejected_alert> {

    FastresumeRejectedAlert(fastresume_rejected_alert alert) {
        super(alert);
    }

    public ErrorCode error() {
        return new ErrorCode(alert.getError());
    }

    /**
     * If the error happened to a specific file, this returns the path to it.
     *
     * @return the file path.
     */
    public String filePath() {
        return alert.file_path();
    }

    /**
     * If the error happened in a disk operation, a string with
     * the name of that operation.
     *
     * @return the operation.
     */
    public Operation operation() {
        return Operation.fromSwig(alert.getOp());
    }
}
