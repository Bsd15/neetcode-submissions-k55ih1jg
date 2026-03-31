class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = 0
        maxVolume = 0
        r = len(heights) - 1

        while l < r:
            minHeight = min(heights[l], heights[r])
            volume =  minHeight * (r - l)

            maxVolume = max(volume, maxVolume)

            while l < r and heights[l] <= minHeight:
                l += 1
            
            while l < r and heights[r] <= minHeight:
                r -= 1
        
        return maxVolume