class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] lastInterval = intervals[0];
        result.add(lastInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(intervals[i][1], lastInterval[1]);
                result.set(result.size() - 1, lastInterval);
            } else {
                result.add(intervals[i]);
                lastInterval = intervals[i];
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}