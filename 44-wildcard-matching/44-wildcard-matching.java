class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, new Boolean[p.length()][s.length()]);
    }
    
    public boolean isMatch(String s, String p, int pIdx, int sIdx, Boolean[][] dp) {
        //pattern is empty, but string isn't
        if (pIdx >= p.length() && sIdx >= s.length())
            return true;
        
        if (pIdx >= p.length())
            return false;
        
        //string is empty, but pattern isnt
        if (pIdx < p.length() && sIdx >= s.length()) {
            for (int i = pIdx; i < p.length(); i++)
                if (p.charAt(i) != '*')
                    return false;
            return true;
        }
        
        //pattern's last element is *, so don't care about string
        if (pIdx == p.length() - 1) {
            if (p.charAt(pIdx) == '*')
                return true;
        }
        
        if (dp[pIdx][sIdx] != null)
            return dp[pIdx][sIdx];
        
        //if any other character and doesn't match
        if (p.charAt(pIdx) != '*' && p.charAt(pIdx) != '?') {
             if(p.charAt(pIdx) != s.charAt(sIdx))
                return dp[pIdx][sIdx] = false;
            return dp[pIdx][sIdx] = isMatch(s, p, pIdx + 1, sIdx + 1, dp);
        }
        
        //if ?
        if (p.charAt(pIdx) == '?') {
            if (sIdx >= s.length())
                return dp[pIdx][sIdx] = false;
            return dp[pIdx][sIdx] = isMatch(s, p, pIdx + 1, sIdx + 1, dp);
        }
        
        return dp[pIdx][sIdx] = isMatch(s, p, pIdx + 1, sIdx, dp) || isMatch(s, p, pIdx, sIdx + 1, dp);
    }
}