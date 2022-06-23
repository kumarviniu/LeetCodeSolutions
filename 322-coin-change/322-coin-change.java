class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE - 1;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            boolean found = false;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
     return dp[amount] != Integer.MAX_VALUE - 1 ? dp[amount] : -1;   
    }
}