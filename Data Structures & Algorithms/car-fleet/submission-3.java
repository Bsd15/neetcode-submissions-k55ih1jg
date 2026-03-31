class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new LinkedList<>();
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(pairs, (a,b) -> b[0] - a[0]);
        for (int[] pair : pairs) {
            double time = (double) (target - pair[0]) / pair[1];
            if (stack.isEmpty() || stack.getLast() < time) {
                stack.addLast(time);
            }
        }
        return stack.size();
    }
}
