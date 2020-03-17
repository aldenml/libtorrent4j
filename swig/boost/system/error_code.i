%ignore boost::throws;
%ignore boost::detail::throws;
%ignore boost::system::generic_category;
%ignore boost::system::system_category;
%ignore boost::system::error_category;
%ignore boost::system::error_condition;
%ignore boost::system::system_error;
%ignore boost::system::error_code::error_code(int, const error_category&);
%ignore boost::system::error_code::assign;
%ignore boost::system::error_code::category;
%ignore boost::system::error_code::default_error_condition;
%ignore boost::system::error_code::unspecified_bool_true;
%ignore boost::system::error_code::operator std::error_code;
%ignore boost::system::error_code::message(char*, std::size_t) const;
%ignore boost::system::operator==(const error_code&, const error_condition&);
%ignore boost::system::operator==(const error_condition&, const error_code&);
%ignore boost::system::operator!=(const error_code&, const error_code&);
%ignore boost::system::operator!=(const error_code&, const error_condition&);
%ignore boost::system::operator!=(const error_condition&, const error_code&);
%ignore boost::system::operator!=(const error_condition&, const error_condition&);
%ignore boost::system::hash_value;
%ignore boost::system::errc::make_error_condition;
%ignore boost::system::detail::failed_impl;
%ignore boost::system::detail::generic_error_category;
%ignore boost::system::detail::system_error_category;
%ignore boost::asio;

%include "boost/system/error_code.hpp"
