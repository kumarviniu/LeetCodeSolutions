class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int target = sum / 2;
        return canPartition(nums, target);
    }
    
    public boolean canPartition(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0)
                    dp[i][j] = true;
                else if (j - nums[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][target];
    }   
}