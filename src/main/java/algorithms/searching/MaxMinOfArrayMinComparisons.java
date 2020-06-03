package algorithms.searching;

public class MaxMinOfArrayMinComparisons {
    // recursion T(n) = 2T(T/2) + 1
    // master method: T(n) = aT(n/b) + f(n)
    private static int[] find(int[] arr) throws Exception {
        if (arr.length < 1) throw new Exception("The no of array els is less than 1. no solution exists");
        if (arr.length == 1) return new int[]{arr[0], arr[0]};
//        return findRecur(arr, 0, arr.length - 1);
        return findPairs(arr);
    }

    /* tournament method:
        lines of code: 19
        O(n) = ???
        SC: O(n)
     */
    private static int[] findRecur(int[] arr, int low, int high) {
        if (low == high) return new int[]{arr[low], arr[high]};
        if (low + 1 == high) {
            int min = -1, max = -1;
            if (arr[low] < arr[high]) {
                min = arr[low];
                max = arr[high];
            } else {
                min = arr[high];
                max = arr[low];
            }
            return new int[]{min, max};
        }
        int mid = low + (high - low) / 2;
        int[] minMax1 = findRecur(arr, low, mid);
        int[] minMax2 = findRecur(arr, mid + 1, high);
        int min = -1, max = -1;
        min = minMax1[0] < minMax2[0] ? minMax1[0] : minMax2[0];
        max = minMax1[1] > minMax2[1] ? minMax1[1] : minMax2[1];
        return new int[]{min, max};
    }

    /* expecting arr length > 1
        no of comparisons = 3n/2-2
        SC = 1
     */
    private static int[] findPairs(int[] arr) {
        int min, max;
        if (arr[0] < arr[1]) {
            min = arr[0];
            max = arr[1];
        } else {
            min = arr[1];
            max = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            int less = -1, more = -1;
            if (i + 1 < arr.length) {
                if (arr[i] < arr[i + 1]) {
                    less = arr[i];
                    more = arr[i + 1];
                } else {
                    less = arr[i + 1];
                    more = arr[i];
                }
            } else {
                less = arr[i];
                more = arr[i];
            }
            if (less < min) {
                min = less;
            }
            if (more > max) {
                max = more;
            }
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1000, 11, 445, 1, 330, 3000};
        int[] ans = find(arr);
        System.out.println(ans[0] + " " + ans[1]);

        int[] brr = new int[]{1};
        int[] bns = find(brr);
        System.out.println(bns[0] + " " + bns[1]);
    }
}
