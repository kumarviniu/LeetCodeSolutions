class Solution {
    public int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> dp = new HashMap<>();
        min = Math.min(min, dfs(coins, amount, dp));
        return min == Integer.MAX_VALUE - 1 ? -1 : min;
    }
    
    public int dfs(int[] coins, int amount, Map<Integer, Integer> dp) {
        if (amount == 0)
            return 0;
        
        if (dp.containsKey(amount))
            return dp.get(amount);
        
        int total = Integer.MAX_VALUE - 1;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                total = Math.min(total, 1 + dfs(coins, amount - coins[i], dp));
            }
        }
        dp.put(amount, total);
        return total;
    }
}