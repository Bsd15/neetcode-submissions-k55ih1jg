class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> capitalMinQueue =
            new PriorityQueue<>((p1, p2)
                                    -> capital[p1] == capital[p2] ? profits[p2] - profits[p1]
                                                                  : capital[p1] - capital[p2]);
        PriorityQueue<Integer> profitsMaxQueue =
            new PriorityQueue<>((p1, p2)
                                    -> profits[p1] == profits[p2] ? capital[p1] - capital[p2]
                                                                  : profits[p2] - profits[p1]);

        for (int i = 0; i < profits.length; i++) {
            capitalMinQueue.offer(i);
        }

        int profit = w;
        for (int i = 0; i < k; i++) {
            while (!capitalMinQueue.isEmpty() && capital[capitalMinQueue.peek()] <= profit) {
                profitsMaxQueue.offer(capitalMinQueue.poll());
            }

            if (profitsMaxQueue.isEmpty())
                break;

            profit += profits[profitsMaxQueue.poll()];
        }
        return profit;
    }
}