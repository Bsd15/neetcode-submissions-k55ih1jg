class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        for x, y in points:
            dist = (x ** 2 + y ** 2)
            heapq.heappush_max(heap, [dist, [x, y]])
            if len(heap) > k:
                heapq.heappop_max(heap)
        
        res = []
        while heap:
            dist, p = heapq.heappop(heap)
            res.append(p)
        return res