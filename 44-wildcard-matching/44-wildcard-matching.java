class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (i == 0)
                    dp[i][j] = j == 0;
                else if (j == 0)
                    dp[i][j] = p.charAt(i - 1) == '*' ? dp[i - 1][0] : false;
                else if (p.charAt(i - 1) ==  '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[p.length()][s.length()];
    }
}