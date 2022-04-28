package com.grados.mosh.hashtable;

import java.util.LinkedList;

public class MyHashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
//        var index=hash(key);
//        if (entries[index]==null)
//            entries[index] = new LinkedList<>();
//        var bucket = entries[index];
//        for (var entry : entries[index])
//            if (entry.key == key)
//            {
//                entry.value = value;
//            }
//        entries[index].addLast(new Entry(key, value));
        // ----------

//        var index = hash(key);
//        if (entries[index] == null)
//            entries[index] = new LinkedList<>();
//        var entry = getEntry(key);
//        if (entry != null ){
//            entry.value = value;
//            return;
//        }
//        entries[index].addLast(new Entry(key, value));
        // refactor
        var ba = getOrCreateBucket(key);
        var entry = getEntry(key);
        if (entry != null ){
            entry.value = value;
            return;
        }
         ba.addLast(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }


    // private methods
    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null)
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;
        return null;
    }


    private int hash(int key) {
        return key % entries.length;
    }
}
