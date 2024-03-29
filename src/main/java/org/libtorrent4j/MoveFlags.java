package org.libtorrent4j;

import org.libtorrent4j.swig.move_flags_t;

/**
 * Flags for asynchronous move of a torrent handle storage.
 *
 * @author gubatron
 * @author aldenml
 * @see TorrentHandle#moveStorage(String, MoveFlags)
 */
public enum MoveFlags {

    /**
     * Replace any files in the destination when copying
     * or moving the storage.
     */
    ALWAYS_REPLACE_FILES(move_flags_t.always_replace_files),

    /**
     * If any files that we want to copy exist in the destination,
     * fail the whole operation and don't perform
     * any copy or move. There is an inherent race condition
     * in this mode. The files are checked for existence before
     * the operation starts. In between the check and performing
     * the copy, the destination files may be created, in which
     * case they are replaced.
     */
    FAIL_IF_EXIST(move_flags_t.fail_if_exist),

    /**
     * If any files exist in the target, take those files instead
     * of the ones we may have in the source.
     */
    DONT_REPLACE(move_flags_t.dont_replace),

    /**
     * Don't move any source files, just forget about them
     * and begin checking files at new save path.
     */
    RESET_SAVE_PATH(move_flags_t.reset_save_path),

    /**
     * Don't move any source files, just change save path
     * and continue working without any checks.
     */
    RESET_SAVE_PATH_UNCHECKED(move_flags_t.reset_save_path_unchecked);

    MoveFlags(move_flags_t swigValue) {
        this.swigValue = swigValue;
    }

    private final move_flags_t swigValue;

    /**
     * @return the native value
     */
    public move_flags_t swig() {
        return swigValue;
    }

    /**
     * @param swigValue the native value
     */
    public static MoveFlags fromSwig(move_flags_t swigValue) {
        MoveFlags[] enumValues = MoveFlags.class.getEnumConstants();
        for (MoveFlags ev : enumValues) {
            if (ev.swig() == swigValue) {
                return ev;
            }
        }
        throw new IllegalArgumentException("Enum value not supported");
    }
}
