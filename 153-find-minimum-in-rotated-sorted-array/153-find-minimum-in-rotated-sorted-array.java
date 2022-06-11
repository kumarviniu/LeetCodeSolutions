class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (l == r)
                break;
            if (m - 1 >=0 && nums[m] < nums[m - 1])
                return nums[m];
            if (nums[m] < nums[r])
                r = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
}