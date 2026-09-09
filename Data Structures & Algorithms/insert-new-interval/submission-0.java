class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int s = -1;
        int e = -1;

        int l = 0;
        int r = intervals.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (intervals[m][0] <= newInterval[0]
                    && newInterval[0] <= intervals[m][1]) {

                s = m;
                break;

            } else if (newInterval[0] < intervals[m][0]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (s == -1) {
            s = l;
        }

        l = s;
        r = intervals.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (intervals[m][0] <= newInterval[1]
                    && newInterval[1] <= intervals[m][1]) {

                e = m;
                break;

            } else if (newInterval[1] < intervals[m][0]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (e == -1) {
            e = r;
        }

        // No overlap
        if (s > e) {
            int[][] result = new int[intervals.length + 1][2];

            for (int i = 0, j = 0; j < result.length; j++) {
                if (j != s) {
                    result[j] = intervals[i++];
                } else {
                    result[j] = newInterval;
                }
            }

            return result;
        }

        // Merge overlapping intervals
        int[][] result = new int[intervals.length - (e - s)][2];

        int j = 0;

        // Add intervals before the merged range
        for (int i = 0; i < s; i++) {
            result[j++] = intervals[i];
        }

        // Add merged interval
        result[j++] = new int[]{
                Math.min(intervals[s][0], newInterval[0]),
                Math.max(intervals[e][1], newInterval[1])
        };

        // Add intervals after the merged range
        for (int i = e + 1; i < intervals.length; i++) {
            result[j++] = intervals[i];
        }

        return result;
    }
}
