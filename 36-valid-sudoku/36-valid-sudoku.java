class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> haveSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                String row = i + "-" + board[i][j] + "row";
                String col = j + "-" + board[i][j] + "col";
                String box = (i / 3) + "," + (j / 3) + "-" + board[i][j] + "box";
                if (haveSet.contains(row)
                   || haveSet.contains(col)
                   || haveSet.contains(box))
                    return false;
                haveSet.add(row);
                haveSet.add(col);
                haveSet.add(box);
            }
        }
        return true;
    }
}