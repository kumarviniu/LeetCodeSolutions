class Solution {
    public int countSubstrings(String s) {
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            int total = 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                total += 1;
            }
            
            result += total;
            
            total = 0;
            j = i - 1;
            k = i;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                total += 1;
            }
            
            result += total;
        }
        return result;
    }
}