package datastructures.array.impl;

import org.omg.CORBA.Object;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Array<T> implements Iterable<T> {
    private T[] arr;
    private int capacity = 0; // actual length
    private int len = 0; // length to the outside world

    public Array() {
        this.capacity = 16;
        arr = (T[]) new Object[this.capacity];
    }

    public Array(int size) {
        if (size < 0) throw new IllegalArgumentException("Illegal Argument Exception: " + capacity);
        this.capacity = size;
        arr = (T[]) new Object[this.capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index >= this.len) throw new IllegalArgumentException("Index Out Of Bounds");
        return arr[index];
    }

    public void set(int index, T obj) {
        if (index >= this.len) throw new IllegalArgumentException("Index Out Of Bounds");
        arr[index] = obj;
    }

    public void clear() {
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        if (len + 1 >= capacity) {
            capacity = 2 * capacity;
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len++] = elem;
    }

    public T removeAt(int index){
        if (index >= this.len) throw new IllegalArgumentException("Index Out Of Bounds");
        T data = arr[index];
        T[] newArr = (T[]) new Object[capacity];
        for(int i=0,j=0;i<len && j<len;i++,j++){
            if(i==index) i--;
            newArr[i]=arr[j];
        }
        arr = newArr;
        len--;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=0;
            @Override
            public boolean hasNext() {
                return index<len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
