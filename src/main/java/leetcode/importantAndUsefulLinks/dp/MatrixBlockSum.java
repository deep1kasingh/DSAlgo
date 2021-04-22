package leetcode.importantAndUsefulLinks.dp;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int len = mat.length;
        int[][] leftAllSum = new int[len+1][len+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                leftAllSum[i][j] = leftAllSum[i-1][j] + leftAllSum[i][j-1] - leftAllSum[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int r1 = Integer.max(0,i-K);
                int r2 = Integer.min(len-1,i+K);
                int c1 = Integer.max(0,j-K);
                int c2 = Integer.min(len-1,j+K);
                r1++;r2++;
                c1++;c2++;
                dp[i][j] = leftAllSum[r2][c2] - leftAllSum[r2][c1-1] - leftAllSum[r1-1][c2] + leftAllSum[r1-1][c1-1];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int K=1;
        System.out.println(new MatrixBlockSum().matrixBlockSum(mat, K));
    }
}
