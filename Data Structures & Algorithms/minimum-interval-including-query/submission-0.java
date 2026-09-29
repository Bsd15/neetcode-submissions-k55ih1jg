class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            intervals[i] = new int[] {interval[0], interval[1], interval[1] - interval[0] + 1};
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        int[] result = new int[queries.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 0; i < queries.length; i++) {
            for (int[] interval: intervals) {
                if (interval[0] > queries[i])
                    break;
                if (interval[1] < queries[i]) {
                    continue;
                }
                result[i] = Math.min(result[i], interval[2]);
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
