package datastructures.queue.impl;

import org.omg.CORBA.Object;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private int capacity = 100000;
    private T[] staticArr = (T[]) new Object[capacity];

    private int head = -1;
    private int tail = -1;
    private int size = 0;

    public void addLast(T val) {
        if (head == -1) {
            staticArr[0] = val;
            head = 0;
            tail = 0;
        } else {
            staticArr[++tail] = val;
        }
        size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T removeFirst() {
        if (!isEmpty()) {
            T data = staticArr[head];
            head++;
            size--;
            if (size == 0) {
                head = -1;
                tail = -1;
            }
            return data;
        } else {
            return null;
        }
    }

    public int size() {
        if (!isEmpty()) {
            return this.tail - this.head + 1;
        } else {
            return 0;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int first = head;
            int last = tail;
            @Override
            public boolean hasNext() {
                return first<=last;
            }

            @Override
            public T next() {
                T data = staticArr[first];
                first++;
                return data;
            }
        };
    }
}
