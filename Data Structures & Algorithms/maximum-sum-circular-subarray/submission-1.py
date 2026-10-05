class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        globalMax = globalMin = nums[0]
        currMax = currMin = total = 0
        for num in nums:
            currMax = max(currMax + num, num)
            currMin = min(currMin + num , num)
            total += num
            globalMax = max(globalMax, currMax)
            globalMin = min(globalMin, currMin)
        if globalMax > 0:
            return max(globalMax, total - globalMin)
        return globalMax