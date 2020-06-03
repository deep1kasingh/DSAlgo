package algorithms.searching;

public class MedianTwoSortedArraysSameSize {
    
    // input: two arrays of same size
    private static double findMedian(int[] arr1, int[] arr2) {
        // corner cases
        if(arr1.length == 0) return -1;
        int low1=0;
        int high1 = arr1.length -1;
        int low2 = 0;
        int high2 = arr2.length -1;
        while(high1 - low1 >= 2) {
            int mid1 = low1 + (high1 - low1)/2;
            int mid2 = low2 + (high2 - low2)/2;
            if(arr1[mid1] < arr2[mid2]) {
                low1 = mid1;
                high2 = mid2;
            } else {
                high1 = mid1;
                low2 = mid2;
            }
        }
        int a = arr1[low1] < arr2[low2] ? arr2[low2] : arr1[low1];
        int b = arr1[high1] < arr2[high2] ? arr1[high1] : arr2[high2];
        return (double)(a +b)/2;
    }
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,12,15,26,38};
        int[] arr2 = new int[]{2,13,17,30,45};

        System.out.println(findMedian(arr1, arr2));

        int[] brr1 = new int[]{};
        int[] brr2 = new int[]{};
        System.out.println(findMedian(brr1,brr2));

        int[] crr1 = new int[]{1};
        int[] crr2 = new int[]{2};
        System.out.println(findMedian(crr1,crr2));
    }
}
