class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;        
        boolean[][] dp = new boolean[2][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int currRow = i % 2;
                int prevRow= (i - 1) % 2;
                int s3Idx = i + j - 1;
              dp[currRow][j] = (i == 0 && j == 0) 
                  ||(i > 0 && s1.charAt(i - 1) == s3.charAt(s3Idx) && dp[prevRow][j])
                  || (j > 0 && s2.charAt(j - 1) == s3.charAt(s3Idx) && dp[currRow][j - 1]);
            }
        }
        return dp[s1.length() % 2][s2.length()];
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int s1Idx, int s2Idx, int s3Idx, Boolean[][] dp) {
        if (s3Idx == s3.length()) return true;        
        
        if (s1Idx < s1.length() && s2Idx < s2.length() && dp[s1Idx][s2Idx] != null)
            return dp[s1Idx][s2Idx];
        
        char s3Char = s3.charAt(s3Idx);
        boolean result = false;
        
        if (s1Idx < s1.length() && s1.charAt(s1Idx) == s3Char)
            result = isInterleave(s1, s2, s3, s1Idx + 1, s2Idx, s3Idx + 1, dp);
        
        if (!result && s2Idx < s2.length() && s2.charAt(s2Idx) == s3Char)
            result = isInterleave(s1, s2, s3, s1Idx, s2Idx + 1, s3Idx + 1, dp);
       
        if (s1Idx < s1.length() && s2Idx < s2.length())
            return dp[s1Idx][s2Idx] = result;
        return result;
    }
}