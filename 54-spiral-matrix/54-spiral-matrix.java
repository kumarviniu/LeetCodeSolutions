class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int r = matrix[0].length;
        int l = 0;
        int d = matrix.length;
        int u = 1;
        int i = 0;
        int j = 0;
        
        int count = matrix.length * matrix[0].length;
        while (count > 0) {
            //go right
            while (j < r) {
                result.add(matrix[i][j]);
                j++;
                if (j == r)
                    r--;
                count--;
            }
            if (count == 0) break;
            j--;
            i++;
            
            //down
            while(i < d) {
                result.add(matrix[i][j]);
                i++;
                if (i == d)
                    d--;
                count--;
            }
             if (count == 0) break;
            i--;
            j--;
            //left
            while(j >= l) {
                result.add(matrix[i][j]);
                j--;
                if (j < l)
                    l++;
                count--;
            } 
            if (count == 0) break;
            j++;
            i--;
            //up
            while (i >= u) {
                result.add(matrix[i][j]);
                i--;
                if (i < u)
                    u++;
                count--;
            }
            if (count == 0) break;
            i++;
            j++;
        }
        return result;
    }
}