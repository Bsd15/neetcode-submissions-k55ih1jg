class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        int[] result = new int[queries.length];
        int i = 0;
        for (int[] query: sortedQueries) {
            int qIdx = query[1];
            int q = query[0];
            while (i < intervals.length && intervals[i][0] <= q) {
                minHeap.offer(new int[] {intervals[i][1], intervals[i][1] - intervals[i][0] + 1});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[0] < q) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                result[qIdx] = -1;
            } else {
                result[qIdx] = minHeap.peek()[1];
            }
        }
        return result;
    }
}
