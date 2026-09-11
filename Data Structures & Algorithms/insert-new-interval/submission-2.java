class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(intervals.length);
        int startInterval = newInterval[0];
        int endInterval = newInterval[1];
        int i = 0;
        while (i < intervals.length && startInterval > intervals[i][1]) {
            result.add(intervals[i++]);
        }
        while (i < intervals.length && endInterval >= intervals[i][0]) {
            startInterval = Math.min(startInterval, intervals[i][0]);
            endInterval = Math.max(endInterval, intervals[i][1]);
            i++;
        }
        result.add(new int[] {startInterval, endInterval});
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[][]{});
    }
}
