class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = [nums[0]]
        for i in range(1, n):
            prefix.append(prefix[i - 1] * nums[i])

        suffix = [1] * n
        suffix[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i]
        
        res = []
        for i in range(n):
            if i == 0:
                res.append(suffix[i + 1])
            elif i == n - 1:
                res.append(prefix[i - 1])
            else:
                res.append(prefix[i - 1] * suffix[i + 1])

        return res