class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (binarySearch(matrix[m], target))
                return true;
            if (target < matrix[m][0])
                j = m - 1;
            else
                i = m + 1;
        }
        return false;
    }
    
    boolean binarySearch(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;
        if (target < array[i] || target > array[j])
            return false;
        while (i <= j) {
            int m = (i + j) / 2;
            if (array[m] == target)
                return true;
            if (target > array[m])
                i = m + 1;
            else
                j = m - 1;
        }
        return false;
    }
}