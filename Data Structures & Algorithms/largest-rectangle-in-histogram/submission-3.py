class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        res = 0
        for i,h in enumerate(heights):
            start = i
            while stack and stack[-1][1] > h:
                start, height = stack.pop()
                res = max(res, height * (i - start))
            stack.append([start, h])
        n = len(heights)
        for e in stack:
            length, height = e
            res = max(res, (height * (n - length)))
        
        return res