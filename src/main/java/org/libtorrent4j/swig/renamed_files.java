/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.3.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class renamed_files {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected renamed_files(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(renamed_files obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(renamed_files obj) {
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
        libtorrent_jni.delete_renamed_files(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public String file_path(file_storage fs, int index, String save_path) {
    return libtorrent_jni.renamed_files_file_path__SWIG_0(swigCPtr, this, file_storage.getCPtr(fs), fs, index, save_path);
  }

  public String file_path(file_storage fs, int index) {
    return libtorrent_jni.renamed_files_file_path__SWIG_1(swigCPtr, this, file_storage.getCPtr(fs), fs, index);
  }

  public boolean file_absolute_path(file_storage fs, int index) {
    return libtorrent_jni.renamed_files_file_absolute_path(swigCPtr, this, file_storage.getCPtr(fs), fs, index);
  }

  public void rename_file(file_storage fs, int index, String new_filename) {
    libtorrent_jni.renamed_files_rename_file(swigCPtr, this, file_storage.getCPtr(fs), fs, index, new_filename);
  }

  public String file_name_ex(file_storage fs, int index) {
    return libtorrent_jni.renamed_files_file_name_ex(swigCPtr, this, file_storage.getCPtr(fs), fs, index);
  }

  public void import_filenames_ex(file_storage fs, int_string_map renamed_files) {
    libtorrent_jni.renamed_files_import_filenames_ex(swigCPtr, this, file_storage.getCPtr(fs), fs, int_string_map.getCPtr(renamed_files), renamed_files);
  }

  public int_string_map export_filenames_ex() {
    return new int_string_map(libtorrent_jni.renamed_files_export_filenames_ex(swigCPtr, this), true);
  }

  public renamed_files() {
    this(libtorrent_jni.new_renamed_files(), true);
  }

}
