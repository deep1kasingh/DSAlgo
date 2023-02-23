package datastructures.heap;

import java.util.PriorityQueue;

/*
    Leetcode problem: https://leetcode.com/problems/sliding-window-median/description/
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            double[] answer = new double[nums.length];
            for (int i = 0; i < nums.length; i++) {
                answer[i] = nums[i];
            }
            return answer;
        }
        int[] windowArr = new int[k];
        for (int i = 0; i < k; i++) {
            windowArr[i] = nums[i];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        populateInitalMinAndMaxHeap(maxHeap, minHeap, windowArr, k);
        double[] answer = new double[nums.length - k + 1];
        boolean isEven = k % 2 == 0;
        int insertionIndex = 0;
        answer[0] = findMedian(maxHeap, minHeap, isEven);
        int medianIdx = 1;
        for (int i = k; i < nums.length; i++) {
            int elToRemove = windowArr[insertionIndex];
            windowArr[insertionIndex] = nums[i];
            removeAndAddElement(maxHeap, minHeap, nums[i], elToRemove, isEven);
            double currWindowMedian = findMedian(maxHeap, minHeap, isEven);
            answer[medianIdx++] = currWindowMedian;
            insertionIndex = (insertionIndex + 1) % k;
        }
        return answer;
    }

    private void removeAndAddElement(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int elToAdd,
                                     int elToRemove, boolean isEven) {
        if (elToRemove <= maxHeap.peek()) {
            // remove element from max heap
            maxHeap.remove(elToRemove);
            if (!isEven) {
                maxHeap.add(minHeap.poll());
            }
        } else {
            // remove element from min heap
            minHeap.remove(elToRemove);
            if (isEven) {
                minHeap.add(maxHeap.poll());
            }
        }
        isEven = !isEven;
        if (isEven) {
            maxHeap.add(elToAdd);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(elToAdd);
            maxHeap.add(minHeap.poll());
        }
    }

    private void populateInitalMinAndMaxHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap,
                                             int[] windowArr, int k) {
        boolean isEven = true;
        for (int i = 0; i < k; i++) {
            if (isEven) {
                maxHeap.add(windowArr[i]);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(windowArr[i]);
                maxHeap.add(minHeap.poll());
            }
            isEven = !isEven;
        }
    }

    private double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, boolean isEven) {
        if (isEven) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.00;
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        double[] ans = new SlidingWindowMedian().medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        System.out.println(Integer.MAX_VALUE);
    }
}
