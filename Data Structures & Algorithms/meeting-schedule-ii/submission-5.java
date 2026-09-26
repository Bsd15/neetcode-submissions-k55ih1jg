/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> delta = new ArrayList<>(intervals.size() * 2);
        for (Interval interval: intervals) {
            delta.add(new int[] {interval.start, +1});
            delta.add(new int[] {interval.end, -1});
        }
        delta.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int res = 0, curr = 0;
        
        for (int[] i: delta) {
            curr += i[1];
            res = Math.max(res, curr);
        }

        return res;
    }
}
