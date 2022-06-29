class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (j < k) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[j])
                dq.removeLast();
            dq.addLast(j);
            j++;
        }
        j--;
        int[] result = new int[nums.length - (k - 1)];
        int idx = 0;
        while (j < nums.length) {
            result[idx] = nums[dq.getFirst()];
            if (dq.getFirst() == i)
                dq.removeFirst();
            idx++;
            i++;
            j++;
            
            if (j < nums.length) {
                while (!dq.isEmpty() && nums[dq.getLast()] <= nums[j])
                dq.removeLast();
            dq.addLast(j);
            }
        }
        
        return result;
    }
}