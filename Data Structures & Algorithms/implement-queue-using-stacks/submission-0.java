class MyQueue {

    private Deque<Integer> inputStack;
    private Deque<Integer> outputStack;
    private int size;

    {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public MyQueue() {
        
    }
    
    public void push(int x) {
        this.inputStack.addFirst(x);
        this.size++;
    }
    
    public int pop() {
        if (this.outputStack.isEmpty()) {
            while (!this.inputStack.isEmpty()) {
                this.outputStack.push(this.inputStack.pop());
            }
        }
        this.size--;
        return this.outputStack.pop();
    }
    
    public int peek() {
        if (this.outputStack.isEmpty()) {
            while (!this.inputStack.isEmpty()) {
                this.outputStack.push(this.inputStack.pop());
            }
        }
        return this.outputStack.peek();
    }
    
    public boolean empty() {
        return this.size == 0;    
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */