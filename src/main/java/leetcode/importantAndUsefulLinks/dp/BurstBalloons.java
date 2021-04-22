package leetcode.importantAndUsefulLinks.dp;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = nums[i];
        }
        for(int i=0;i<len-1;i++){
            dp[i][i+1] = nums[i]*nums[i+1];
        }
        for(int l=3;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j=i+l-1;
                int maxC = Integer.MIN_VALUE;
                for(int k=i+1;k<j;k++){
                    int cost = dp[i][k] + dp[k+1][j] + nums[i] * nums[k] * nums[j];
                    maxC = Integer.max(cost, maxC);
                }
                dp[i][j] = maxC;
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{3,1,5,8}));
    }
}
