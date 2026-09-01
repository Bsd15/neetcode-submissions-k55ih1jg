class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(sortedTasks, (t1, t2) -> t1[0] - t2[0]);

        long cycle = 0;
        int[] res = new int[tasks.length];
        int currRes = 0;
        int currSortedTask = 0;
        PriorityQueue<int[]> pq2 =
            new PriorityQueue<>((t1, t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0]);
        
        while (currSortedTask < tasks.length || !pq2.isEmpty()) {
            if (pq2.isEmpty() && cycle < sortedTasks[currSortedTask][0]) {
                cycle = sortedTasks[currSortedTask][0];
            }

            while (currSortedTask < tasks.length && sortedTasks[currSortedTask][0] <= cycle) {
                int[] task = sortedTasks[currSortedTask++];
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