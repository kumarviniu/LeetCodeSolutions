class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (k >= grid.length + grid[0].length)
            return getH(grid, 0, 0);
        Integer[][] remainingObstacles = new Integer[grid.length][grid[0].length];
        int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };
        PriorityQueue<Cell> q = new PriorityQueue<>((a, b) ->  { 
            int result = Integer.compare(a.fScore, b.fScore);
            if (result == 0)
                result = Integer.compare(a.pathObstacles, b.pathObstacles);
            return result;
        });
        q.add(new Cell(0, 0, 0, 0, getH(grid, 0, 0)));
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
                        q.add(new Cell(row, col, newObstacles, cell.path + 1, getH(grid, row, col)));
                    }
                }
            }
        }
        return -1;
    }
    
    int getH(int[][] grid, int row, int col) {
        int endRow = grid.length - 1;
        int endCol = grid[0].length - 1;
        return Math.abs(endRow - row) + Math.abs(endCol - col);
    }
    
    boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
    
    class Cell {
        int row;
        int col;
        int pathObstacles = 0;
        int path = 0;
        int pathToEnd;
        int fScore;
        
        Cell(int i, int j, int o, int g, int h) {
            row = i;
            col = j;
            pathObstacles = o;
            path = g;
            fScore = g + h;
        }
    }
}