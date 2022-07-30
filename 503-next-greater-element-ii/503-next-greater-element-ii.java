class Solution {
       public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> values = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!values.isEmpty() && nums[i] > values.peek()) {
                values.pop();
                result[index.pop()] = nums[i];
            }
            values.add(nums[i]);
            index.add(i);
        }

        for (int j : nums) {
            while (!values.isEmpty() && j > values.peek()) {
                values.pop();
                result[index.pop()] = j;
            }
        }

        while (!values.isEmpty()) {
            values.pop();
            result[index.pop()] = -1;
        }

        return result;
    }
}