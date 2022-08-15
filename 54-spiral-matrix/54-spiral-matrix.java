class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        List<Integer> traversalList = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {
            //traverse right
            for (int i = startCol; i <= endCol; i++)
                traversalList.add(matrix[startRow][i]);

            //traverse down
            for (int i = startRow + 1; i <= endRow; i++)
                        traversalList.add(matrix[i][endCol]);

            //traverse left
            if (startRow != endRow)
                for (int i = endCol - 1; i >= startCol; i--)
                    traversalList.add(matrix[endRow][i]);

            //traverse up
            if (startCol != endCol)
                for (int i = endRow - 1; i > startRow; i--)
                    traversalList.add(matrix[i][startCol]);

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return traversalList;
    }
}