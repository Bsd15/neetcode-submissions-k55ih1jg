class TimeMap {
    private Map<String, List<Map.Entry<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map
        .computeIfAbsent(key, (k) -> new ArrayList<>())
        .add(Map.entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) {
            return "";
        }

        var entries = this.map.get(key);
        int l = 0;
        int r = entries.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + ((r - l)/2);
            var entry = entries.get(m);
            if (entry.getKey() <= timestamp) {
                res = entry.getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
