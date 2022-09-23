class FirstUnique {
    Map<Integer, Integer> freqMap;
    Set<Integer> firstUnique;
    public FirstUnique(int[] nums) {
        freqMap = new HashMap<>();
        firstUnique = new LinkedHashSet<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        for (int num : nums)
            if (freqMap.get(num) == 1)
                firstUnique.add(num);
    }
    
    public int showFirstUnique() {
        Iterator itr = firstUnique.iterator();
        return itr.hasNext() ? (int) itr.next() : -1;
    }
    
    public void add(int value) {
        freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
        if (firstUnique.contains(value))
            firstUnique.remove(value);
        else if (freqMap.get(value) == 1)
            firstUnique.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */