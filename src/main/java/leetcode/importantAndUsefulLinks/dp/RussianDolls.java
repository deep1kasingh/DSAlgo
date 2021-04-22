package leetcode.importantAndUsefulLinks.dp;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class RussianDolls {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));
        int[] envelopeCount = new int[envelopes.length];
        Arrays.fill(envelopeCount, 1);
        for(int i=0;i<envelopes.length;i++){
            for(int j=0;j<i;j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && envelopeCount[i] < 1+envelopeCount[j])                 {
                    envelopeCount[i] = 1+envelopeCount[j];
                }
            }
        }
        int maxCount = 0;
        for(int i=0;i<envelopeCount.length;i++){
            if(envelopeCount[i] > maxCount){
                maxCount = envelopeCount[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{5,4},{6,7},{6,4},{2,3}};

        Arrays.sort(input, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));

        for (int[] a: input) {
            System.out.println(a[0] + "," + a[1]);
        }
    }
}
