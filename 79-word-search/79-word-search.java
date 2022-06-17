class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, visited, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        
        if (visited[i][j])
            return false;
        
        char c = board[i][j];
        if (word.charAt(index) != c)
            return false;
        
        visited[i][j] = true;
        
        if (index == word.length() - 1)
            return true;
        
        
        boolean result = exist(board, visited, i + 1, j, word, index + 1)
            || exist(board, visited, i - 1, j, word, index + 1)
            || exist(board, visited, i, j + 1, word, index + 1)
            || exist(board, visited, i, j - 1, word, index + 1);
        
        visited[i][j] = false;
        
        return result;
    }
}