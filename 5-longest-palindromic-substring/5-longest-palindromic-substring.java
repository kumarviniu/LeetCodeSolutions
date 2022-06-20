class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            int total = 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                total += 2;
            }
            
            if (total > max) {
                max = total;
                longest = s.substring(j + 1, k);
            }
            
            total = 0;
            j = i - 1;
            k = i;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                total += 2;
            }
            
            if (total > max) {
                max = total;
                longest = s.substring(j + 1, k);
            }
        }
        return longest;
    }
}