package datastructures.heap;

import java.util.PriorityQueue;

/*
 Leetcode Problem: https://leetcode.com/problems/find-median-from-data-stream/description/

 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean isCurrentlyEven;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        maxHeap = new PriorityQueue<Integer>();
        isCurrentlyEven = true;
    }

    public void addNum(int num) {
        if(isCurrentlyEven) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        isCurrentlyEven = !isCurrentlyEven;
    }

    public double findMedian() {
        if(isCurrentlyEven) {
            return (minHeap.peek() + maxHeap.peek())/2.00;
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}
