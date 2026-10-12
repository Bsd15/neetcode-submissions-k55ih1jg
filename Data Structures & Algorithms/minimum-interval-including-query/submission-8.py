class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        print(intervals)
        sorted_queries = []
        for i,q in enumerate(queries):
            sorted_queries.append((i, q))
        sorted_queries.sort(key = lambda x: x[1])
        min_heap = []
        result = [-1] * len(queries)
        i = 0
        for sorted_query in sorted_queries:
            idx = sorted_query[0]
            query = sorted_query[1]
            while i < len(intervals) and intervals[i][0] <= query:
                heapq.heappush(min_heap, (intervals[i][1] - intervals[i][0] + 1, intervals[i][1]))
                i += 1

            while min_heap and min_heap[0][1] < query:
                heapq.heappop(min_heap)
            if min_heap:
                result[idx] = min_heap[0][0]
        return result
# [[1, 6], [1, 9], [4, 5]i, [5, 8], [8, 10]]
# queries 3, 3, 7, 9, 9
# heap = [9, 9, 1], []
