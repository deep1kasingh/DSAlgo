package leetcode.importantAndUsefulLinks.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 =text1.length();
        int l2 =text2.length();
        if(l1 == 0 || l2==0) return 0;
        int[][] dp = new int[l1+1][l2+1];
        Arrays.fill(dp[0],0);
        for(int i=0;i<=l1;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                dp[i][j] = (text1.charAt(i-1) == text2.charAt(j-1)) ? 1 + max(dp[i-1][j-1], dp[i-1][j-1]) : max(dp[i-1][j], dp[i][j-1]);
            }
            System.out.println("");
        }
        return dp[l1][l2];
    }

    private int max(int a, int b){
        return a>b ? a:b;
    }

    public static void main(String[] args) {
        String a = "bsbininm";
        String b= "jmjkbkjkv";
        LCS lcs = new LCS();
        System.out.println(lcs.longestCommonSubsequence(a, b));
    }
}
