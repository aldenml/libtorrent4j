/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public final class status_t {
  public final static status_t no_error = new status_t("no_error");
  public final static status_t fatal_disk_error = new status_t("fatal_disk_error");
  public final static status_t need_full_check = new status_t("need_full_check");
  public final static status_t file_exist = new status_t("file_exist");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static status_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + status_t.class + " with value " + swigValue);
  }

  private status_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private status_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private status_t(String swigName, status_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static status_t[] swigValues = { no_error, fatal_disk_error, need_full_check, file_exist };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
