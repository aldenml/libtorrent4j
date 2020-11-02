/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

package org.libtorrent4j;

import org.libtorrent4j.swig.boost_string_entry_map;
import org.libtorrent4j.swig.entry;
import org.libtorrent4j.swig.entry_vector;

import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Entry class represents one node in a bencoded hierarchy. It works as a
 * variant type, it can be either a list, a dictionary, an integer
 * or a string.
 *
 * @author gubatron
 * @author aldenml
 */
public final class Entry {

    private final entry e;

    public Entry(entry e) {
        this.e = e;
    }

    public Entry(String s) {
        this(new entry(s));
    }

    public Entry(long n) {
        this(new entry(n));
    }

    public entry swig() {
        return e;
    }

    public byte[] bencode() {
        return Vectors.byte_vector2bytes(e.bencode());
    }

    public String string() {
        return e.string();
    }

    public long integer() {
        return e.integer();
    }

    public List<Entry> list() {
        return new EntryList(e.list());
    }

    public Map<String, Entry> dictionary() {
        return new EntryMap(e.dict());
    }

    @Override
    public String toString() {
        return e.to_string();
    }

    public static Entry bdecode(byte[] data) {
        return new Entry(entry.bdecode(Vectors.bytes2byte_vector(data)));
    }

    public static Entry bdecode(File file) throws IOException {
        byte[] data = Files.bytes(file);
        return bdecode(data);
    }

    public static Entry fromList(List<?> list) {
        entry e = new entry(entry.data_type.list_t);

        entry_vector d = e.list();
        for (Object v : list) {
            if (v instanceof String) {
                d.add(new entry((String) v));
            } else if (v instanceof Integer) {
                d.add(new entry((Integer) v));
            } else if (v instanceof Entry) {
                d.add(((Entry) v).swig());
            } else if (v instanceof entry) {
                d.add((entry) v);
            } else if (v instanceof List) {
                d.add(fromList((List<?>) v).swig());
            } else if (v instanceof Map) {
                d.add(fromMap((Map<String, ?>) v).swig());
            } else {
                d.add(new entry(v.toString()));
            }
        }

        return new Entry(e);
    }

    public static Entry fromMap(Map<String, ?> map) {
        entry e = new entry(entry.data_type.dictionary_t);

        boost_string_entry_map d = e.dict();
        for (String k : map.keySet()) {
            Object v = map.get(k);

            if (v instanceof String) {
                d.put(k, new entry((String) v));
            } else if (v instanceof Integer) {
                d.put(k, new entry((Integer) v));
            } else if (v instanceof Entry) {
                d.put(k, ((Entry) v).swig());
            } else if (v instanceof entry) {
                d.put(k, (entry) v);
            } else if (v instanceof List) {
                d.put(k, fromList((List<?>) v).swig());
            } else if (v instanceof Map) {
                d.put(k, fromMap((Map<String, ?>) v).swig());
            } else {
                d.put(k, new entry(v.toString()));
            }
        }

        return new Entry(e);
    }

    private static final class EntryList extends AbstractList<Entry> {

        private final entry_vector v;

        public EntryList(entry_vector v) {
            this.v = v;
        }

        @Override
        public Entry get(int index) {
            return new Entry(v.get(index));
        }

        @Override
        public boolean add(Entry entry) {
            v.add(entry.swig());
            return true;
        }

        @Override
        public int size() {
            return (int) v.size();
        }

        @Override
        public void clear() {
            v.clear();
        }

        @Override
        public boolean isEmpty() {
            return v.isEmpty();
        }
    }

    private static final class EntryMap extends AbstractMap<String, Entry> {

        private final boost_string_entry_map m;

        public EntryMap(boost_string_entry_map m) {
            this.m = m;
        }

        @Override
        public org.libtorrent4j.Entry get(Object key) {
            String k = key.toString();
            return m.contains(k) ? new org.libtorrent4j.Entry(m.get(key.toString())) : null;
        }

        @Override
        public org.libtorrent4j.Entry put(String key, org.libtorrent4j.Entry value) {
            org.libtorrent4j.Entry r = get(key);
            m.put(key, value.swig());
            return r;
        }

        @Override
        public int size() {
            return (int) m.size();
        }

        @Override
        public void clear() {
            m.clear();
        }

        @Override
        public boolean containsKey(Object key) {
            return m.contains(key.toString());
        }

        @Override
        public boolean isEmpty() {
            return m.empty();
        }

        @Override
        public Set<String> keySet() {
            return new HashSet<>(m.keys());
        }

        @Override
        public Set<Entry<String, org.libtorrent4j.Entry>> entrySet() {
            throw new UnsupportedOperationException();
        }
    }
}
