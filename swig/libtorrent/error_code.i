%ignore libtorrent::errors::make_error_code;
%ignore libtorrent::http_category;
%ignore libtorrent::libtorrent_category;
%ignore libtorrent::print_error;

%rename(libtorrent_no_error) libtorrent::errors::no_error;
%rename(libtorrent_errors) libtorrent::errors::error_code_enum;

%include "libtorrent/error_code.hpp"
