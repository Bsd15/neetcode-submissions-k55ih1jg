class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        total = 0
        res = 0
        l = 0
        for r in range(0, len(nums)):
            total += nums[r]
            while nums[r] * (r - l + 1) - total > k:
                total -= nums[l]
                l += 1
            res = max(res, r - l + 1)
        return res