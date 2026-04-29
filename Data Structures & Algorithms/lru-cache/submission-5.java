class LRUCache {

private class Node {
        int key;
        int value;
        Node prev, next;
    }

    private int capacity;
    private Node head, tail;
    private int size = 0;
    private final Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>(this.capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (this.size == 0 || !this.cache.containsKey(key)) {
            return -1;
        }
        Node node = this.cache.get(key);
        this.setTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            node.value = value;
            this.setTail(node);
        } else {
            if  (this.size == this.capacity) {
                Node temp = this.head.next;
                this.head.next = this.head.next.next;
                this.head.next.prev = this.head;
                this.cache.remove(temp.key);
                this.size--;
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            this.setTail(node);
            ++this.size;
        }
    }

    private void setTail(Node node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
        node.next = tail;
    }
}