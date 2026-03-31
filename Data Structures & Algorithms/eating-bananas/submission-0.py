import math
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1
        r = max(piles)

        def canFinishBananas(rate: int) -> bool:
            totalHours = 0
            for p in piles:
                totalHours += math.ceil(p/rate)
            return totalHours <= h
        
        res = 0
        
        while l <= r:
            m = l + (r - l) // 2
            if canFinishBananas(m):
                res = m
                r = m - 1
            else:
                l = m + 1
        
        return res