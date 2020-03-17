package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.file_renamed_alert;
import org.libtorrent4j.TorrentHandle;

/**
 * This is posted as a response to a {@link TorrentHandle#renameFile(int, String)}, if the rename
 * operation succeeds.
 *
 * @author gubatron
 * @author aldenml
 */
public final class FileRenamedAlert extends TorrentAlert<file_renamed_alert> {

    public FileRenamedAlert(file_renamed_alert alert) {
        super(alert);
    }

    public String newName() {
        return alert.new_name();
    }

    /**
     * Refers to the index of the file that was renamed.
     *
     *
     */
    public int index() {
        return alert.getIndex();
    }
}
