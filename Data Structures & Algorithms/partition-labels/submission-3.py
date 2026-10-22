class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n = len(s)
        if n == 1:
            return [1]
        end_pos = [0] * 26
        for i, c in enumerate(s):
            end_pos[ord(c) - ord('a')] = i
        result = []
        start = end = 0
        for i, c in enumerate(s):
           end = max(end, end_pos[ord(c) - ord('a')])
           if i == end:
            result.append(end - start + 1)
            start = i + 1
        
        return result
