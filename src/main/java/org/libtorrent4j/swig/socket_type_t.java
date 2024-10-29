/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public final class socket_type_t {
  public final static socket_type_t tcp = new socket_type_t("tcp");
  public final static socket_type_t socks5 = new socket_type_t("socks5");
  public final static socket_type_t http = new socket_type_t("http");
  public final static socket_type_t utp = new socket_type_t("utp");
  public final static socket_type_t i2p = new socket_type_t("i2p");
  public final static socket_type_t rtc = new socket_type_t("rtc");
  public final static socket_type_t tcp_ssl = new socket_type_t("tcp_ssl");
  public final static socket_type_t socks5_ssl = new socket_type_t("socks5_ssl");
  public final static socket_type_t http_ssl = new socket_type_t("http_ssl");
  public final static socket_type_t utp_ssl = new socket_type_t("utp_ssl");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static socket_type_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + socket_type_t.class + " with value " + swigValue);
  }

  private socket_type_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private socket_type_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private socket_type_t(String swigName, socket_type_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static socket_type_t[] swigValues = { tcp, socks5, http, utp, i2p, rtc, tcp_ssl, socks5_ssl, http_ssl, utp_ssl };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

