package algorithms.searching;

public class CountNoOfOccInSortedArr {

    // TC: O(logn)
    private static int find(int[] arr, int x) {
        int start = findLow(arr, x);
        if(start != -1) {
            return findHigh(arr,x) - start + 1;
        }
        return 0;
    }

    private static int findLow(int[] arr, int x) {
        int low = 0;
        int high = arr.length -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                if (mid > 0 && arr[mid-1] != x || mid == 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findHigh(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int len = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                if (mid < len - 1 && arr[mid + 1] != x || mid == len - 1) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 3};
        System.out.println(find(arr, 6));
    }
}
