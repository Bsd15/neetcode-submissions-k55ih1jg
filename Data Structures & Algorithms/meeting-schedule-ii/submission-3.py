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
        delta = defaultdict(int)
        for i in intervals:
            delta[i.start] += 1
            delta[i.end] -= 1
        curr = res = 0
        for d in sorted(delta):
            curr += delta[d]
            res = max(curr, res)
        return res