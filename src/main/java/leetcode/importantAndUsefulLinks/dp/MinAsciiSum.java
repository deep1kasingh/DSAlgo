package leetcode.importantAndUsefulLinks.dp;

public class MinAsciiSum {
    public int minimumDeleteSum(String s1, String s2) {
        return deleteMinSum(s1, s2);
    }

    private int deleteMinSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0]=0;
        for(int i=1;i<=l1;i++){
            dp[i][0] = s1.charAt(i-1);
        }
        for(int j=1;j<=l2;j++){
            dp[0][j] = s2.charAt(j-1);
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                int sum1 = s1.charAt(i-1) + dp[i-1][j];
                int sum2 = s2.charAt(j-1) + dp[i][j-1];
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = minThree(sum1, sum2,dp[i-1][j-1]);
                } else {
                    dp[i][j] = min(sum1, sum2);
                }
            }
        }
        return dp[l1][l2];
    }

    private int min(int a, int b){
        return a<b?a:b;
    }

    private int minThree(int a, int b, int c){
        return (a<b)?(a<c?a:c):(b<c?b:c);
    }

    public static void main(String[] args) {
        String a = "delete";
        String b= "lete";
        MinAsciiSum mas = new MinAsciiSum();
        System.out.println(mas.deleteMinSum(a, b));
    }
}
