class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        res = sys.maxsize
        l = 0
        curr_sum = 0
        for r in range(len(nums)):
            curr_sum += nums[r]
            while curr_sum >= target:
                res = min(res, r - l + 1)
                curr_sum -= nums[l]
                l += 1
        return res if res < sys.maxsize else 0