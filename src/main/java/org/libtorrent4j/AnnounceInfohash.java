package org.libtorrent4j;

import org.libtorrent4j.swig.announce_infohash;

/**
 * @author aldenml
 */
public final class AnnounceInfohash
    extends SwigObject<announce_infohash> {

    public AnnounceInfohash(announce_infohash infohash) {
        super(infohash);
    }

    /**
     * If this tracker has returned an error or warning message
     * that message is stored here.
     *
     * @return the error or warning message
     */
    public String message() {
        return h.getMessage();
    }

    /**
     * The number of times in a row we have failed to announce to this
     * tracker.
     *
     * @return number of announce fails
     */
    public short fails() {
        return h.getFails();
    }

    /**
     * Returns true while we're waiting for a response from the tracker.
     *
     * @return true if waiting
     */
    public boolean updating() {
        return h.getUpdating();
    }

    /**
     * Returns true if the last time we tried to announce to this
     * tracker succeeded, or if we haven't tried yet.
     */
    public boolean isWorking() {
        return h.getFails() == 0;
    }
}
