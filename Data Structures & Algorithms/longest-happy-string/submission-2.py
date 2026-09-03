class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        max_heap = []
        if a > 0:
            heapq.heappush_max(max_heap, [a, 'a'])
        if b > 0:
            heapq.heappush_max(max_heap, [b, 'b'])
        if c > 0:
            heapq.heappush_max(max_heap, [c, 'c'])
        
        res = ""
        cool_down = None
        while max_heap:
            nxt = heapq.heappop_max(max_heap)
            if nxt[0] == 0:
                continue
            if cool_down:
                heapq.heappush_max(max_heap, cool_down)
                cool_down = None
            
            if len(res) > 0 and res[-1] == nxt[1]:
                res += nxt[1]
                nxt[0] -= 1
                cool_down = nxt
            else:
                res += nxt[1]
                nxt[0] -= 1
                heapq.heappush_max(max_heap, nxt)

        return res