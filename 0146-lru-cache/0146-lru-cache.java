class LRUCache {
    public Deque<Integer> dq;
    public HashMap<Integer, Integer> map;
    public int cacheSizeLimit;

    public LRUCache(int capacity) {
        dq = new ArrayDeque<>();
        map = new HashMap<>();
        cacheSizeLimit = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        handleDeque(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        handleDeque(key);
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if (map.size() > cacheSizeLimit) {
            int lru = dq.pollLast();
            map.remove(lru);
        }
    }

    public void handleDeque(int key) {
        dq.remove(key);
        dq.offerFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */