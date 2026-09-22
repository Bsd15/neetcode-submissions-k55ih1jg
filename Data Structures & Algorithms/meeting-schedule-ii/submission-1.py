"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if not intervals:
            return 0
        min_start = float('+inf')
        max_end = float('-inf')

        for i in intervals:
            min_start = min(min_start, i.start)
            max_end = max(max_end, i.end)
        
        n = max_end - min_start + 1
        timeline = [0] * n
        for i in intervals:
            timeline[i.start - min_start] += 1
            timeline[i.end - min_start] -= 1
        
        curr_sum = 0
        res = 0
        for i in timeline:
            curr_sum += i
            res = max(res, curr_sum)

        return res