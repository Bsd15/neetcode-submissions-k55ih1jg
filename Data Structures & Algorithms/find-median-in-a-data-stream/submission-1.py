class MedianFinder:
    def __init__(self):
        self.max_heap = []
        self.min_heap = []
        self.size = 0

    def addNum(self, num: int) -> None:
        heapq.heappush_max(self.max_heap, num)
        heapq.heappush(self.min_heap, heapq.heappop_max(self.max_heap))

        if len(self.min_heap) > len(self.max_heap):
            heapq.heappush_max(self.max_heap, heapq.heappop(self.min_heap))

    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            return self.max_heap[0]
        return (self.max_heap[0] + self.min_heap[0]) / 2
