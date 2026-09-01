class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((t1, t2) -> t1[0] - t2[0]);
        for (int i = 0; i < tasks.length; i++) {
            pq1.add(new int[] {tasks[i][0], tasks[i][1], i});
        }

        long cycle = 0;
        int[] res = new int[tasks.length];
        int currRes = 0;
        PriorityQueue<int[]> pq2 =
            new PriorityQueue<>((t1, t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0]);
        
        while (!pq1.isEmpty() || !pq2.isEmpty()) {
            if (pq2.isEmpty() && cycle < pq1.peek()[0]) {
                cycle = pq1.peek()[0];
            }

            while (!pq1.isEmpty() && pq1.peek()[0] <= cycle) {
                int[] task = pq1.poll();
                pq2.add(
                    new int[] {
                        task[1], task[2]
                    }
                );
            }

            int[] task = pq2.poll();
            res[currRes++] = task[1];
            cycle += task[0];
        }

        return res;
    }
}