class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] tasksCount = new int[26];
        for (char task: tasks) {
            ++tasksCount[task - 'A'];
        }

        int maxRepeatCount = 0;
        for (int i = 0; i < tasksCount.length; i++) {
            maxRepeatCount = Math.max(maxRepeatCount, tasksCount[i]);
        }

        int maxRepeatedTasksCount = 0;
        for (int i = 0; i < tasksCount.length; i++) {
            if (tasksCount[i] == maxRepeatCount) {
                ++maxRepeatedTasksCount;
            }
        }

        int time = (maxRepeatCount - 1) * (n + 1) + maxRepeatedTasksCount;
        return Math.max(tasks.length, time);
    }
}
