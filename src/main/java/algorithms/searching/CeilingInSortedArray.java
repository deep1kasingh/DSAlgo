package algorithms.searching;

public class CeilingInSortedArray {
    // binary search
    // TC: O(logn)
    private static int findCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x){
                if(mid > 0 && arr[mid-1]<x || mid == 0) {
                    return arr[mid];
                } else {
                    high = mid-1;
                }
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private static int findFloor(int[] arr, int x) {
        int len = arr.length;
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= x){
                if(mid < len - 1 && arr[mid+1]>x || mid == len - 1) {
                    return arr[mid];
                } else {
                    low = mid+1;
                }
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 8, 10, 10, 12, 19};
        System.out.println(findCeil(arr, 1));
        System.out.println(findFloor(arr, 1));
    }
}
