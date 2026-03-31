class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1

        maxLeft = height[left]
        maxRight = height[right]

        totalTrappedWater = 0

        while left < right:
            if maxLeft < maxRight:
                left += 1
                maxLeft = max(maxLeft, height[left])
                totalTrappedWater += maxLeft - height[left]
            else:
                right -= 1
                maxRight = max(maxRight, height[right])
                totalTrappedWater += maxRight - height[right]

        return totalTrappedWater