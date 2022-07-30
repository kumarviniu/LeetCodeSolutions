class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!index.isEmpty() && nums[i] > nums[index.peek()])
                result[index.pop()] = nums[i];
            index.add(i);
        }

        for (int j : nums) {
            while (!index.isEmpty() && j > nums[index.peek()]) 
                result[index.pop()] = j;
        }

        while (!index.isEmpty()) 
            result[index.pop()] = -1;

        return result;
    }
}