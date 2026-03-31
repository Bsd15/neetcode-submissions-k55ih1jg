class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def can_ship(cap: int) -> bool:
            ships, currCap = 1, cap
            for w in weights:
                if currCap - w < 0:
                    ships += 1
                    if ships > days:
                        return False
                    currCap = cap

                currCap -= w
            return True
        l = max(weights)
        r = sum(weights)
        res = r
        while l <= r:
            m = l + (r - l) // 2
            if can_ship(m):
                res = min(res, m)
                r = m - 1
            else:
                l = m + 1
        return res