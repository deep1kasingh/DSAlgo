package leetcode.importantAndUsefulLinks.dp;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        return findMinDis(word1, word2);
    }

    private int findMinDis(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=l2;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] : 1 + findMin(dp[i-1][j],dp[i][j-1], dp[i-1][j-1]);
            }
        }
        return dp[l1][l2];
    }

    private int findMin(int a, int b, int c){
        return a < b ? (a<c ? a : c): (b<c ?b:c);
    }

    public static void main(String[] args) {
        String a = "intention";
        String b= "execution";
        EditDistance ed = new EditDistance();
        System.out.println(ed.findMinDis(a, b));
    }
}
