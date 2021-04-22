package datastructures.hashtable.impl;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

class Entry<K, V> {
    K key;
    V value;
    int hash;

    Entry(K key, V value) {
        hash = key.hashCode();
        this.key = key;
        this.value = value;
    }

    public boolean equals(Entry<K, V> other) {
        if (other.hash != this.hash) return false;
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + "=>" + value;
    }
}

// Q. how do we implement iterable methods, iterator()?
// Q. how to allot the array of type V
public class HashTableSeparateChaining<K, V> implements Iterable<K> {

    private int capacity = 3;
    private int size = 0;
    private int DEFAULT_CAPACITY = 3;
    // threshold for the number of elements in the array
    private double DEFAULT_LOAD_FACTOR = 0.75;
    private double maxLoadFactor = DEFAULT_LOAD_FACTOR;
    private int threshold = (int) (this.capacity * DEFAULT_LOAD_FACTOR);
    LinkedList<Entry<K, V>>[] hashTable;

    // constructor to modify capacity and threshold
    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal Capacity");
        this.capacity = Integer.max(DEFAULT_CAPACITY, capacity);
        this.threshold = (int) (this.capacity * maxLoadFactor);
        this.maxLoadFactor = maxLoadFactor;
        hashTable = new LinkedList[this.capacity];
    }

    // default construstor
    public HashTableSeparateChaining() {
        hashTable = new LinkedList[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        Arrays.fill(this.hashTable, null);
    }

    public void add(K key, V value) {
        if (key == null) return;
        Entry<K, V> entry = new Entry(key, value);
        int bucketIndex = normaliseIndex(entry.hash);
        if (hashTable[bucketIndex] == null) {
            LinkedList<Entry<K, V>> ll = new LinkedList<>();
            ll.add(entry);
            hashTable[bucketIndex] = ll;
            this.size++;
        } else {
            if (containsKey(key)) {
                LinkedList<Entry<K, V>> ll = hashTable[bucketIndex];
                for (Entry<K, V> e : ll) {
                    if (e.key == key) {
                        e.value = value;
                    }
                }
            } else {
                hashTable[bucketIndex].add(entry);
                this.size++;
            }
        }
        if (this.size >= this.threshold) resizetable();
    }

    // this is incorrect. we need to re-calculate the indexes for the keys when we resize the table.
    private void resizetable() {
        this.capacity = 2 * this.capacity;
        this.threshold = (int) (this.capacity * maxLoadFactor);
        LinkedList<Entry<K, V>>[] newHashTable = Arrays.copyOf(hashTable, this.capacity);
        this.hashTable = newHashTable;
    }

    public boolean remove(K key) {
        int bucketIndex = normaliseIndex(key.hashCode());
        Entry<K, V> entry = bucketSeekEntry(key);
        if (entry != null) {
            hashTable[bucketIndex].remove(entry);
            this.size--;
            return true;
        } else return false;
    }

    public boolean containsKey(K key) {
        return bucketSeekEntry(key) != null;
    }

    public V get(K key) {
        Entry<K, V> entry = bucketSeekEntry(key);
        if (entry != null) return entry.value;
        else return null;
    }

    private Entry<K, V> bucketSeekEntry(K key) {
        if (key == null) return null;
        int bucketIndex = normaliseIndex(key.hashCode());
        if (hashTable[bucketIndex] != null) {
            LinkedList<Entry<K, V>> ll = hashTable[bucketIndex];
            for (Entry<K, V> entry : ll) {
                if (entry.key.equals(key)) return entry;
            }
        }
        return null;
    }

    private int normaliseIndex(int hash) {
        return (hash & 0x7fffffff) % this.capacity;
    }

    @NotNull
    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super K> action) {

    }

    @Override
    public Spliterator<K> spliterator() {
        return null;
    }
}
