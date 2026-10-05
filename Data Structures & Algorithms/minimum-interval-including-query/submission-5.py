class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort(key = lambda x: x[0])
        sorted_queries = defaultdict(int)
        for i in range(len(queries)):
            sorted_queries[i] = -1
        interval_min_heap = []
        i = 0
        for qIdx in sorted(sorted_queries, key = lambda x: queries[x]):
            q = queries[qIdx]
            while i < len(intervals) and intervals[i][0] <= q:
                heapq.heappush(interval_min_heap, (intervals[i][1] - intervals[i][0] + 1, intervals[i][1]))
                i += 1
            
            while interval_min_heap and interval_min_heap[0][1] < q:
                heapq.heappop(interval_min_heap)
                
            if interval_min_heap:
                sorted_queries[qIdx] = interval_min_heap[0][0]

        res = [0] * len(queries)
        for qIdx, val in sorted_queries.items():
            res[qIdx] = val
        return res