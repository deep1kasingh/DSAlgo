package datastructures.stack.impl;

import datastructures.linkedlist.impl.DoublyLinkedList;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {
    private DoublyLinkedList<T> list = null;

    public Stack() {
        list = new DoublyLinkedList<T>();
    }

    public Stack(T elem) {
        push(elem);
    }

    public T pop() {
        return list.removeFront();
    }

    public void push(T val) {
        list.addFront(val);
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
