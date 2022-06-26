class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> maxPq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));      
        int j = 0;
        while (j < k) {
            maxPq.add(new Pair<>(j, nums[j]));
            j++;
        }
        j--;
        int[] result = new int[nums.length - (k - 1)];
        int idx = 0;
        int i = 0;
        while (j < nums.length) {
            Pair<Integer, Integer> pair = maxPq.peek();
            while (pair.getKey() < i) {
                maxPq.poll();
                pair = maxPq.peek();
            }
            result[idx] = pair.getValue();
            if (j + 1 < nums.length)
                maxPq.add(new Pair<>(j + 1, nums[j + 1]));
            idx++;
            j++;
            i++;
        }
        return result;
    }
}