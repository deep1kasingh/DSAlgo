package algorithms.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoElsSumClosestTo0 {
    // lines of code = 57
    // O(nlog(n)) Space Complexity: O(n)
    private static int[] findTwoElsSeparatePositiveAndNegativeArrays(int[] arr) throws Exception {
        if (arr.length < 2) throw new Exception("The no of array els is less than 2. no solution exists");
        List<Integer> negativeArray = new ArrayList<Integer>();
        List<Integer> positiveArray = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeArray.add(arr[i]);
            } else {
                positiveArray.add(arr[i]);
            }
        }
        // O(2n(logn))
        Collections.sort(negativeArray);
        Collections.sort(positiveArray);
        int currSum, el1 = -1, el2 = -1;
        int lowSum = Integer.MAX_VALUE;
        for (int i = 0, j = positiveArray.size() - 1; i < negativeArray.size() && j >= 0; ) {
            currSum = negativeArray.get(i) + positiveArray.get(j);
            if (currSum < 0) {
                if (Math.abs(currSum) < lowSum) {
                    lowSum = Math.abs(currSum);
                    el1 = negativeArray.get(i);
                    el2 = positiveArray.get(j);
                }
                i++;
            } else {
                if (currSum < lowSum) {
                    lowSum = currSum;
                    el1 = negativeArray.get(i);
                    el2 = positiveArray.get(j);
                }
                j--;
            }
        }
        if (positiveArray.size() > 1) {
            currSum = positiveArray.get(1) + positiveArray.get(0);
            if (currSum < lowSum) {
                el1 = positiveArray.get(0);
                el2 = positiveArray.get(1);
            }
        }
        if (negativeArray.size() > 1) {
            currSum = negativeArray.get(negativeArray.size()-1) + negativeArray.get(negativeArray.size()-2);
            if (Math.abs(currSum) < lowSum) {
                el1 = negativeArray.get(negativeArray.size()-1);
                el2 = negativeArray.get(negativeArray.size()-2);
            }
        }
        if (positiveArray.get(0) == 0) {
            if (negativeArray.size() > 0) {
                currSum = negativeArray.get(negativeArray.size() - 1);
                if (Math.abs(currSum) < lowSum) {
                    el1 = 0;
                    el2 = negativeArray.size() - 1;
                }
            }
        }
        return new int[]{el1, el2};
    }

    // lines of code = 25
    // O(nlogn) Space Complexity: O(1)
    private static int[] findTwoEls(int[] arr) throws Exception {
        if (arr.length < 2) throw new Exception("The no of array els is less than 2. no solution exists");
        Arrays.sort(arr);
        if(arr[0] >= 0) return new int[]{arr[0],arr[1]};
        int currSum,el1=-1,el2=-1,lowSum = Integer.MAX_VALUE;
        for (int i=0,j=arr.length-1;i<j;){
            currSum = arr[i] + arr[j];
            if(currSum<0){
                if(Math.abs(currSum) < lowSum){
                    lowSum = Math.abs(currSum);
                    el1 = arr[i];
                    el2 = arr[j];
                }
                i++;
            } else {
                if(currSum < lowSum){
                    lowSum = currSum;
                    el1 = arr[i];
                    el2 = arr[j];
                }
                j--;
            }
        }
        return new int[]{el1, el2};
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{-100, -80, 25, 35, 5};
        int[] ans = findTwoEls(arr);

        System.out.println(ans[0] + " " + ans[1]);

        int[] brr = new int[]{1, 60, -10, 70, -80, 85};
        int[] bns = findTwoEls(brr);
        System.out.println(bns[0] + " " + bns[1]);

        int[] crr = new int[]{1, 60, -10, 0, 70, -80, 85};
        int[] cns = findTwoEls(crr);
        System.out.println(cns[0] + " " + cns[1]);

        int[] drr = new int[]{1};
        int[] dns = findTwoEls(drr);
        System.out.println(dns[0] + " " + dns[1]);
    }
}
