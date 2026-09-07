class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Integer[] sortedCapitals = new Integer[capital.length];

        PriorityQueue<Integer> profitsMaxQueue =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < profits.length; i++) {
            sortedCapitals[i] = i;
        }

        Arrays.sort(sortedCapitals, (p1, p2) -> Integer.compare(capital[p1], capital[p2]));

        int profit = w;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < sortedCapitals.length && capital[sortedCapitals[idx]] <= profit) {
                profitsMaxQueue.offer(profits[sortedCapitals[idx]]);
                ++idx;
            }

            if (profitsMaxQueue.isEmpty())
                break;

            profit += profitsMaxQueue.poll();
        }
        return profit;
    }
}