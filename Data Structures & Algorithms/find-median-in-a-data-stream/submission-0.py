class MedianFinder:
    def __init__(self):
        self.max_heap = []
        self.min_heap = []
        self.size = 0

    def addNum(self, num: int) -> None:
        self.size += 1
        if self.max_heap and self.max_heap[0] >= num:
            heapq.heappush_max(self.max_heap, num)
        else:
            heapq.heappush(self.min_heap, num)

        if abs(len(self.max_heap) - len(self.min_heap)) > 1:
            if len(self.max_heap) > len(self.min_heap):
                heapq.heappush(self.min_heap, heapq.heappop_max(self.max_heap))
            else:
                heapq.heappush_max(self.max_heap, heapq.heappop(self.min_heap))

    def findMedian(self) -> float:
        if self.size % 2 == 0:
            return (self.max_heap[0] + self.min_heap[0]) / 2
        else:
            return self.max_heap[0] if len(self.max_heap) > len(self.min_heap) else self.min_heap[0]
