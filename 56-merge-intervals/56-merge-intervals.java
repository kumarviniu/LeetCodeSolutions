class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //merge intervals if needed
            int j = i + 1;
            int maxEnd = intervals[i][1];
            while (j < intervals.length && maxEnd >= intervals[j][0]) {
                maxEnd = Math.max(maxEnd, intervals[j][1]);
                j++;
            }
            
            List<Integer> out = new ArrayList<>();
            out.add(intervals[i][0]);
            out.add(maxEnd);
            result.add(out);
            
            i = j - 1;
        }
        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }
}