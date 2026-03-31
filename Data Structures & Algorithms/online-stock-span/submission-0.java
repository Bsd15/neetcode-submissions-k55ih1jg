class StockSpanner {

    List<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayList<>(10);
    }

    public int next(int price) {
        if (this.stack.isEmpty()) {
            this.stack.add(new int[] { price, -1 });
            return 1;
        }

        int[] top = this.stack.getLast();
        if (top[0] > price) {
            this.stack.add(new int[] { price, this.stack.size() - 1 });
            return 1;
        } else {
            int i = this.stack.getLast()[1];
            for (;;) {
                if (i == -1) {
                    this.stack.add(new int[] { price, -1 });
                    return this.stack.size();
                }
                int[] prev = this.stack.get(i);
                if (prev[0] > price) {
                    this.stack.add(new int[] { price, i });
                    return this.stack.size() - 1 - i;
                } else {
                    i = prev[1];
                }
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */