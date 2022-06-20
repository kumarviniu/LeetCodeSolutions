class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), result);
        return result;
    }
    
    public void permute(int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int k = 0; k < nums.length; k++) {
            if (!curr.contains(nums[k])) {
                curr.add(nums[k]);
                permute(nums, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}