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
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int rooms = 0;

        for (Interval interval : intervals) {
            while (!pq.isEmpty() && pq.peek() <= interval.start) {
                pq.poll();
            }

            pq.offer(interval.end);

            rooms = Math.max(rooms, pq.size());
        }

        return rooms;
    }
}
