package datastructures.hastable.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTableSeparateChaining<T, V> implements Iterable<T> {

    private class Entry<T, V> {
        T key;
        V value;
        int hash;

        Entry(T key, V value) {
            this.key = key;
            this.value = value;
            this.hash = this.key.hashCode();
        }

        public boolean equals(Entry<T, V> entry) {
            return this.hash == entry.hash;
        }

        public String toString() {
            return this.key + "=>" + this.value;
        }

    }

    private LinkedList<Entry<T, V>>[] table;
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private int capacity, threshold, size;
    private double maxLoadFactor;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        //initalising the hashtable
        table = new LinkedList[this.capacity];
        this.threshold = (int) (this.capacity * maxLoadFactor);
        this.maxLoadFactor = maxLoadFactor;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int normaliseIndex(int keyHash) {
        return (0x7FFFFFFF & keyHash) % capacity;
    }

    private void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(T key) {
        int normalisedIndex = normaliseIndex(key.hashCode());
        return bucketSeekEntry(normalisedIndex, key) != null;
    }

    private Entry<T, V> bucketSeekEntry(int normalisedIndex, T key) {
        LinkedList<Entry<T, V>> list = table[normalisedIndex];
        for (Entry<T, V> entry : list) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public void put(T key, V value) {
        insert(key, value);
    }

    public void add(T key, V value) {
        insert(key, value);
    }

    public void insert(T key, V value) {
        Entry<T, V> entry = new Entry<T, V>(key, value);
        int normalisedIIndex = normaliseIndex(entry.hash);
        bucketInsertEntry(normalisedIIndex, entry);
    }

    private void bucketInsertEntry(int normalisedIndex, Entry<T, V> entry) {
        Entry<T, V> seekEntry = bucketSeekEntry(normalisedIndex, entry.key);
        if (seekEntry == null) {
            if (++this.size > this.capacity) {
                resizeTable();
            }
            table[normalisedIndex].addLast(entry);
        } else {
            seekEntry.value = entry.value;
        }
    }

    public void resizeTable() {
        this.capacity = 2 * this.capacity;
        this.threshold = (int) (this.capacity * this.maxLoadFactor);
        LinkedList<Entry<T, V>>[] newtable = new LinkedList[this.capacity];
        for (int i = 0; i < this.table.length; i++) {
            LinkedList<Entry<T, V>> list = this.table[i];
            if (list != null) {
                for (Entry<T, V> entry : list) {
                    int normalisedIndex = normaliseIndex(entry.hash);
                    if (newtable[normalisedIndex] == null) {
                        newtable[normalisedIndex] = new LinkedList<>();
                    }
                    newtable[normalisedIndex].addLast(entry);
                }
            }
            table[i].clear(); // help the GC
            table[i] = null; // helps the GC
        }
        this.table = newtable;
    }

    public Entry<T, V> get(T key) {
        int normalisedIndex = normaliseIndex(key.hashCode());
        return bucketSeekEntry(normalisedIndex, key);
    }

    public V getValue(T key) {
        return get(key).value;
    }

    public void remove(T key) {
        int normalisedIndex = normaliseIndex(key.hashCode());
        bucketRemoveEntry(normalisedIndex, key);
    }

    private void bucketRemoveEntry(int normalisedIndex, T key) {
        LinkedList<Entry<T, V>> list = table[normalisedIndex];
        for (Entry<T, V> entryIter : list) {
            if (entryIter.key == key) {
                list.remove(entryIter);
                return;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
