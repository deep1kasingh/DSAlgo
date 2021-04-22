package leetcode.importantAndUsefulLinks.dp;

public class MInCostTree {
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        int[][] maxLeaf = new int[len][len];
        for(int i=0;i<len;i++){
            int maxL = arr[i];
            for(int j=i;j<len;j++){
                if(arr[j] > maxL){
                    maxL=arr[j];
                }
                maxLeaf[i][j] = maxL;
            }
        }
        for(int l=2;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j = i+l-1;
                int minC = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost = dp[i][k] + dp[k+1][j] + maxLeaf[i][k]*maxLeaf[k+1][j];
                    minC = Integer.min(minC, cost);
                }
                dp[i][j] = minC;
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,2,4};
        System.out.println(new MInCostTree().mctFromLeafValues(arr));
    }
}
