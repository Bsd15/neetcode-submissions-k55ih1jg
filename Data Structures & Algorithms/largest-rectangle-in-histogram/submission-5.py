class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        for i,h in enumerate(heights):
            start = i
            while stack and stack[-1][0] > h:
                height, start = stack.pop()
                max_area = max(max_area, height * (i - start))
            stack.append([h, start])
        n = len(heights)
        for e in stack:
            max_area = max(max_area, e[0] * (n - e[1]))
        return max_area