/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class bdecode_node {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected bdecode_node(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(bdecode_node obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(bdecode_node obj) {
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
        libtorrent_jni.delete_bdecode_node(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public bdecode_node() {
    this(libtorrent_jni.new_bdecode_node__SWIG_0(), true);
  }

  public bdecode_node(bdecode_node arg0) {
    this(libtorrent_jni.new_bdecode_node__SWIG_1(bdecode_node.getCPtr(arg0), arg0), true);
  }

  public bdecode_node.type_t type() {
    return bdecode_node.type_t.swigToEnum(libtorrent_jni.bdecode_node_type(swigCPtr, this));
  }

  public boolean to_bool() {
    return libtorrent_jni.bdecode_node_to_bool(swigCPtr, this);
  }

  public long data_offset() {
    return libtorrent_jni.bdecode_node_data_offset(swigCPtr, this);
  }

  public bdecode_node list_at(int i) {
    return new bdecode_node(libtorrent_jni.bdecode_node_list_at(swigCPtr, this, i), true);
  }

  public long list_int_value_at(int i, long default_val) {
    return libtorrent_jni.bdecode_node_list_int_value_at__SWIG_0(swigCPtr, this, i, default_val);
  }

  public long list_int_value_at(int i) {
    return libtorrent_jni.bdecode_node_list_int_value_at__SWIG_1(swigCPtr, this, i);
  }

  public int list_size() {
    return libtorrent_jni.bdecode_node_list_size(swigCPtr, this);
  }

  public bdecode_node_bdecode_node_pair dict_at_node(int i) {
    return new bdecode_node_bdecode_node_pair(libtorrent_jni.bdecode_node_dict_at_node(swigCPtr, this, i), true);
  }

  public int dict_size() {
    return libtorrent_jni.bdecode_node_dict_size(swigCPtr, this);
  }

  public long int_value() {
    return libtorrent_jni.bdecode_node_int_value(swigCPtr, this);
  }

  public int string_length() {
    return libtorrent_jni.bdecode_node_string_length(swigCPtr, this);
  }

  public long string_offset() {
    return libtorrent_jni.bdecode_node_string_offset(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.bdecode_node_clear(swigCPtr, this);
  }

  public String list_string_value_at_ex(int i, String default_val) {
    return libtorrent_jni.bdecode_node_list_string_value_at_ex__SWIG_0(swigCPtr, this, i, default_val);
  }

  public String list_string_value_at_ex(int i) {
    return libtorrent_jni.bdecode_node_list_string_value_at_ex__SWIG_1(swigCPtr, this, i);
  }

  public bdecode_node dict_find_ex(String key) {
    return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_ex(swigCPtr, this, key), true);
  }

  public bdecode_node dict_find_dict_ex(String key) {
    return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_dict_ex(swigCPtr, this, key), true);
  }

  public bdecode_node dict_find_list_ex(String key) {
    return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_list_ex(swigCPtr, this, key), true);
  }

  public bdecode_node dict_find_string_ex(String key) {
    return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_string_ex(swigCPtr, this, key), true);
  }

  public bdecode_node dict_find_int_ex(String key) {
    return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_int_ex(swigCPtr, this, key), true);
  }

  public String dict_find_string_value_ex(String key, String default_value) {
    return libtorrent_jni.bdecode_node_dict_find_string_value_ex__SWIG_0(swigCPtr, this, key, default_value);
  }

  public String dict_find_string_value_ex(String key) {
    return libtorrent_jni.bdecode_node_dict_find_string_value_ex__SWIG_1(swigCPtr, this, key);
  }

  public long dict_find_int_value_ex(String key, long default_val) {
    return libtorrent_jni.bdecode_node_dict_find_int_value_ex__SWIG_0(swigCPtr, this, key, default_val);
  }

  public long dict_find_int_value_ex(String key) {
    return libtorrent_jni.bdecode_node_dict_find_int_value_ex__SWIG_1(swigCPtr, this, key);
  }

  public String string_value_ex() {
    return libtorrent_jni.bdecode_node_string_value_ex(swigCPtr, this);
  }

  public static String to_string(bdecode_node e, boolean single_line, int indent) {
    return libtorrent_jni.bdecode_node_to_string(bdecode_node.getCPtr(e), e, single_line, indent);
  }

  public static int bdecode(byte_vector buffer, bdecode_node ret, error_code ec) {
    return libtorrent_jni.bdecode_node_bdecode__SWIG_0(byte_vector.getCPtr(buffer), buffer, bdecode_node.getCPtr(ret), ret, error_code.getCPtr(ec), ec);
  }

  public static int bdecode(long buffer_ptr, int size, bdecode_node ret, error_code ec) {
    return libtorrent_jni.bdecode_node_bdecode__SWIG_1(buffer_ptr, size, bdecode_node.getCPtr(ret), ret, error_code.getCPtr(ec), ec);
  }

  public final static class type_t {
    public final static bdecode_node.type_t none_t = new bdecode_node.type_t("none_t");
    public final static bdecode_node.type_t dict_t = new bdecode_node.type_t("dict_t");
    public final static bdecode_node.type_t list_t = new bdecode_node.type_t("list_t");
    public final static bdecode_node.type_t string_t = new bdecode_node.type_t("string_t");
    public final static bdecode_node.type_t int_t = new bdecode_node.type_t("int_t");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static type_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + type_t.class + " with value " + swigValue);
    }

    private type_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private type_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private type_t(String swigName, type_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static type_t[] swigValues = { none_t, dict_t, list_t, string_t, int_t };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
