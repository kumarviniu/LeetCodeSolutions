class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (num > 0)
                set.add(num);
        for (int i = 1; i <= nums.length; i++)
            if (!set.contains(i))
                return i;
        return nums.length + 1;
    }
}