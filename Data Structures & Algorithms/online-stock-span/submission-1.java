class StockSpanner {
    Deque<int[]> stack;
    public StockSpanner() {
        this.stack = new ArrayDeque<>(10);
    }
    
    public int next(int price) {
        int span = 1;
        while (!this.stack.isEmpty() && this.stack.getLast()[0] <= price) {
            span += this.stack.removeLast()[1];
        }
        this.stack.addLast(new int[] {price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */