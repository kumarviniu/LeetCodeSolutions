class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String minLengthString = text1.length() < text2.length() ? text1 : text2;
        String maxLengthString = text1.length() >= text2.length() ? text1 : text2;
        int[][] dp = new int[2][minLengthString.length() + 1];
        for (int i = 1; i <= maxLengthString.length(); i++) {
            for (int j = 1; j <= minLengthString.length(); j++) {
                int currentRow = i % 2;
                int lastRow = (i - 1) % 2;
                if (maxLengthString.charAt(i - 1) == minLengthString.charAt(j - 1))
                    dp[currentRow][j] = 1 + dp[lastRow][j - 1];
                else 
                    dp[currentRow][j] = Math.max(dp[lastRow][j], dp[currentRow][j - 1]);
            }
        }
        return dp[maxLengthString.length() % 2][minLengthString.length()];
    }
}