class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= i - length) {
                length = i - map.get(c);
            } else {
                length++;
            }
            map.put(c, i);
            max = Math.max(max, length);
        }
        return max;
    }
}