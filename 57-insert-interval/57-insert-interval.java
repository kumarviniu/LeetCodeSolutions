class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> result = new ArrayList<>();
        if (intervals.length == 0 || newInterval[1] < intervals[0][0]) {
            List<Integer> single = new ArrayList<>();
            single.add(newInterval[0]);
            single.add(newInterval[1]);
            result.add(single);
        }
        
        if (intervals.length > 0 && newInterval[0] > intervals[n - 1][1]) {
            intervals = Arrays.copyOf(intervals, n + 1);
            intervals[n] = new int[2];
            intervals[n][0] = newInterval[0];
            intervals[n][1] = newInterval[1];
            return intervals;
        }
                
        //merge
        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            List<Integer> out = new ArrayList<>();
            if ((newInterval[0] <= interval[1] && newInterval[0] >= interval[0]) || (interval[0] <= newInterval[1] && interval[0] >= newInterval[0])) {
                out.add(Math.min(interval[0], newInterval[0]));
                while (newInterval[1] >= interval[1] && i + 1 < n && newInterval[1] >= intervals[i + 1][0]) {
                    i++;
                interval = intervals[i];
                }
                out.add(Math.max(newInterval[1], interval[1]));
            } else if (i + 1 < n && newInterval[0] > interval[1] && newInterval[1] < intervals[i + 1][0]) {
                List<Integer> out2 = new ArrayList<>();
                out2.add(interval[0]);
                out2.add(interval[1]);
                result.add(out2);
                
                out.add(newInterval[0]);
                out.add(newInterval[1]);
            } else {
                out.add(interval[0]);
                out.add(interval[1]);
            }
            result.add(out);
        } 
       
        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }
}