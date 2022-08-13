class Solution {
    public int shortestPath(int[][] grid, int k) {
        Integer[][] remainingObstacles = new Integer[grid.length][grid[0].length];
        int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0, 0, 0,0));
        remainingObstacles[0][0] = 0;
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            if (cell.row == grid.length - 1 && cell.col == grid[0].length - 1)
                return cell.path;
            for (int i = 0; i < directions.length; i++) {
                int row = cell.row + directions[i][0];
                int col = cell.col + directions[i][1];
                if (isValid(grid, row, col)) {
                    int newObstacles = cell.pathObstacles + grid[row][col];
                    int newRemainingObstacles = k - (cell.pathObstacles + grid[row][col]);
                    if (newObstacles <= k && (remainingObstacles[row][col] == null || newRemainingObstacles > remainingObstacles[row][col])) {
                        remainingObstacles[row][col] = newRemainingObstacles;
                        q.add(new Cell(row, col, cell.pathObstacles + grid[row][col], cell.path + 1));
                    }
                }
            }
        }
        return -1;
    }
    
    boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
    
    class Cell {
        int row;
        int col;
        int pathObstacles = 0;
        int path = 0;
        
        Cell(int i, int j, int o, int p) {
            row = i;
            col = j;
            pathObstacles = o;
            path = p;
        }
    }
}