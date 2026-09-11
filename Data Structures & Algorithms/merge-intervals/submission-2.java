class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        List<int[]> result = new ArrayList<>(intervals.length);
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = result.getLast();
            if (prev[1] < intervals[i][0]) {
                result.add(intervals[i]);
            }
            else {
                // prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
