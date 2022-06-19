class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, visited, i, j));
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if  (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || visited[i][j] || grid[i][j] == 0)
            return 0;
        visited[i][j] = true;
        return 1 + dfs(grid, visited, i - 1, j) + dfs(grid, visited, i + 1, j) + dfs(grid, visited, i, j - 1) + dfs(grid, visited, i, j + 1); 
    }
}