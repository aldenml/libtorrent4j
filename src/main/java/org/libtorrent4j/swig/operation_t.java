/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public final class operation_t {
  public final static operation_t unknown = new operation_t("unknown");
  public final static operation_t bittorrent = new operation_t("bittorrent");
  public final static operation_t iocontrol = new operation_t("iocontrol");
  public final static operation_t getpeername = new operation_t("getpeername");
  public final static operation_t getname = new operation_t("getname");
  public final static operation_t alloc_recvbuf = new operation_t("alloc_recvbuf");
  public final static operation_t alloc_sndbuf = new operation_t("alloc_sndbuf");
  public final static operation_t file_write = new operation_t("file_write");
  public final static operation_t file_read = new operation_t("file_read");
  public final static operation_t file = new operation_t("file");
  public final static operation_t sock_write = new operation_t("sock_write");
  public final static operation_t sock_read = new operation_t("sock_read");
  public final static operation_t sock_open = new operation_t("sock_open");
  public final static operation_t sock_bind = new operation_t("sock_bind");
  public final static operation_t available = new operation_t("available");
  public final static operation_t encryption = new operation_t("encryption");
  public final static operation_t connect = new operation_t("connect");
  public final static operation_t ssl_handshake = new operation_t("ssl_handshake");
  public final static operation_t get_interface = new operation_t("get_interface");
  public final static operation_t sock_listen = new operation_t("sock_listen");
  public final static operation_t sock_bind_to_device = new operation_t("sock_bind_to_device");
  public final static operation_t sock_accept = new operation_t("sock_accept");
  public final static operation_t parse_address = new operation_t("parse_address");
  public final static operation_t enum_if = new operation_t("enum_if");
  public final static operation_t file_stat = new operation_t("file_stat");
  public final static operation_t file_copy = new operation_t("file_copy");
  public final static operation_t file_fallocate = new operation_t("file_fallocate");
  public final static operation_t file_hard_link = new operation_t("file_hard_link");
  public final static operation_t file_remove = new operation_t("file_remove");
  public final static operation_t file_rename = new operation_t("file_rename");
  public final static operation_t file_open = new operation_t("file_open");
  public final static operation_t mkdir = new operation_t("mkdir");
  public final static operation_t check_resume = new operation_t("check_resume");
  public final static operation_t exception = new operation_t("exception");
  public final static operation_t alloc_cache_piece = new operation_t("alloc_cache_piece");
  public final static operation_t partfile_move = new operation_t("partfile_move");
  public final static operation_t partfile_read = new operation_t("partfile_read");
  public final static operation_t partfile_write = new operation_t("partfile_write");
  public final static operation_t hostname_lookup = new operation_t("hostname_lookup");
  public final static operation_t symlink = new operation_t("symlink");
  public final static operation_t handshake = new operation_t("handshake");
  public final static operation_t sock_option = new operation_t("sock_option");
  public final static operation_t enum_route = new operation_t("enum_route");
  public final static operation_t file_seek = new operation_t("file_seek");
  public final static operation_t timer = new operation_t("timer");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static operation_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + operation_t.class + " with value " + swigValue);
  }

  private operation_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private operation_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private operation_t(String swigName, operation_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static operation_t[] swigValues = { unknown, bittorrent, iocontrol, getpeername, getname, alloc_recvbuf, alloc_sndbuf, file_write, file_read, file, sock_write, sock_read, sock_open, sock_bind, available, encryption, connect, ssl_handshake, get_interface, sock_listen, sock_bind_to_device, sock_accept, parse_address, enum_if, file_stat, file_copy, file_fallocate, file_hard_link, file_remove, file_rename, file_open, mkdir, check_resume, exception, alloc_cache_piece, partfile_move, partfile_read, partfile_write, hostname_lookup, symlink, handshake, sock_option, enum_route, file_seek, timer };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

