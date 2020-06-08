package datastructures.linkedlist.impl;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private class Node<T> {
        private T val;
        Node next;
        Node prev;

        Node(T val) {
            this.val = val;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size=0;

    public T first() {
        if (head != null) {
            return  head.val;
        } else {
            return null;
        }
    }

    public T tail() {
        if (tail != null) {
            return  tail.val;
        } else {
            return null;
        }
    }

    public void addToHead(T val) {
        Node newNode = new Node(val);
        if(head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void addToTail(T val) {
        Node newNode = new Node<>(val);
        if(this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        size++;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    // Is this Linked List Empty
    public boolean isEmpty() {
        return size() == 0;
    }

    public T removeAtHead(){
        if(!isEmpty()){
            T data = this.head.val;
            this.head = this.head.next;
            this.head.prev = null;
            return data;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav == null;
            }

            @Override
            public T next() {
                T data = trav.val;
                trav = trav.next;
                return data;
            }
        };
    }
}
