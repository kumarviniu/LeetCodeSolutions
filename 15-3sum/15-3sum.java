class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = a + nums[j] + nums[k];
                if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(a);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    out.add(triplet);
                    j++;
                    while (j < n && nums[j] == nums[j - 1]) j++;
                }
            }

        }

        return out;
    }
}