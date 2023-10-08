/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class int_bitfield_map extends java.util.AbstractMap<Integer, bitfield> {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected int_bitfield_map(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(int_bitfield_map obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(int_bitfield_map obj) {
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

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_int_bitfield_map(swigCPtr);
      }
      swigCPtr = 0;
    }
  }


  public int size() {
    return sizeImpl();
  }

  public boolean containsKey(java.lang.Object key) {
    if (!(key instanceof Integer)) {
      return false;
    }

    return containsImpl((Integer)key);
  }

  public bitfield get(java.lang.Object key) {
    if (!(key instanceof Integer)) {
      return null;
    }

    Iterator itr = find((Integer) key);
    if (itr.isNot(end())) {
      return itr.getValue();
    }

    return null;
  }

  public bitfield put(Integer key, bitfield value) {
    Iterator itr = find((Integer) key);
    if (itr.isNot(end())) {
      bitfield oldValue = itr.getValue();
      itr.setValue(value);
      return oldValue;
    } else {
      putUnchecked(key, value);
      return null;
    }
  }

  public bitfield remove(java.lang.Object key) {
    if (!(key instanceof Integer)) {
      return null;
    }

    Iterator itr = find((Integer) key);
    if (itr.isNot(end())) {
      bitfield oldValue = itr.getValue();
      removeUnchecked(itr);
      return oldValue;
    } else {
      return null;
    }
  }

  public java.util.Set<Entry<Integer, bitfield>> entrySet() {
    java.util.Set<Entry<Integer, bitfield>> setToReturn =
        new java.util.HashSet<Entry<Integer, bitfield>>();

    Iterator itr = begin();
    final Iterator end = end();
    while (itr.isNot(end)) {
      setToReturn.add(new Entry<Integer, bitfield>() {
        private Iterator iterator;

        private Entry<Integer, bitfield> init(Iterator iterator) {
          this.iterator = iterator;
          return this;
        }

        public Integer getKey() {
          return iterator.getKey();
        }

        public bitfield getValue() {
          return iterator.getValue();
        }

        public bitfield setValue(bitfield newValue) {
          bitfield oldValue = iterator.getValue();
          iterator.setValue(newValue);
          return oldValue;
        }
      }.init(itr));
      itr = itr.getNextUnchecked();
    }

    return setToReturn;
  }

  public int_bitfield_map() {
    this(libtorrent_jni.new_int_bitfield_map__SWIG_0(), true);
  }

  public int_bitfield_map(int_bitfield_map other) {
    this(libtorrent_jni.new_int_bitfield_map__SWIG_1(int_bitfield_map.getCPtr(other), other), true);
  }

  static protected class Iterator {
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
  
    @SuppressWarnings("deprecation")
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libtorrent_jni.delete_int_bitfield_map_Iterator(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    private int_bitfield_map.Iterator getNextUnchecked() {
      return new int_bitfield_map.Iterator(libtorrent_jni.int_bitfield_map_Iterator_getNextUnchecked(swigCPtr, this), true);
    }
  
    private boolean isNot(int_bitfield_map.Iterator other) {
      return libtorrent_jni.int_bitfield_map_Iterator_isNot(swigCPtr, this, int_bitfield_map.Iterator.getCPtr(other), other);
    }
  
    private int getKey() {
      return libtorrent_jni.int_bitfield_map_Iterator_getKey(swigCPtr, this);
    }
  
    private bitfield getValue() {
      return new bitfield(libtorrent_jni.int_bitfield_map_Iterator_getValue(swigCPtr, this), true);
    }
  
    private void setValue(bitfield newValue) {
      libtorrent_jni.int_bitfield_map_Iterator_setValue(swigCPtr, this, bitfield.getCPtr(newValue), newValue);
    }
  
  }

  public boolean isEmpty() {
    return libtorrent_jni.int_bitfield_map_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.int_bitfield_map_clear(swigCPtr, this);
  }

  private int_bitfield_map.Iterator find(int key) {
    return new int_bitfield_map.Iterator(libtorrent_jni.int_bitfield_map_find(swigCPtr, this, key), true);
  }

  private int_bitfield_map.Iterator begin() {
    return new int_bitfield_map.Iterator(libtorrent_jni.int_bitfield_map_begin(swigCPtr, this), true);
  }

  private int_bitfield_map.Iterator end() {
    return new int_bitfield_map.Iterator(libtorrent_jni.int_bitfield_map_end(swigCPtr, this), true);
  }

  private int sizeImpl() {
    return libtorrent_jni.int_bitfield_map_sizeImpl(swigCPtr, this);
  }

  private boolean containsImpl(int key) {
    return libtorrent_jni.int_bitfield_map_containsImpl(swigCPtr, this, key);
  }

  private void putUnchecked(int key, bitfield value) {
    libtorrent_jni.int_bitfield_map_putUnchecked(swigCPtr, this, key, bitfield.getCPtr(value), value);
  }

  private void removeUnchecked(int_bitfield_map.Iterator itr) {
    libtorrent_jni.int_bitfield_map_removeUnchecked(swigCPtr, this, int_bitfield_map.Iterator.getCPtr(itr), itr);
  }

}
