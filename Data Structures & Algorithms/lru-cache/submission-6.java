class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity + 1);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (!this.cache.containsKey(key)) {
            return -1;
        }

        Node node = this.cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;

            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;

            this.cache.put(key, node);

            if (this.cache.size() > this.capacity) {
                node = this.tail.prev;
                this.cache.remove(node.key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
        }
    }

    private void moveToHead(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    private class Node {
        int key;
        int value;
        Node prev, next;
    }
}
