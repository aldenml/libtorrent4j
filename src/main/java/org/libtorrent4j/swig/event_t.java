/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public final class event_t {
  public final static event_t none = new event_t("none");
  public final static event_t completed = new event_t("completed");
  public final static event_t started = new event_t("started");
  public final static event_t stopped = new event_t("stopped");
  public final static event_t paused = new event_t("paused");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static event_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + event_t.class + " with value " + swigValue);
  }

  private event_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private event_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private event_t(String swigName, event_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static event_t[] swigValues = { none, completed, started, stopped, paused };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

