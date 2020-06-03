package algorithms.searching;

import java.util.Arrays;

public class KSmallestOrLargestElsInArray {

    //TC: O(k) + O((n-k)log(k))
    private static int[] find(int[] arr, int k) throws Exception {
        if (k > arr.length) throw new Exception("no solution exists: k is more than the length of the array");
        int[] maxHeapKSize = new int[k];
        for (int i = 0; i < k; i++) {
            maxHeapKSize[i] = arr[i];
        }
        createMaxHeap(maxHeapKSize, k);
        // can be used for stream for elements
        for (int i = k; i < arr.length; i++) {
            if (maxHeapKSize[0] > arr[i]) {
                maxHeapKSize[0] = arr[i];
                maxHeapify(maxHeapKSize, k, 0);
            }
        }
        return maxHeapKSize;
    }

    // TC: O(k)
    // SC: O(k)
    private static void createMaxHeap(int[] maxHeapKSize, int k) {
        for (int j = (k - 1) / 2; j >= 0; j--) {
            maxHeapify(maxHeapKSize, k, j);
        }
    }

    // TC: O(logn)
    // SC: O(1)
    private static void maxHeapify(int[] maxHeapKSize, int k, int parent) {
        //siftdown
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;
        int minIndex = parent;
        if (leftChild < k && maxHeapKSize[leftChild] > maxHeapKSize[parent]) minIndex = leftChild;
        if (rightChild < k && maxHeapKSize[rightChild] > maxHeapKSize[minIndex]) minIndex = rightChild;
        if (parent != minIndex) {
            swap(maxHeapKSize, minIndex, parent);
            maxHeapify(maxHeapKSize, k, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int[] ans = find(arr, 10);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
