class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxL = height[l];
        int maxR = height[r];
        int sum = 0;
        while (l <= r) {
            if (maxL < maxR) {
                sum += Math.max(maxL - height[l], 0);
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                sum += Math.max(maxR - height[r], 0);
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }
        return sum;
    }
}