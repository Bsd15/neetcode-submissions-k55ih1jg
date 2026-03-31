class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        N = len(nums)
        
        prefix_sum = [0] * (N + 1)
        for i in range(N):
            prefix_sum[i + 1] = prefix_sum[i] + nums[i]
        
        res = (N + 1)

        for i in range(N):
            l = i
            r = N
            curr_sum = 0
            while l < r:
                mid = (l + r) // 2
                curr_sum = prefix_sum[mid + 1] - prefix_sum[i]
                if curr_sum >= target:
                    r = mid
                else:
                    l = mid + 1
            if l != N:
                res = min(res, l - i + 1)

        return res % (N + 1)