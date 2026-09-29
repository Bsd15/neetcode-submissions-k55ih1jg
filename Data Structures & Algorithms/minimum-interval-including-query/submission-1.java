class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        PriorityQueue<Integer> queryHeap =
            new PriorityQueue<>(Comparator.comparingInt(i -> queries[i]));
        for (int i = 0; i < queries.length; i++) {
            queryHeap.offer(i);
        }
        int i = 0;
        int[] result = new int[queries.length];
        while (!queryHeap.isEmpty()) {
            int qIdx = queryHeap.poll();
            int q = queries[qIdx];
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
