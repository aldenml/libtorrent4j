%ignore libtorrent::session::session(session_params&&, session_flags_t);
%ignore libtorrent::session::session(session_params&&, io_context&);
%ignore libtorrent::session::session(session_params const&, io_context&);
%ignore libtorrent::session::session(session_params&&, io_context&, session_flags_t);
%ignore libtorrent::session::session(session_params const&, io_context&, session_flags_t);
%ignore libtorrent::session::session(settings_pack&&, io_context&, session_flags_t const);
%ignore libtorrent::session::session(settings_pack const&, io_context&, session_flags_t const);
%ignore libtorrent::session::session(settings_pack&&, io_context&);
%ignore libtorrent::session::session(settings_pack const&, io_context&);
%ignore libtorrent::session::session(session_params&&);
%ignore libtorrent::session::session(settings_pack&&, session_flags_t const);
%ignore libtorrent::session::session(settings_pack&&);
%ignore libtorrent::session_proxy::session_proxy(session_proxy&&);
%ignore libtorrent::default_disk_io_constructor;

%include "libtorrent/session.hpp"
