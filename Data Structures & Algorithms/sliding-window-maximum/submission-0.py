class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        prefix = [0] * n
        suffix = [0] * n

        prefix[0] = nums[0]
        suffix[n - 1] = nums[n - 1]

        for i in range(1, n):
            prefix[i] = nums[i] if i % k == 0 else max(nums[i], prefix[i - 1])
            j = n - i - 1
            suffix[j] = nums[j] if j % k == 0 else max(nums[j], suffix[j + 1])

        result = []
        for i in range(n - k + 1):
            result.append(max(suffix[i], prefix[i + k - 1]))
        
        return result