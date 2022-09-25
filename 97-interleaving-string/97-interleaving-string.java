class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0, 0, new Boolean[s1.length()][s2.length()]);
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