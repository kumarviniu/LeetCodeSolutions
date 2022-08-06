import java.math.BigInteger;
class Solution {
    public int uniquePaths(int m, int n) {
        int min = m < n ? m : n;
        int max = m >= n ? m : n;
        int[][] dp = new int[2][min];
        dp[(max - 1) % 2][min - 1] = 1;
        for (int i = max - 1; i >= 0; i--) {
          for (int j = min - 1; j >= 0; j--) {
            int currentRow = i % 2;
            int nextRow = (i + 1) % 2;
            if (i + 1 < max)
              dp[currentRow][j] = dp[nextRow][j];
            if (j + 1 < min)
              dp[currentRow][j] += dp[currentRow][j + 1];
          }
        }
        return dp[0][0];
    }
}