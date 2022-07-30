class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> index = new Stack<>();
        int idx = 0;
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            if (i == nums.length) idx = 0;
            while (!index.isEmpty() && nums[idx] > nums[index.peek()])
                result[index.pop()] = nums[idx];
            if (i < nums.length)
                index.add(idx);
            idx++;
        }

        return result;
    }
}