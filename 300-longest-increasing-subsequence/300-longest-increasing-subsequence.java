class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i, dp));
        }
        return max;
    }
    
    int dfs(int[] nums, int index, int[] dp) {
        if (index == nums.length - 1)
            return 1;
        
        if (dp[index] != 0)
            return dp[index];
        
        dp[index] = 1;
        
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                dp[index] = Math.max(dp[index], 1 + dfs(nums, i, dp));
            }
        }
        return dp[index];
    }
}