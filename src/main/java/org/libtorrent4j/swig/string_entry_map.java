/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class string_entry_map extends java.util.AbstractMap<String, entry> {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected string_entry_map(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(string_entry_map obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(string_entry_map obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings({"deprecation", "removal"})
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_string_entry_map(swigCPtr);
      }
      swigCPtr = 0;
    }
  }


  public int size() {
    return sizeImpl();
  }

  public boolean containsKey(java.lang.Object key) {
    if (!(key instanceof String)) {
      return false;
    }

    return containsImpl((String)key);
  }

  public entry get(java.lang.Object key) {
    if (!(key instanceof String)) {
      return null;
    }

    Iterator itr = find((String) key);
    if (itr.isNot(end())) {
      return itr.getValue();
    }

    return null;
  }

  public entry put(String key, entry value) {
    Iterator itr = find(key);
    if (itr.isNot(end())) {
      entry oldValue = itr.getValue();
      itr.setValue(value);
      return oldValue;
    } else {
      putUnchecked(key, value);
      return null;
    }
  }

  public entry remove(java.lang.Object key) {
    if (!(key instanceof String)) {
      return null;
    }

    Iterator itr = find((String) key);
    if (itr.isNot(end())) {
      entry oldValue = itr.getValue();
      removeUnchecked(itr);
      return oldValue;
    } else {
      return null;
    }
  }

  public java.util.Set<Entry<String, entry>> entrySet() {
    java.util.Set<Entry<String, entry>> setToReturn =
        new java.util.HashSet<Entry<String, entry>>();

    Iterator itr = begin();
    final Iterator end = end();
    while (itr.isNot(end)) {
      setToReturn.add(new Entry<String, entry>() {
        private Iterator iterator;

        private Entry<String, entry> init(Iterator iterator) {
          this.iterator = iterator;
          return this;
        }

        public String getKey() {
          return iterator.getKey();
        }

        public entry getValue() {
          return iterator.getValue();
        }

        public entry setValue(entry newValue) {
          entry oldValue = iterator.getValue();
          iterator.setValue(newValue);
          return oldValue;
        }
      }.init(itr));
      itr = itr.getNextUnchecked();
    }

    return setToReturn;
  }

  public string_entry_map() {
    this(libtorrent_jni.new_string_entry_map__SWIG_0(), true);
  }

  public string_entry_map(string_entry_map other) {
    this(libtorrent_jni.new_string_entry_map__SWIG_1(string_entry_map.getCPtr(other), other), true);
  }

  static public class Iterator {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;
  
    protected Iterator(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(Iterator obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected static long swigRelease(Iterator obj) {
      long ptr = 0;
      if (obj != null) {
        if (!obj.swigCMemOwn)
          throw new RuntimeException("Cannot release ownership as memory is not owned");
        ptr = obj.swigCPtr;
        obj.swigCMemOwn = false;
        obj.delete();
      }
      return ptr;
    }
  
    @SuppressWarnings({"deprecation", "removal"})
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libtorrent_jni.delete_string_entry_map_Iterator(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    private string_entry_map.Iterator getNextUnchecked() {
      return new string_entry_map.Iterator(libtorrent_jni.string_entry_map_Iterator_getNextUnchecked(swigCPtr, this), true);
    }
  
    private boolean isNot(string_entry_map.Iterator other) {
      return libtorrent_jni.string_entry_map_Iterator_isNot(swigCPtr, this, string_entry_map.Iterator.getCPtr(other), other);
    }
  
    private String getKey() {
      return libtorrent_jni.string_entry_map_Iterator_getKey(swigCPtr, this);
    }
  
    private entry getValue() {
      return new entry(libtorrent_jni.string_entry_map_Iterator_getValue(swigCPtr, this), true);
    }
  
    private void setValue(entry newValue) {
      libtorrent_jni.string_entry_map_Iterator_setValue(swigCPtr, this, entry.getCPtr(newValue), newValue);
    }
  
  }

  public boolean isEmpty() {
    return libtorrent_jni.string_entry_map_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.string_entry_map_clear(swigCPtr, this);
  }

  private string_entry_map.Iterator find(String key) {
    return new string_entry_map.Iterator(libtorrent_jni.string_entry_map_find(swigCPtr, this, key), true);
  }

  private string_entry_map.Iterator begin() {
    return new string_entry_map.Iterator(libtorrent_jni.string_entry_map_begin(swigCPtr, this), true);
  }

  private string_entry_map.Iterator end() {
    return new string_entry_map.Iterator(libtorrent_jni.string_entry_map_end(swigCPtr, this), true);
  }

  private int sizeImpl() {
    return libtorrent_jni.string_entry_map_sizeImpl(swigCPtr, this);
  }

  private boolean containsImpl(String key) {
    return libtorrent_jni.string_entry_map_containsImpl(swigCPtr, this, key);
  }

  private void putUnchecked(String key, entry value) {
    libtorrent_jni.string_entry_map_putUnchecked(swigCPtr, this, key, entry.getCPtr(value), value);
  }

  private void removeUnchecked(string_entry_map.Iterator itr) {
    libtorrent_jni.string_entry_map_removeUnchecked(swigCPtr, this, string_entry_map.Iterator.getCPtr(itr), itr);
  }

}
