// this file provides the posix calls renamed

#ifndef POSIX_WRAPPER_HPP
#define POSIX_WRAPPER_HPP

extern int posix_open(const char*, int, int mode = 0);
extern int posix_stat(const char*, struct ::stat*);
extern int posix_mkdir(const char*, mode_t);
extern int posix_remove(const char*);

#endif // POSIX_WRAPPER_HPP
