class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
     
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        
        dp.add(0);
        
        for (int num : nums) {
            Set<Integer> cloneSet = new HashSet<>(dp);
            for (Integer val : dp) {
                if (val + num == target)
                    return true;
                cloneSet.add(val + num);
            }
            dp.addAll(cloneSet);
        }
        return false;
    }
}