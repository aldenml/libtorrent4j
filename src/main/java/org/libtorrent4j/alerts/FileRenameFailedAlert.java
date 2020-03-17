package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.swig.file_rename_failed_alert;

/**
 * This is posted as a response to a torrent_handle::rename_file() call, if the rename
 * operation failed.
 *
 * @author gubatron
 * @author aldenml
 */
public final class FileRenameFailedAlert extends TorrentAlert<file_rename_failed_alert> {

    public FileRenameFailedAlert(file_rename_failed_alert alert) {
        super(alert);
    }

    /**
     * refers to the index of the file that was supposed to be renamed.
     *
     *
     */
    public int getIndex() {
        return alert.getIndex();
    }

    /**
     * is the error code returned from the filesystem.
     *
     *
     */
    public ErrorCode getError() {
        return new ErrorCode(alert.getError());
    }
}
