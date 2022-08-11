class Solution {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {

        int[] target = new int[]{grid.length - 1, grid[0].length - 1};

        Set<Entry> visited = new HashSet<>();

        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(0, 0, 0, 0));

        while (!queue.isEmpty()) {

            Entry currEntry = queue.poll();
            if (currEntry.row == target[0] && currEntry.col == target[1]) return currEntry.level;

            for (int[] dir : DIRS) {

                int nextRow = currEntry.row + dir[0];
                int nextCol = currEntry.col + dir[1];

                boolean inBound = nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length;
                if (inBound) {

                    int newObstacles = currEntry.obstacles + grid[nextRow][nextCol];
                    if (newObstacles <= k) {

                        Entry newEntry = new Entry(nextRow, nextCol, newObstacles, currEntry.level + 1);
                        if (!visited.contains(newEntry)) {
                            visited.add(newEntry);
                            queue.offer(newEntry);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static class Entry {
        int row;
        int col;
        int obstacles;
        int level;

        Entry(int row, int col, int obstacles, int level) {

            this.row = row;
            this.col = col;
            this.obstacles = obstacles;
            this.level = level;
        }

        public boolean equals(Object that) {
            if (that == null) return false;
            if (this == that) return true;

            Entry entry = (Entry) that;
            return Objects.equals(this.row, entry.row) && Objects.equals(this.col, entry.col) && Objects.equals(this.obstacles, entry.obstacles);
        }

        public int hashCode() {
            return Objects.hash(row, col, obstacles);
        }
    }
}