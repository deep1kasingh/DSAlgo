package leetcode.google;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        int left = 0;
        minQ.add(left);
        maxQ.add(left);
        int res = 1;
        for (int right = 1; right < nums.length; right++) {
            while (!minQ.isEmpty() && nums[right] < nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && nums[right] > nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            minQ.addLast(nums[right]);
            maxQ.addLast(nums[right]);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                if (maxQ.peekFirst() == left) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() == left) {
                    minQ.pollFirst();
                }
                left++;
            }
            Integer.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 2, 4, 7};
        int limit = 4;
        new Problem1438().longestSubarray(nums, limit);
    }
}
