package algorithms.searching;

public class MaxValueInIncrsngDecrsngArray {
    //TC: O(logn)
    //binary search
    private static int find(int[] arr) throws Exception {
        if (arr.length < 1) throw new Exception("No solution exists. Length of array less than 1");
        if (arr.length == 1) return arr[0];
        //only dec exists
        if (arr[0] > arr[1]) return arr[0];
        int low = 0;
        int high = arr.length - 1;
        int len = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid] > arr[mid - 1] && (mid < len && arr[mid] > arr[mid + 1] || mid == len)) {
                return arr[mid];
            } else if (mid > 0 && arr[mid] > arr[mid - 1] || (mid < len && arr[mid] < arr[mid + 1])) {
                low = mid + 1;
            } else if (mid < len && arr[mid] > arr[mid + 1] || mid > 0 && arr[mid] < arr[mid - 1]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println(find(arr));

        int[] brr = new int[]{1, 3, 50, 10, 9, 7, 6};
        System.out.println(find(brr));

        //Corner case (No decreasing part)
        int[] crr = new int[]{10, 20, 30, 40, 50};
        System.out.println(find(crr));

        //Corner case (No increasing part)
        int[] drr = new int[]{120, 100, 80, 20, 0};
        System.out.println(find(drr));
    }
}
