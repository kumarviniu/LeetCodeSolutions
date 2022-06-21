class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        dfs(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }
    
    public int dfs(int[] cost, int i, int[] dp) {
        if (i == cost.length - 1) {
            dp[i] = cost[i];
            return cost[i];
        }
        
        if (i >= cost.length)
            return 0;
        
        if (dp[i] != -1)
            return dp[i];
        
        return dp[i] = cost[i] + Math.min(dfs(cost, i + 1, dp), dfs(cost, i + 2, dp));
    }
}