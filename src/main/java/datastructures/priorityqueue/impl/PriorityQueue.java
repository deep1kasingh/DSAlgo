package datastructures.priorityqueue.impl;

import java.util.Objects;

public class PriorityQueue<T extends Comparable<T>> {
    private int capacity = 10000;
    private T[] minHeap;
    private int size = 0;

    public PriorityQueue(T[] queue) {
        minHeap = (T[])new Comparable[capacity];
        for (int i = 0; i < queue.length; i++) {
            minHeap[i] = queue[i];
        }
        this.size = queue.length;
        for (int i = (queue.length - 1) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T pop() throws Exception {
        if(!isEmpty()){
            T data = minHeap[0];
            minHeap[0] = minHeap[size-1];
            size--;
            minHeapify(0);
            return data;
        } else {
            throw new Exception("cannot pop element");
        }
    }

    public void addEl(T val) {
        minHeap[size] = val;
        size++;
        siftUp(size - 1);
    }

    public void remove(T val) throws Exception {
        int index = -1;
        boolean isFound = false;
        for(int i=0;i<size && !isFound;i++){
            if(minHeap[i]==val){
                index=i;
                isFound = true;
            }
        }
        if(!isFound) {
            throw new Exception("Element not found");
        }
        minHeap[index]=minHeap[size-1];
        size--;

        T elem = minHeap[index];
        siftUp(index);
        if(minHeap[index] == elem){
            siftDown(index);
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (minHeap[index].compareTo(minHeap[parent]) < 0) {
                T temp = minHeap[parent];
                minHeap[parent] = minHeap[index];
                minHeap[index] = temp;
                index = parent;
            } else {
                return;
            }
        }
    }

    private void siftDown(int i) {
        while (i < size/2) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int minIndex = i;
            if (minHeap[leftChild].compareTo(minHeap[minIndex]) < 0) {
                minIndex = leftChild;
            }
            if (rightChild < size) {
                if (minHeap[rightChild].compareTo(minHeap[minIndex]) < 0) {
                    minIndex = rightChild;
                }
            }
            T temp = minHeap[minIndex];
            minHeap[minIndex] = minHeap[i];
            minHeap[i] = temp;
            i = minIndex;
        }
    }

    public void printEls() {
        for (int i = 0; i < size; i++) {
            System.out.println(minHeap[i]);
        }
    }

    private void minHeapify(int i) {
        while (i < size/2) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int minIndex = i;
            if (minHeap[leftChild].compareTo(minHeap[minIndex]) < 0) {
                minIndex = leftChild;
            }
            if (rightChild < size) {
                if (minHeap[rightChild].compareTo(minHeap[minIndex]) < 0) {
                    minIndex = rightChild;
                }
            }
            if (minIndex != i) {
                T temp = minHeap[minIndex];
                minHeap[minIndex] = minHeap[i];
                minHeap[i] = temp;
                i = minIndex;
            } else {
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }
}
