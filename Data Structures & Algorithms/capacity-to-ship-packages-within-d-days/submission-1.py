class Solution:
        def shipWithinDays(self, weights: List[int], days: int) -> int:
            l,r = max(weights), sum(weights)
            
            def can_ship(cap: int) -> bool:
                curr_cap = 0
                trips = 1
                for w in weights:
                    if curr_cap + w > cap:
                        trips += 1
                        curr_cap = 0
                    curr_cap += w
                return trips <= days
            res = r
            while l < r:
                m = l + (r - l) // 2
                if can_ship(m):
                    res = min(res, m)
                    r = m
                else:
                    l = m + 1
            return res