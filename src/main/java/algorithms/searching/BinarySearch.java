package algorithms.searching;

public class BinarySearch {
    private static int search(int[] arr, int x) {
        int low = 0;
        int high = arr.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid]<x) low = mid+1;
            else if(arr[mid]>x) high = mid-1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11,15,20,35,47};
        int x1 = 47; //el present
        int x2 = 12; //el not present
        int x3=48; //el out of range
        int x4=0; //el below range

        System.out.println(x1 + "is present at pos: " + search(arr, x1));
        System.out.println(x2 + "is present at pos: " + search(arr, x2));
        System.out.println(x3 + "is present at pos: " + search(arr, x3));
        System.out.println(x4 + "is present at pos: " + search(arr, x4));
    }
}
