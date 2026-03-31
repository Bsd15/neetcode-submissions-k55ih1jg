class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(0, n):
            if nums[i] < 0:
                nums[i] = 0
        for i in range(0, n):
            val = abs(nums[i])
            if 1 <= val <= n:
                if nums[val - 1] > 0:
                    nums[val - 1] *= -1
                elif nums[val - 1] == 0:
                    nums[val - 1] = -1 * (n + 1)
        print(nums)
        for i in range(0, n):
            if nums[i] >= 0:
                return i + 1
        return n + 1