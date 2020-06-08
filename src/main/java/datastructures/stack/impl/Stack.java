package datastructures.stack.impl;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
    //implement stack using linked list
    private LinkedList<T> linkedList = new LinkedList<>();

    public void push(T val) {
        linkedList.addFirst(val);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public T pop() {
        T val = linkedList.pop();
        return val;
    }

    public T peek() {
        T val = linkedList.peek();
        return val;
    }

    public int size() {
        return this.linkedList.size();
    }

    public void clearStack() {
        this.linkedList.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
