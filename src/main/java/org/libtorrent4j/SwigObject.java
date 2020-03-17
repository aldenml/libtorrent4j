package org.libtorrent4j;

/**
 * Represents an object that it is wrapper of a native
 * one.
 *
 * @author aldenml
 */
public class SwigObject<T> {

    // the native object handler
    protected T swig;

    /**
     * @param swig the native object handler
     */
    public SwigObject(T swig) {
        this.swig = swig;
    }

    /**
     * Returns a reference to the native object handler
     */
    public T swig() {
        return swig;
    }
}
