package datastructures.linkedlist.impl;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoublyLinkedList<T> implements Iterable<T> {
    private class Node<T> {
        T value;
        Node<T> next = null;
        Node<T> previous = null;

        Node(T val) {
            this.value = val;
        }

        Node addNext(T val) {
            Node node = new Node(val);
            this.next = node;
            node.previous = this;
            return node;
        }

        Node addPrevious(T val) {
            Node node = new Node(val);
            node.next = this;
            this.previous = node;
            return node;
        }

    }

    private Node<T> head = null;
    private Node<T> tail = null;

    private int size = 0;

    public DoublyLinkedList() {

    }

    public DoublyLinkedList(T val) {
        intialise(val);
    }

    private void intialise(T val) {
        head = new Node<>(val);
        tail = new Node<>(val);
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFront(T val) {
        if (this.head == null) {
            intialise(val);
            return;
        }
        Node node = this.head.addPrevious(val);
        this.head = node;
        size++;
    }

    public void addLast(T val) {
        if (this.head == null) {
            intialise(val);
            return;
        }
        Node node = this.tail.addNext(val);
        this.tail = node;
        size++;
    }

    public boolean remove(Object obj) {
        if (obj == null) return false;
        Node<T> trav = head;
        while (trav != null && trav.value != obj) {
            trav = trav.next;
        }
        if (trav != null) {
            if (trav.previous == null) {
                removeFront();
            } else if (trav.next == null) {
                removeLast();
            } else {
                trav.previous.next = trav.next;
                trav.next.previous = trav.previous;
            }
            return true;
        } else return false;
    }

    public T removeFront() {
        if (head == null) throw new RuntimeException("Empty list");
        size--;
        Node<T> node = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            this.head = this.head.next;
        }
        return node.value;
    }

    public T removeLast() {
        if (head == null) throw new RuntimeException("Empty list");
        size--;
        Node<T> node = tail;
        if (head == tail) {
            head = null;
            tail = null;
        }
        this.tail = this.head.previous;
        return node.value;
    }

    public T getFirst() {
        if (head == null) throw new RuntimeException("Empty list");
        return this.head.value;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav.next != null;
            }

            @Override
            public T next() {
                T data = trav.value;
                trav = trav.next;
                return data;
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
