package datastructures.priorityqueue.impl;

public class PriorityQueueTest {
    public static void main(String[] args) throws Exception {
        Integer[] testArr = new Integer[]{9, 1, 5, 7, 3, 2};
        PriorityQueue pq = new PriorityQueue(testArr);
        pq.addEl(10);
        pq.remove(3);
        pq.printEls();
    }
}
