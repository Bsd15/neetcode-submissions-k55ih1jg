class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort(key = lambda x: x[0])
        sorted_queries = [[i, queries[i]] for i in range(len(queries))]
        sorted_queries.sort(key = lambda q: q[1])
        interval_min_heap = []
        result = [-1] * len(queries)
        i = 0
        for query in sorted_queries:
            q = query[1]
            while i < len(intervals) and intervals[i][0] <= q:
                heapq.heappush(interval_min_heap, (intervals[i][1] - intervals[i][0] + 1, intervals[i][1]))
                i += 1
            
            while interval_min_heap and interval_min_heap[0][1] < q:
                heapq.heappop(interval_min_heap)

            if interval_min_heap:
                result[query[0]] = interval_min_heap[0][0]

        return result