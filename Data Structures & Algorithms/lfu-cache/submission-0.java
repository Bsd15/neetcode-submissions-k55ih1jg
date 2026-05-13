class LFUCache {
    private final int capacity;
    private final Map<Integer, Node> nodeMap;
    private final Map<Integer, DoublyLinkedList> listMap;
    private int size;
    private int lfuCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(capacity);
        this.listMap = new HashMap<>(capacity);
        this.size = 0;
        this.lfuCount = 0;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (this.size == this.capacity) {
                DoublyLinkedList list = listMap.get(this.lfuCount);
                Node node = list.removeFromHead();
                this.nodeMap.remove(node.key);
                --this.size;
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            listMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addToTail(node);
            this.lfuCount = 1;
            this.size++;
        }
    }

    private void updateFrequency(Node node) {
        DoublyLinkedList list = listMap.get(node.freq);
        list.remove(node);
        if (node.freq == lfuCount && list.size == 0) {
            lfuCount++;
        }
        int newFreq = node.incrementFreq();
        this.listMap.computeIfAbsent(newFreq, k -> new DoublyLinkedList()).addToTail(node);
    }

    private class Node {
        int key, value, freq;
        Node left, right;

        {
            this.freq = 1;
        }

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int incrementFreq() {
            this.freq++;
            return this.freq;
        }
    }

    private class DoublyLinkedList {
        private Node head;
        private Node tail;
        private int size;

        DoublyLinkedList() {
            this.head = new Node();
            this.tail = new Node();
            this.head.right = this.tail;
            this.tail.left = this.head;
        }

        void addToTail(Node node) {
            node.left = this.tail.left;
            this.tail.left.right = node;
            node.right = this.tail;
            this.tail.left = node;
            this.size++;
        }

        void remove(Node node) {
            node.left.right = node.right;
            node.right.left = node.left;
            node.left = null;
            node.right = null;
            this.size--;
        }

        Node removeFromHead() {
            Node node = this.head.right;
            this.remove(node);
            return node;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */