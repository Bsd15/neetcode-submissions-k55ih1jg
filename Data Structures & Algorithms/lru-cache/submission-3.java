class LRUCache {

private class Node {
        int key;
        int value;
        Node prev, next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private int capacity;
    private Node head, tail;
    private int size = 0;
    private final Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>(this.capacity);
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
        if (this.size == 0) {
            Node node = new Node();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            ++this.size;
            this.head = node;
            this.tail = node;
        }
        else {
            if (this.cache.containsKey(key)) {
                Node node = this.cache.get(key);
                node.value = value;
                setTail(node);
            } else {
                if  (this.size == this.capacity) {
                    this.size--;
                    Node temp = this.head;
                    this.head = this.head.next;
                    if (this.head != null) {
                        this.head.prev = null;
                    }
                    temp.next = null;
                    this.cache.remove(temp.key);
                }
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                newNode.prev = this.tail;
                this.cache.put(key, newNode);
                ++this.size;
                this.tail.next = newNode;
                this.tail = newNode;
            }
        }
    }

    private void setTail(Node node) {
        if (this.tail == node) {
            return;
        }

        if (node == this.head) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = this.tail;
        node.next = null;
        this.tail.next = node;
        this.tail = node;
    }
}
