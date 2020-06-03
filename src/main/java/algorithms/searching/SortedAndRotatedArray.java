package algorithms.searching;

// given: the pivot point is unknown
// int[] arr = new int[]{3,4,5,1,2};
//bin search on one subarray
public class SortedAndRotatedArray {
    private static int search(int[] arr, int x){
        int pivot = findPivot(arr);
        if(pivot == -1) return -1;
        int low,high;
        if(x >= arr[0]) {
            low =0;
            high =pivot;
        } else {
            low = pivot +1;
            high = arr.length;
        }
        // running binary search
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid]<x) low = mid+1;
            else if(arr[mid]>x) high = mid-1;
            else return mid;
        }
        return -1;
    }

    // one method o find the pivot, one leg of the algo
    private static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length -1;
        int pivot = -1;
        while(low<=high && pivot ==-1){
            int mid = low + (high-low)/2;
            if(mid < high && arr[mid] > arr[mid+1]) pivot = mid;
            else if(mid>low && arr[mid] < arr[mid+1]) pivot = mid-1;
            else if(arr[low] > arr[mid]) high = mid-1;
            else if(arr[high] < arr[mid]) low = mid+1;
            else if(low == high) pivot = low;
        }
        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        int pivot = 3;
        int x=5;
        System.out.println(findPivot(arr));
        System.out.println(search(arr, 5));

        //running more test cases
        System.out.println(search(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 3));
        System.out.println(search(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 30));
        System.out.println(search(new int[]{30, 40, 50, 10, 20}, 10));
        System.out.println(search(new int[]{}, 10));
    }
}
