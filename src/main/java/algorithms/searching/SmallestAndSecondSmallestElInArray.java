package algorithms.searching;

public class SmallestAndSecondSmallestElInArray {

    //lines of code = 15
    //TC = O(n), SC = 1
    private static int[] find(int[] arr) throws Exception {
        if (arr.length < 2) throw new Exception("The no of array els is less than 2. no solution exists");
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < a) {
                b = a;
                a = arr[i];
            } else if(arr[i] < b && arr[i] != a) {
                b = arr[i];
            }
        }
        if(a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) throw new Exception("Solution doesnt exits for the array");
        return new  int[]{a,b};
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {12, 13, 1, 10, 34, 1};
        int[] ans = find(arr);
        System.out.println(ans[0] + " " + ans[1]);

        int[] brr = {1, 1};
        int[] bns = find(brr);
        System.out.println(bns[0] + " " + bns[1]);
    }
}
