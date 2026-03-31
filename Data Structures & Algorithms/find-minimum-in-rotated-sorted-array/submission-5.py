class Solution:
    def findMin(self, nums: List[int]) -> int:
        l,r = 0, len(nums) - 1
        res = nums[0]
        while l <= r:
            m = l + (r - l) // 2
            res = min(res, nums[m])
            if nums[l] <= nums[m]:
                res = min(res, nums[l])
                l = m + 1
            else:
                r = m - 1
        return res