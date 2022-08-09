class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                max = Math.max(max, dfs(matrix, -1, i, j, dp));
        }
        return max;
    }
    
    int dfs(int[][] matrix, int prev, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev)
            return 0;
        
        if (dp[i][j] != null)
            return dp[i][j];
        
        int left = dfs(matrix, matrix[i][j], i, j - 1, dp);
        int right = dfs(matrix, matrix[i][j], i, j + 1, dp);
        int top = dfs(matrix, matrix[i][j], i - 1, j, dp);
        int bottom = dfs(matrix, matrix[i][j], i + 1, j, dp);
        
        return dp[i][j] = 1 + Math.max(left, Math.max(right, Math.max(top, bottom)));
    }
}