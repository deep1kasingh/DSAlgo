package leetcode.importantAndUsefulLinks.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxlengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));
        int[] chainCount = new int[pairs.length];
        Arrays.fill(chainCount, 1);
        for(int i=0;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1] < pairs[i][0] && chainCount[i] < chainCount[j] + 1){
                    chainCount[i] = chainCount[j] + 1;
                }
            }
        }
        int maxCount =0;
        for(int i=0;i<pairs.length;i++){
            if(chainCount[i] > maxCount){
                maxCount = chainCount[i];
            }
        }
        return maxCount;
    }
}
