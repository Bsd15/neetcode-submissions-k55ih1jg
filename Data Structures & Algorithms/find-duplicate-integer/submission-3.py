class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            n = abs(nums[i])
            if nums[n - 1] < 0:
                return abs(nums[i])
            nums[n - 1] = -1 * nums[n - 1]