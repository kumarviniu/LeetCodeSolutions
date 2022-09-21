class Solution {
    public int findPeakElement(int[] nums) {
        return peak(nums, 0, nums.length - 1);
    }
    
    public int peak(int[] nums, int l, int r) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        if ((m - 1 < 0 || nums[m] > nums[m - 1]) && (m + 1 == nums.length || nums[m] > nums[m + 1])) 
            return m;
        if (m - 1 >= 0 && nums[m - 1] > nums[m]) 
            return peak(nums, l, m - 1);
        return peak(nums, m + 1, r);
    }
}