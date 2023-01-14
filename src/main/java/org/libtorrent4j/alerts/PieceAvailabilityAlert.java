/*
 * Copyright (c) 2023, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j.alerts;

import org.libtorrent4j.Vectors;
import org.libtorrent4j.swig.int_vector;
import org.libtorrent4j.swig.piece_availability_alert;

/**
 * posted when torrent_handle::post_piece_availability() is called
 *
 * @author aldenml
 */
public final class PieceAvailabilityAlert extends TorrentAlert<piece_availability_alert> {

    PieceAvailabilityAlert(piece_availability_alert alert) {
        super(alert);
    }

    /**
     * info about pieces being downloaded for the torrent.
     */
    public int[] getPieceAvailability() {
        int_vector v = alert.getPiece_availability();
        return Vectors.int_vector2ints(v);
    }
}
