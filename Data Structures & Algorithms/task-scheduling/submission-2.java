class Solution {
    public int leastInterval(char[] tasks, int n) {
        final int[] taskMap = new int[26];
        PriorityQueue<Integer> taskQueue =
            new PriorityQueue<>((t1, t2) -> taskMap[t2] - taskMap[t1]);
        for (char task : tasks) {
            ++taskMap[task - 'A'];
        }

        for (int i = 0; i < 26; i++) {
            if (taskMap[i] > 0) {
                taskQueue.add(i);
            }
        }

        Deque<int[]> taskCoolDownQueue = new ArrayDeque<>(26);
        int cycle = 0;

        while (!taskQueue.isEmpty() || !taskCoolDownQueue.isEmpty()) {
            if (taskQueue.isEmpty()) {
                cycle = taskCoolDownQueue.getFirst()[1];
            } else {
                ++cycle;
            }

            while (!taskCoolDownQueue.isEmpty() && cycle >= taskCoolDownQueue.getFirst()[1]) {
                taskQueue.add(taskCoolDownQueue.removeFirst()[0]);
            }
            int task = taskQueue.poll();
            --taskMap[task];
            if (taskMap[task] > 0) {
                taskCoolDownQueue.add(new int[] {task, cycle + n + 1});
            }
        }

        return cycle;
    }
}
