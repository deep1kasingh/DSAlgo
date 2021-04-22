package leetcode.importantAndUsefulLinks.dp;

public class Palindromepartitioning {
    public int minCut(String s) {
        return findMinCuts(s);
    }

    private int findMinCuts(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[][] minPartitions = new int[len][len];
        // make the dp calculating which are the substrings which form a palindrome
        // set the values as true, where a palindrome is formed in the subset[i,j+1]
        //initialise the palindrome at index [i][i] as true
        // TC: O(n^2)
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        // loop over the length of the possible palindromes, starting from length = 2
        // vary the start index, i and according to the length vary the end index j
        // int[][] minPArtitions keeps the min partitions required in the substring [i,j+1]
        // if it is a palindrome, 0 partitions required
        // fill the minPartitions as Integer.MAX_VALUE, in case no palindrome is possible for the subset
        for(int l=2;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j= i+l-1;
                boolean checkIfEqual = s.charAt(j) == s.charAt(i);
                if(l==2){
                    if(checkIfEqual) dp[i][j]=true;

                } else {
                    // if the start and end characters match, and the string excluding the start and end character is a palindrome, then the whole substring(i,j+1) is a palindrome
                    dp[i][j] = checkIfEqual && dp[i+1][j-1];
                }
                if(dp[i][j]){
                    //min partition is 0, if the substring is a palindrome
                    minPartitions[i][j]= 0;
                } else {
                    minPartitions[i][j] = Integer.MAX_VALUE;
                    // caluculate the min partitions over all the possible partitions between i and j, varied by the variable k.
                    for(int k=i;k<j;k++){
                        minPartitions[i][j] = Integer.min(minPartitions[i][k] + minPartitions[k+1][j] +1,minPartitions[i][j]);
                    }
                }
            }
        }
        printDp(dp);
        return minPartitions[0][len-1];

    }

    public static void main(String[] args) {
        String input = "geek";
        Palindromepartitioning pp = new Palindromepartitioning();
        System.out.println(pp.minCut(input));
    }

    private void printDp(boolean[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        Integer.min( Integer.min(1,2),3);
    }
}
