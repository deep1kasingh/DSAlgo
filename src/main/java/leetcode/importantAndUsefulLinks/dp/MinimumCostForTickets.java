package leetcode.importantAndUsefulLinks.dp;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int endDay = days[len-1];
        int[] dp = new int[endDay+1];
        dp[1]=costs[0];
        for(int i=2;i<=endDay;i++){
            int minV = Integer.MAX_VALUE;
            minV = Integer.min(costs[0] + dp[i-1], minV);
            if(i <= 7) {
                minV = Integer.min(costs[1], minV);
            } else {
                minV = Integer.min(costs[1] + dp[i-7], minV);
            }
            if(i <= 30){
                minV = Integer.min(costs[2], minV);
            } else {
                minV = Integer.min(costs[2] + dp[i-30], minV);
            }
            dp[i]=minV;
        }
        return dp[endDay];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostForTickets().mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println((int)Math.sqrt(12));
        System.out.println(1*2);
    }
}

