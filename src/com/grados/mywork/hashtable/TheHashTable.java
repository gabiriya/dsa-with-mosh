package com.grados.mywork.hashtable;

import java.util.*;

public class TheHashTable {
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
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        var bucket = getOrCreateBucket(key);

        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {

        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;

    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }


    public int mostFrequent(Integer[] items) {
        Map<Integer, Integer> list = new HashMap<>();

        for (var item : items) {  //O(n)
            if (list.containsKey(item)) {
                var c = list.get(item);
                list.put(item, ++c);
            } else {
                list.put(item, 1);
            }
        }

        var max = 0;
        for (var l : list.entrySet()) {
            if (l.getValue() > max)
                max = l.getValue();
        }
        return max;
    }

    public int countPairsWithDiff(int k, int[] items) { //O(n)
        Set<Integer> set = new HashSet<>();
        for (var i : items)
            set.add(i);

        var count = 0;
        for (var i : items) {
            if (set.contains(i + k))
                count++;
            if (set.contains(i - k))
                count++;
            set.remove(i);
        }
        return count;
    }



    // private methods
    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null) {
            entries[index] = new LinkedList<>();
        }

        return bucket;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
