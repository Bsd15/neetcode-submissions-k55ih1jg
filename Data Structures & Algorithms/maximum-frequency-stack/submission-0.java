class FreqStack {

    private final Map<Integer, Integer> freq;
    private final Map<Integer, Deque<Integer>> stacks;
    private int maxCount;

    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
        maxCount = 0;
    }

    public void push(int val) {
        int count = freq.merge(val, 1, (e, n) -> e + n);
        if (count > maxCount) {
            maxCount = count;
        }
        stacks.computeIfAbsent(count, k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        int poppedVal = stacks.get(maxCount).pop();
        freq.compute(poppedVal, (key, val) -> val - 1);
        if (stacks.get(maxCount).isEmpty()) {
            maxCount--;
        }
        return poppedVal;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */