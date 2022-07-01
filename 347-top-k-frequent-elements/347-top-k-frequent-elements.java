class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (Integer num : freq.keySet()) {
            if (pq.size() < k)
                pq.add(new Pair<>(num, freq.get(num)));
            else if (pq.peek().getValue() < freq.get(num)) {
                pq.poll();
                pq.add(new Pair<>(num, freq.get(num)));
            }
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--)
            result[i] = pq.poll().getKey();
        
        return result;
    }
}