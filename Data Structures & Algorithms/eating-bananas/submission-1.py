class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)

        def can_finish_piles(rate: int) -> bool:
            total_piles = 0
            for pile in piles:
                total_piles += math.ceil(pile / rate)
            if total_piles <= h:
                return True
            else:
                return False
        res = r
        while l < r:
            m = l + (r - l) // 2
            if can_finish_piles(m):
                res = min(res, m)
                r = m
            else:
                l = m + 1
        return res