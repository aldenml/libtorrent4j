package org.libtorrent4j.alerts;

import org.libtorrent4j.AddTorrentParams;
import org.libtorrent4j.ErrorCode;
import org.libtorrent4j.swig.save_resume_data_alert;
import org.libtorrent4j.SessionHandle;

/**
 * This alert is generated as a response to a ``torrent_handle::save_resume_data`` request.
 * It is generated once the disk IO thread is done writing the state for this torrent.
 *
 * @author gubatron
 * @author aldenml
 */
public final class SaveResumeDataAlert extends TorrentAlert<save_resume_data_alert> {

    SaveResumeDataAlert(save_resume_data_alert alert) {
        super(alert);
    }

    /**
     * The {@code params} structure is populated with the fields to be passed to
     * {@link SessionHandle#addTorrent(AddTorrentParams, ErrorCode)}
     * or {@link SessionHandle#asyncAddTorrent(AddTorrentParams)}
     * to resume the torrent. To save the state to disk, you may pass it
     * on to {@code write_resume_data()}.
     *
     * @return the params object
     */
    public AddTorrentParams params() {
        return new AddTorrentParams(alert.getParams());
    }
}
