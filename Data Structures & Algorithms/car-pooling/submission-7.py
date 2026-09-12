class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        start = min(trips, key = lambda trip: trip[1])[1]
        end = max(trips, key = lambda trip: trip[2])[2]
        n = end - start + 1
        destinations = [0] * n

        for trip in trips:
            destinations[trip[1] - start] += trip[0]
            destinations[trip[2] - start] -= trip[0]
        
        curr_cap = 0

        for p in destinations:
            curr_cap += p
            if curr_cap > capacity:
                return False

        return True