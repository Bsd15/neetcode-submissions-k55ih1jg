"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort(key = lambda i: i.start)
        for i in range(len(intervals) - 1):
            end_i = intervals[i].end
            start_j = intervals[i + 1].start
            if end_i > start_j:
                return False
        return True