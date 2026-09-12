class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key = lambda trip: trip[1])
        idx = 0
        min_heap = []
        curr_cap = 0
        while idx < len(trips):
            while min_heap and min_heap[0][0] <= trips[idx][1]:
                trip = heapq.heappop(min_heap)
                curr_cap -= trip[1]
            trip = trips[idx]
            curr_cap += trip[0]
            if curr_cap > capacity:
                return False
            heapq.heappush(min_heap, (trip[2], trip[0]))
            idx += 1
        return True