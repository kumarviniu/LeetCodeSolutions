class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int target = candyType.length / 2;
        for (int type: candyType) {
            set.add(type);
            if (set.size() == target)
                return target;
        }
        return set.size();
    }
}