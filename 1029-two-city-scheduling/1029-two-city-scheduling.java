class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        return dfs(costs, n, 0, 0, 0, new int[n + 1][n + 1]);
    }
    
    int dfs(int[][] costs, int n, int i, int aCount, int bCount, int[][] dp) {
        if (i >= costs.length) return 0;
        if (dp[aCount][bCount] != 0) return dp[aCount][bCount];
        int a = 0;
        int b = 0;
        if (aCount < n)
            a = costs[i][0] + dfs(costs, n, i + 1, aCount + 1, bCount, dp);
        else
            return dp[aCount][bCount] = costs[i][1] + dfs(costs, n, i + 1, aCount, bCount + 1, dp);
        
        if (bCount < n)
            b = costs[i][1] + dfs(costs, n, i + 1, aCount, bCount + 1, dp);
        else
            return dp[aCount][bCount] = costs[i][0] + dfs(costs, n, i + 1, aCount + 1, bCount, dp);
        return dp[aCount][bCount] = Math.min(a, b);
    }
}