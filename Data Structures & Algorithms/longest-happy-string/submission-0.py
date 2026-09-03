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
        i = -1
        while max_heap:
            if len(res) > 1 and res[i - 1] == res[i]:
                nxt = heapq.heappop_max(max_heap)
                if nxt[1] == res[i]:
                    if not max_heap:
                        return res

                    nxt2 = heapq.heappop_max(max_heap)
                    res += nxt2[1]
                    nxt2[0] -= 1
                    if nxt2[0]:
                        heapq.heappush_max(max_heap, nxt2)
                    heapq.heappush_max(max_heap, nxt)
                else:
                    res += nxt[1]
                    nxt[0] -= 1
                    if nxt[0]:
                        heapq.heappush_max(max_heap, nxt)
            else:
                nxt = heapq.heappop_max(max_heap)
                res += nxt[1]
                nxt[0] -= 1
                if nxt[0]:
                    heapq.heappush_max(max_heap, nxt)

        return res