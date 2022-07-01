class Solution {
    public void rotate(int[][] matrix) {
        //transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //swap columns
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }
    
    public void reverse(int[] a) {
        for(int i = 0; i < a.length / 2; i++){
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }
}