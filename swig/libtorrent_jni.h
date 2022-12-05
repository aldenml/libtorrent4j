/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * This file is not intended to be easily readable and contains a number of
 * coding conventions designed to improve portability and efficiency. Do not make
 * changes to this file unless you know what you are doing--modify the SWIG
 * interface file instead.
 * ----------------------------------------------------------------------------- */

#ifndef SWIG_libtorrent_WRAP_H_
#define SWIG_libtorrent_WRAP_H_

struct SwigDirector_alert_notify_callback : public alert_notify_callback, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_alert_notify_callback(JNIEnv *jenv);
    virtual ~SwigDirector_alert_notify_callback();
    virtual void on_alert();
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};

struct SwigDirector_list_files_listener : public list_files_listener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_list_files_listener(JNIEnv *jenv);
    virtual ~SwigDirector_list_files_listener();
    virtual bool pred(std::string p);
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};

struct SwigDirector_set_piece_hashes_listener : public set_piece_hashes_listener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_set_piece_hashes_listener(JNIEnv *jenv);
    virtual ~SwigDirector_set_piece_hashes_listener();
    virtual void progress(int i);
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};


#endif
