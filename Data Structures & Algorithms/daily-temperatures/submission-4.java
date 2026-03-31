class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>(temperatures.length);
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.getFirst()] < temperatures[i]) {
                int pos = stack.pop();
                res[pos] = i - pos;
            }
            stack.addFirst(i);
        }
        return res;
    }
}
