class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int num = 0;
        int target = candyType.length / 2;
        for (int type: candyType) {
            if (!set.contains(type))
                num++;
            if (num == target)
                return num;
            set.add(type);
        }
        return num;
    }
}