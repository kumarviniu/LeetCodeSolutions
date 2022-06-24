class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int sufix = 1;
        int max = Integer.MIN_VALUE;
          
        for (int i = 0; i < nums.length; i++) {
            prefix *= nums[i];
            sufix *= nums[nums.length - i - 1];
            max = Math.max(max, Math.max(prefix, sufix));
            
            prefix = prefix == 0 ? 1 : prefix;
            sufix = sufix == 0 ? 1 : sufix;
        }
        
        return max;
    }
}