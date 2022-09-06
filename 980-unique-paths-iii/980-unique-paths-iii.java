class Solution {
    public int uniquePathsIII(int[][] grid) {
        int nonObstacleCells = getNonObstacles(grid);
        int[] startingSquare = getStartingSquare(grid);
        return dfs(grid, nonObstacleCells + 1, startingSquare[0], startingSquare[1]);
    }
    
    public int dfs(int[][] grid, int nonObstacleCells, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == -1)
            return 0;
        
        if (grid[row][col] == 2) {
            if (nonObstacleCells == 0) return 1;
            return 0;
        }
        
        grid[row][col] = -1;
        
        int result = dfs(grid, nonObstacleCells - 1, row + 1, col)
            + dfs(grid, nonObstacleCells - 1, row - 1, col)
            + dfs(grid, nonObstacleCells - 1, row, col + 1)
            + dfs(grid, nonObstacleCells - 1, row, col - 1);
        
        grid[row][col] = 0;
        
        return result;
    }
    
    int getNonObstacles(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
    
    int[] getStartingSquare(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return new int[] {i, j};
            }
        }
        return new int[0];
    }
}