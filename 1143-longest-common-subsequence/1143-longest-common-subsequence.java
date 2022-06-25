class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, text1, text2, dp);
    }
    
    public int dfs(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() || j == s2.length())
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j] = 1 + dfs(i + 1, j + 1, s1, s2, dp);
        else
            dp[i][j] = Math.max(dfs(i, j + 1, s1, s2, dp), dfs(i + 1, j, s1, s2, dp));
       
        return dp[i][j];
    }
}