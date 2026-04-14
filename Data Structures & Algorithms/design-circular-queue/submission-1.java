class MyCircularQueue {

    private int capacity;
    private int size;
    private Node head;
    private Node rear;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (this.size == this.capacity) {
            return false;
        }

        if (this.size == 0) {
            this.head = new Node(value);
            this.rear = head;
        } else {
            Node newNode = new Node(value, this.rear, null);
            this.rear.next = newNode;
            this.rear = newNode;
        }
        ++this.size;
        return true;
    }
    
    public boolean deQueue() {
        if (this.size == 0) {
            return false;
        }

        if (this.size == 1) {
            this.head = null;
            this.rear = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        --this.size;
        return true;
    }
    
    public int Front() {
        return this.size == 0 ? -1  : this.head.value;
    }
    
    public int Rear() {
       return this.size == 0 ? -1 : this.rear.value;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }

    private class Node {
        int value;
        Node prev, next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}