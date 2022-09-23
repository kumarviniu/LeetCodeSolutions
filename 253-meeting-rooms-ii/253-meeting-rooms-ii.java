class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Queue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int minRooms = 0;
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval[0]) pq.poll();
            pq.add(interval[1]);
            minRooms = Math.max(minRooms, pq.size());
        }
        return minRooms;
    }
}