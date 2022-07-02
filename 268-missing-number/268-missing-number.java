class Solution {
    public int missingNumber(int[] nums) {
        int result1 = 0;
        for (int num : nums)
            result1 ^= num;
        int result = 0;
        for (int i = 1; i <= nums.length; i++)
            result ^= i;
        return result ^ result1;
    }
}