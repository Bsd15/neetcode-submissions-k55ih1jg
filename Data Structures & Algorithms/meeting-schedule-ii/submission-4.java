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
        Map<Integer, Integer> delta = new TreeMap<>();
        for (Interval i: intervals) {
            delta.compute(i.start, (k ,v) -> v == null ? 1 : v + 1);
            delta.compute(i.end, (k,v) -> v == null ? -1 : v - 1);
        }
        int res = 0, curr = 0;
        for (int value: delta.values()) {
            curr += value;
            res = Math.max(res, curr);
        }
        return res;
    }
}
