class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            Integer ceil = set.ceiling(i);
            if (ceil != null && ceil != i) {
                set.remove(ceil);
            }
            set.add(i);
        }
        return set.size();
    }
}