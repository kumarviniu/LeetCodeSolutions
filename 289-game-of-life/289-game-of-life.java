class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = getUpdatedValue(board, i, j);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 1;
                else if (board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }
    
    int getUpdatedValue(int[][] board, int i, int j) {
        if (board[i][j] == 0) {
            return getLiveNeighborsCount(board, i, j) == 3 ? 3 : 0;
        } else if (board[i][j] == 1) {
            int liveNeighbors = getLiveNeighborsCount(board, i, j);
            if (liveNeighbors < 2 || liveNeighbors > 3)
                return 2;
            return 1;
        }
        return board[i][j];
    }
    
    int getLiveNeighborsCount(int[][] board, int i, int j) {
        int liveNeighbors = 0;
            //left
            if (isOne(board, i, j -1))
                liveNeighbors++;
            //right
            if (isOne(board, i, j + 1))
                liveNeighbors++;
            //top
            if (isOne(board, i - 1, j))
                liveNeighbors++;
            //bottom
            if (isOne(board, i + 1, j))
                liveNeighbors++;
            //top-left
            if (isOne(board, i - 1, j - 1))
                liveNeighbors++;
            //top-right
            if (isOne(board, i - 1, j + 1))
                liveNeighbors++;
            //bottom-left
            if (isOne(board, i + 1, j - 1))
                liveNeighbors++;
            //bottom-right
            if (isOne(board, i + 1, j + 1))
                liveNeighbors++;
        return liveNeighbors;
    }
    
    boolean isOne(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] == 1 || board[i][j] == 2);
    }
}