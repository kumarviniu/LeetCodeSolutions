class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> result = new ArrayList<>();
        boolean isMerged = false;
        for (int i = 0; i < n; i++) {
            if (newInterval[1] < intervals[i][0]) {
                isMerged = true;
                List<Integer> out = new ArrayList<>();
                out.add(newInterval[0]);
                out.add(newInterval[1]);
                result.add(out);
                while(i < n) {
                    out = new ArrayList<>();
                    out.add(intervals[i][0]);
                    out.add(intervals[i][1]);
                    result.add(out);
                    i++;
                }
            } else if (newInterval[0] > intervals[i][1]) {
                List<Integer> out = new ArrayList<>();
                out.add(intervals[i][0]);
                out.add(intervals[i][1]);
                result.add(out);
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        if (!isMerged) {
            List<Integer> out = new ArrayList<>();
            out.add(newInterval[0]);
            out.add(newInterval[1]);
            result.add(out);
        }
        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }
}