/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig2;

public class libtorrent {
  public static boolean op_eq(error_code lhs, error_code rhs) {
    return libtorrent_jni.op_eq__SWIG_1(error_code.getCPtr(lhs), lhs, error_code.getCPtr(rhs), rhs);
  }

  public static boolean op_lt(error_code lhs, error_code rhs) {
    return libtorrent_jni.op_lt__SWIG_1(error_code.getCPtr(lhs), lhs, error_code.getCPtr(rhs), rhs);
  }

  public static error_code make_error_code(errc_t e) {
    return new error_code(libtorrent_jni.make_error_code(e.swigValue()), true);
  }

  public static long getNum_protocols() {
    return libtorrent_jni.num_protocols_get();
  }

  public static boolean op_ne(info_hash_t lhs, info_hash_t rhs) {
    return libtorrent_jni.op_ne(info_hash_t.getCPtr(lhs), lhs, info_hash_t.getCPtr(rhs), rhs);
  }

  public static boolean op_eq(info_hash_t lhs, info_hash_t rhs) {
    return libtorrent_jni.op_eq(info_hash_t.getCPtr(lhs), lhs, info_hash_t.getCPtr(rhs), rhs);
  }

}