package org.libtorrent4j.alerts;

import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.swig.metadata_failed_alert;

/**
 * This alert is generated when the metadata has been completely received and the info-hash
 * failed to match it. i.e. the metadata that was received was corrupt. libtorrent will
 * automatically retry to fetch it in this case. This is only relevant when running a
 * torrent-less download, with the metadata extension provided by libtorrent.
 *
 * @author gubatron
 * @author aldenml
 */
public final class MetadataFailedAlert extends TorrentAlert<metadata_failed_alert> {

    MetadataFailedAlert(metadata_failed_alert alert) {
        super(alert);
    }

    /**
     * The error that occurred.
     *
     *
     */
    public ErrorCode getError() {
        return new ErrorCode(alert.getError());
    }
}
