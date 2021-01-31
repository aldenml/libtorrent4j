%ignore libtorrent::settings_pack::settings_pack(settings_pack&&);
%ignore libtorrent::settings_pack::deprecated;
%ignore libtorrent::settings_pack::deprecated_ignore_limits_on_local_network;
%ignore libtorrent::settings_pack::deprecated_rate_limit_utp;
%ignore libtorrent::settings_pack::deprecated_local_upload_rate_limit;
%ignore libtorrent::settings_pack::deprecated_local_download_rate_limit;
%ignore libtorrent::settings_pack::deprecated_half_open_limit;
%ignore libtorrent::settings_pack::deprecated_utp_delayed_ack;
%ignore libtorrent::settings_pack::deprecated_dht_upload_rate_limit;
%ignore libtorrent::settings_pack::deprecated_ignore_resume_timestamps;
%ignore libtorrent::settings_pack::deprecated_network_threads;
%ignore libtorrent::settings_pack::deprecated_lock_disk_cache;
%ignore libtorrent::settings_pack::deprecated_use_write_cache;
%ignore libtorrent::settings_pack::deprecated_lazy_bitfield;
%ignore libtorrent::settings_pack::deprecated_guided_read_cache;
%ignore libtorrent::settings_pack::deprecated_hashing_threads;
%ignore libtorrent::settings_pack::deprecated_contiguous_recv_buffer;
%ignore libtorrent::settings_pack::deprecated_default_cache_min_age;
%ignore libtorrent::settings_pack::deprecated_low_prio_disk;
%ignore libtorrent::settings_pack::deprecated_announce_double_nat;
%ignore libtorrent::settings_pack::deprecated_use_disk_read_ahead;
%ignore libtorrent::settings_pack::deprecated_active_loaded_limit;
%ignore libtorrent::settings_pack::deprecated_mmap_cache;
%ignore libtorrent::settings_pack::deprecated_dont_flush_write_cache;
%ignore libtorrent::settings_pack::deprecated_file_checks_delay_per_block;
%ignore libtorrent::settings_pack::deprecated_use_disk_cache_pool;
%ignore libtorrent::settings_pack::deprecated_cache_buffer_chunk_size;
%ignore libtorrent::settings_pack::deprecated_lock_files;
%ignore libtorrent::settings_pack::deprecated_ssl_listen;
%ignore libtorrent::settings_pack::deprecated_force_proxy;
%ignore libtorrent::settings_pack::deprecated_aio_max;
%ignore libtorrent::settings_pack::deprecated_disable_os_cache_for_aligned_files;
%ignore libtorrent::settings_pack::deprecated_bittyrant_choker;
%ignore libtorrent::settings_pack::deprecated_strict_super_seeding;
%ignore libtorrent::settings_pack::deprecated_flush_write_cache;
%ignore libtorrent::settings_pack::deprecated_cache_expiry;
%ignore libtorrent::settings_pack::deprecated_upnp_ignore_nonrouters;
%ignore libtorrent::settings_pack::deprecated_use_read_cache;
%ignore libtorrent::settings_pack::deprecated_coalesce_reads;
%ignore libtorrent::settings_pack::deprecated_coalesce_writes;
%ignore libtorrent::settings_pack::deprecated_broadcast_lsd;
%ignore libtorrent::settings_pack::deprecated_support_merkle_torrents;
%ignore libtorrent::settings_pack::deprecated_cache_size;
%ignore libtorrent::settings_pack::deprecated_default_est_reciprocation_rate;
%ignore libtorrent::settings_pack::deprecated_increase_est_reciprocation_rate;
%ignore libtorrent::settings_pack::deprecated_decrease_est_reciprocation_rate;
%ignore libtorrent::settings_pack::deprecated_cache_size_volatile;
%ignore libtorrent::settings_pack::deprecated_volatile_read_cache;
%ignore libtorrent::apply_pack_impl;
%ignore libtorrent::setting_by_name;
%ignore libtorrent::non_default_settings;
%ignore libtorrent::apply_pack;
%ignore libtorrent::run_all_updates;
%ignore libtorrent::save_settings_to_dict;
%ignore libtorrent::load_pack_from_dict;

%include "libtorrent/settings_pack.hpp"

namespace libtorrent {

%extend settings_pack
{
    std::vector<std::int8_t> get_bytes(int name)
    {
        auto v = $self->get_str(name);
        return std::vector<std::int8_t>(v.begin(), v.end());
    }

    void set_bytes(int name, std::vector<std::int8_t> v)
    {
        $self->set_str(name, std::string(v.begin(), v.end()));
    }
}

}
