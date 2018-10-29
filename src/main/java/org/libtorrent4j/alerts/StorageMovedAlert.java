package org.libtorrent4j.alerts;

import org.libtorrent4j.swig.storage_moved_alert;
import org.libtorrent4j.TorrentHandle;

/**
 * This alert is generated when all the disk IO has completed and the
 * files have been moved, as an effect of a call to {@link TorrentHandle#moveStorage}. This
 * is useful to synchronize with the actual disk. The {@link #storagePath()} member is the new path of
 * the storage.
 *
 * @author gubatron
 * @author aldenml
 */
public final class StorageMovedAlert extends TorrentAlert<storage_moved_alert> {

    public StorageMovedAlert(storage_moved_alert alert) {
        super(alert);
    }

    public String storagePath() {
        return alert.storage_path();
    }
}
