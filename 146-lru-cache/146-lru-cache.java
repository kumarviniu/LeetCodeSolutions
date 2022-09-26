class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
   
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Integer value = cache.remove(key);
        cache.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (get(key) == -1) {
            if (capacity > 0)
                capacity--;
            else
                cache.remove(cache.keySet().iterator().next()); 
        }
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */