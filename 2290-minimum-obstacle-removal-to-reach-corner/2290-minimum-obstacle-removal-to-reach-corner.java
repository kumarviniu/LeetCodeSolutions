class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<Cell> q = new ArrayDeque<>(grid.length * grid[0].length);
        int minObstaclesToReach = grid.length + grid[0].length;
        q.add(new Cell(0, 0, 0));
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            if (cell.row == grid.length - 1 && cell.col == grid[0].length - 1)
                return cell.pathObstacles;
            for (int[] direction : directions) {
                int row = cell.row + direction[0];
                int col = cell.col + direction[1];
                if (isValid(grid, row, col)) {
                    int newObstacles = cell.pathObstacles + grid[row][col];
                    if (!visited[row][col]) {
                        visited[row][col] = true;
                        if (grid[row][col] == 0)
                            q.addFirst(new Cell(row, col, newObstacles));
                        else 
                            q.addLast(new Cell(row, col, newObstacles));
                    }
                }
            }
        }
        return 0;
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