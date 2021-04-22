package leetcode.google;

import java.util.TreeMap;

public class NonOverlappingIntervals {
    public int minSumOfLengths(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int N = arr.length;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int best = -1;
        while (i < N) {
            if (j < N && sum < target) sum += arr[j++];
            if (sum == target) {
                m.put(j, i);
                // if we have another interval prior to this point, use it
                Integer k = m.floorKey(i);
                if (k != null) {
                    int l = j - i + k - m.get(k);
                    best = best == -1 ? l : Math.min(l, best);
                }
                // put the best interval distance back, we check the best interval prior to this point, and if it has shorted distance - use it instead, so maintain the shortest distance for the left interval
                Integer b = m.floorKey(j - 1);
                int bl = b == null ? j - i : Math.min(j - i, b - m.get(b));
                m.put(j, j - bl);
            }
            if (sum >= target) {
                sum -= arr[i++];
            }

            if (sum < target && j >= N) break;
        }
        return best;
    }

    public static void main(String[] args) {
        new NonOverlappingIntervals().minSumOfLengths(new int[]{1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8}, 5);

    }
}

