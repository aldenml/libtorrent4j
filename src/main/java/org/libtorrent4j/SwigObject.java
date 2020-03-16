package org.libtorrent4j;

/**
 * Represents an object that it is wrapper of a native
 * one.
 *
 * @author aldenml
 */
public class SwigObject<T> {

    protected T swig;

    public SwigObject(T swig) {
        this.swig = swig;
    }

    public T swig() {
        return swig;
    }
}
