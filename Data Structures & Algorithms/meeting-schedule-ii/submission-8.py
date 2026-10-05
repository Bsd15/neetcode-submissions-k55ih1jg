"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        meetings = []
        max_rooms = 0
        intervals.sort(key = lambda x: x.start)
        for interval in intervals:
            while meetings and meetings[0] <= interval.start:
                heapq.heappop(meetings)
            heapq.heappush(meetings, interval.end)
            max_rooms = max(max_rooms, len(meetings))
        return max_rooms