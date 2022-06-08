class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int[] count = new int[26];
        int max = 0;
        int currentMax = 0;
        int windowSize = (r - l) + 1;
        while (r < s.length() && l < s.length()) {
            currentMax = Math.max(++count[countIndex(s, r)], currentMax);
            windowSize = (r - l) + 1;
            if (windowSize - currentMax <= k)
                max = Math.max(max, windowSize);
            else 
                count[countIndex(s, l++)]--;
            
            r++;
        }
        return max;
    }
    
    public int countIndex(String s, int index) {
        return s.charAt(index) - 'A';
    }
}