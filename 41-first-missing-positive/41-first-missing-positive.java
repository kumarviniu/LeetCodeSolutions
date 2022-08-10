class Solution {
    public int firstMissingPositive(int[] nums) {
        int defaultValue = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = defaultValue;
        }

        for (int num : nums) {
            int absNum = Math.abs(num);
            if (absNum >= 1 && absNum <= nums.length) {
                if (nums[absNum - 1] > 0)
                    nums[absNum - 1] *= -1;
            }
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0)
                return i;
        }
        
        return nums.length + 1;
    }
}