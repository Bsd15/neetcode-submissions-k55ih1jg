class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        maxArea = 0
        stack = []
        for i, h in enumerate(heights):
            start = i # this can be i or prev index if we pop
            while stack and stack[-1][1] > h:
                idx, height = stack.pop()
                maxArea = max(maxArea, height * (i - idx))
                start = idx # since we are popping. The current histogram can be extended back
            stack.append((start, h))
        n = len(heights)
        while stack:
            # All the remaining histograms can be extended till the end from their corresponding index
            i, h = stack.pop()
            maxArea = max(maxArea, h * (n - i))
        return maxArea