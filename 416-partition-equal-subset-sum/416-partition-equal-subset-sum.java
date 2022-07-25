class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        return canPartition(0, target, nums, dp);
    }
    
    public boolean canPartition(int idx, int target, int[] nums, int[][] dp) {
        if (target == 0)
            return true;
        if (idx >= nums.length)
            return false;
        if (dp[idx][target] != 0)
            return dp[idx][target] == 1 ? true : false;

        if ((target - nums[idx] >= 0 && canPartition(idx + 1, target - nums[idx], nums, dp)) || canPartition(idx + 1, target, nums, dp)) {
            dp[idx][target] = 1;
            return true;
        }
        
        dp[idx][target] = 2;
        return false;
    }
    
}