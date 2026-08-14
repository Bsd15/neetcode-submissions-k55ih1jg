class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total_sum = sum(nums)
        remainder = total_sum % p
        if remainder == 0:
            return 0
        
        res = len(nums)
        curr_prefix = 0

        prefix_map = {0: -1}

        for i, n in enumerate(nums):
            curr_prefix = (curr_prefix + n) % p
            target = (curr_prefix - remainder + p) % p
            if target in prefix_map:
                res = min(res, i - prefix_map[target])
            prefix_map[curr_prefix] = i
        
        return -1 if res == len(nums) else res