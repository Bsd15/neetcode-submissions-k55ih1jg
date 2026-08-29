class Solution {
    public int leastInterval(char[] tasks, int n) {
        Deque<int[]> coolDownQueue = new ArrayDeque<>();

        int[] tasksMap = new int[26];
        for (char t : tasks) {
            ++tasksMap[t - 'A'];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(t -> tasksMap[(int) t]).reversed());

        for (int i = 0; i < 26; i++) {
            if (tasksMap[i] != 0) {
                pq.add(i);
            }
        }

        int cycle = 0;
        while (!pq.isEmpty() || !coolDownQueue.isEmpty()) {
            if (pq.isEmpty() && !coolDownQueue.isEmpty()) {
                cycle = coolDownQueue.getFirst()[1];
            } else {
                ++cycle;
            }
            if (!coolDownQueue.isEmpty()) {
                int[] task = coolDownQueue.getFirst();
                if (task[1] == cycle) {
                    coolDownQueue.removeFirst();
                    pq.add(task[0]);
                }
            }

            int task = pq.poll();
            if (tasksMap[task] > 1) {
                --tasksMap[task];
                coolDownQueue.addLast(new int[] {task, cycle + 1 + n});
            }
        }
        return cycle;
    }
}
