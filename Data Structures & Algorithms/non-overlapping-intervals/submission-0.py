class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        prev_end = intervals[0][1]
        res = 0
        for i in range(1, len(intervals)):
            start, end = intervals[i]
            if prev_end > start:
                res += 1 
                prev_end = min(prev_end, end)
            elif prev_end <= start:
                prev_end = end
        return res