/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_pkt_alert extends alert {
  private transient long swigCPtr;

  protected dht_pkt_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_pkt_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_pkt_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(dht_pkt_alert obj) {
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
        libtorrent_jni.delete_dht_pkt_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_pkt_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_pkt_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_pkt_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_pkt_alert_message(swigCPtr, this);
  }

  public void setDirection(dht_pkt_alert.direction_t value) {
    libtorrent_jni.dht_pkt_alert_direction_set(swigCPtr, this, value.swigValue());
  }

  public dht_pkt_alert.direction_t getDirection() {
    return dht_pkt_alert.direction_t.swigToEnum(libtorrent_jni.dht_pkt_alert_direction_get(swigCPtr, this));
  }

  public udp_endpoint get_node() {
    return new udp_endpoint(libtorrent_jni.dht_pkt_alert_get_node(swigCPtr, this), true);
  }

  public byte_vector get_pkt_buf() {
    return new byte_vector(libtorrent_jni.dht_pkt_alert_get_pkt_buf(swigCPtr, this), true);
  }

  public final static class direction_t {
    public final static dht_pkt_alert.direction_t incoming = new dht_pkt_alert.direction_t("incoming");
    public final static dht_pkt_alert.direction_t outgoing = new dht_pkt_alert.direction_t("outgoing");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static direction_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + direction_t.class + " with value " + swigValue);
    }

    private direction_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private direction_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private direction_t(String swigName, direction_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static direction_t[] swigValues = { incoming, outgoing };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_pkt_alert_static_category_get(), false);
  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.dht_pkt_alert_priority_get());
  public final static int alert_type = libtorrent_jni.dht_pkt_alert_alert_type_get();
}
