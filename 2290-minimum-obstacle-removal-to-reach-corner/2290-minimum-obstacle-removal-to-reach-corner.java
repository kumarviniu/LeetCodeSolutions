class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };
        Integer[][] minObstacles = new Integer[grid.length][grid[0].length];
        PriorityQueue<Cell> q = new PriorityQueue<>((a, b) -> Integer.compare(a.pathObstacles, b.pathObstacles));
        int minObstaclesToReach = grid.length + grid[0].length;
        q.add(new Cell(0, 0, 0));
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            if (cell.row == grid.length - 1 && cell.col == grid[0].length - 1)
                minObstaclesToReach = Math.min(minObstaclesToReach, cell.pathObstacles);
            for (int[] direction : directions) {
                int row = cell.row + direction[0];
                int col = cell.col + direction[1];
                if (isValid(grid, row, col)) {
                    int newObstacles = cell.pathObstacles + grid[row][col];
                    if (minObstacles[row][col] == null || minObstacles[row][col] > newObstacles) {
                        minObstacles[row][col] = newObstacles;
                        q.add(new Cell(row, col, newObstacles));
                    }
                }
            }
        }
        return minObstaclesToReach;
    }
    
    boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
    
    class Cell {
        int row;
        int col;
        int pathObstacles = 0;
        
        Cell(int i, int j, int o) {
            row = i;
            col = j;
            pathObstacles = o;
        }
    }
}