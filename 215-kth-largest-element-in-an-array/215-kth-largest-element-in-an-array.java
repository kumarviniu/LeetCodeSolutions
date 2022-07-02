class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            if (pq.size() < k)
                pq.add(num);
            else if (pq.peek() <= num) {
                pq.add(num);
                pq.poll();
            }
        }
        return pq.peek();
    }
}