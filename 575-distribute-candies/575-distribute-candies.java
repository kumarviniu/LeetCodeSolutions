class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int num = 0;
        for (int type: candyType) {
            if (!set.contains(type))
                num++;
            set.add(type);
        }
        return Math.min(num, candyType.length / 2);
    }
}