package leetcode.interviewqns;

import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> valueToAdressMapping = new HashMap<>();

        Queue<Integer> heap = new PriorityQueue<>();
        Arrays.sort(intervals);
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(o -> o[1]));
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (heap.isEmpty()) {
                count++;
            } else {
                Integer minTillNow = heap.poll();
                if (intervals[i][0] < minTillNow) {
                    count++;
                }
            }
            heap.add(intervals[i][1]);
        }
        return count;
    }
}
