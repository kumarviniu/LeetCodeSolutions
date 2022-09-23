class RandomizedSet {
    Map<Integer, Integer> valueIdxMap;
    List<Integer> values;
    Random random;
    public RandomizedSet() {
        values = new ArrayList<>();
        valueIdxMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (valueIdxMap.containsKey(val)) return false;
        values.add(val);
        valueIdxMap.put(val, values.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valueIdxMap.containsKey(val)) return false;
        int lastValue = values.get(values.size() - 1);
        int idx = valueIdxMap.get(val);
        values.set(idx, lastValue);
        valueIdxMap.put(lastValue, idx);
        values.remove(values.size() - 1);
        valueIdxMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(0, values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */