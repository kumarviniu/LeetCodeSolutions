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
}