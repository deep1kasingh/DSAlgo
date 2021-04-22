package datastructures.queue.impl;

import datastructures.linkedlist.impl.DoublyLinkedList;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private DoublyLinkedList<T> list = null;

    public Queue() {
        list = new DoublyLinkedList<T>();
    }

    public void offer(T elem) {
        list.addLast(elem);
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.removeFront();
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
