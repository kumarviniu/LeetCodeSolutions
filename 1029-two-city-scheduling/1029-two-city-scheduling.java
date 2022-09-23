class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] differences = new int[n][2];
        for (int i = 0; i < n; i++) {
            differences[i][0] = costs[i][1] - costs[i][0];
            differences[i][1] = i;
        }
        Arrays.sort(differences, (a, b) -> Integer.compare(a[0], b[0]));
        
        int half = n / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < half)
                sum += costs[differences[i][1]][1];
            else
                sum += costs[differences[i][1]][0];
        }
        return sum;
    }
    
    public void quickSelect(int[][] array, int l, int r, int k) {
        int idx = partition(array, l, r);
        if (idx == k) return;
        if (k > idx) quickSelect(array, idx + 1, r, k);
        quickSelect(array, l, idx - 1, k);
    }
    
    public int partition(int[][] array , int l, int r) {
        int randomPivotIdx = new Random().nextInt(l, r + 1);
        swap(array, randomPivotIdx, r);
        int i = l - 1;
        int pivot = array[r][0];
        for (int j = l; j < r; j++) {
          if (array[j][0] <= pivot) {
            i++;
            swap(array, i, j);
          }
        }
        swap(array, i + 1, r);
        return i + 1;
    }
    
    public static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}