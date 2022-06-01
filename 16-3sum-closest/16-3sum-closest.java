class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) r--;
                else if (sum < target) l++;
                else return sum;
                if (result == Integer.MAX_VALUE)
                    result = sum;
                else if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
