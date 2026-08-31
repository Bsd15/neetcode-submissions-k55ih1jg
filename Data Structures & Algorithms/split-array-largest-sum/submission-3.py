class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:

        def can_split(nums, k, target):
            splits = 1
            curr_sum = 0
            for n in nums:
                if curr_sum + n > target:
                    curr_sum = n
                    splits += 1
                else:
                    curr_sum += n
            return splits <= k

        max_num = max(nums)
        total = sum(nums)
        l = max_num
        r = total
        res = 0
        while l <= r:
            m = l + (r - l) // 2
            if can_split(nums, k, m):
                r = m - 1
                res = m
            else:
                l = m + 1

        return res