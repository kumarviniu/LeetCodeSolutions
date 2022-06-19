class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, dfs(nums, i, dp));
        return max;
    }
    
    public int dfs(int[] nums, int index, int[] dp) {
        if (index >= nums.length)
            return 0;
       
        if (dp[index] != -1)
            return dp[index];
 
        dp[index] = nums[index];
        
        for(int i = index + 2; i < nums.length; i++)
            dp[index] = Math.max(dp[index], nums[index] + dfs(nums, i, dp));
        
        return dp[index];
    }
}