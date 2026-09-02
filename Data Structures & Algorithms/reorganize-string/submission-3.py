class Solution:
    def reorganizeString(self, s: str) -> str:
        freq_count = {}
        # max_freq = 0
        for c in s:
            count = 1 + freq_count.get(c, 0)
            freq_count[c] = count
        #     max_freq = max(max_freq, count)
        
        # if max_freq > len(freq_count.keys()):
        #     return ""

        max_heap = []
        cool_down = None
        res = ""
        
        for k,v in freq_count.items():
            heapq.heappush_max(max_heap, [v, k])
        
        while max_heap:
            if len(max_heap) == 1 and not cool_down and max_heap[0][0] > 1:
                return ""
            next_char = heapq.heappop_max(max_heap)
            res += next_char[1]

            if cool_down:
                heapq.heappush_max(max_heap, cool_down)
                cool_down = None
            
            if next_char[0] > 1:
                next_char[0] -= 1
                cool_down = next_char
        return res
