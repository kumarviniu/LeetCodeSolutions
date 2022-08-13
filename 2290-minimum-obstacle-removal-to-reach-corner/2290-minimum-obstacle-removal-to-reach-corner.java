class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };
        Deque<Cell> q = new LinkedList<>();
        q.add(new Cell(0, 0, 0));
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            if (cell.row == grid.length - 1 && cell.col == grid[0].length - 1)
                return cell.pathObstacles;
            for (int[] direction : directions) {
                int row = cell.row + direction[0];
                int col = cell.col + direction[1];
                if (isValid(grid, row, col)) {
                    if (grid[row][col] == 0)
                        q.addFirst(new Cell(row, col, cell.pathObstacles + grid[row][col]));
                    else 
                        q.addLast(new Cell(row, col, cell.pathObstacles + grid[row][col]));
                    grid[row][col] = -1;
                }
            }
        }
        return 0;
    }
    
    boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != -1;
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