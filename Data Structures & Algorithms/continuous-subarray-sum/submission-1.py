class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums) < 2:
            return False
        if len(nums) == 2:
            return sum(nums) % k == 0
        
        remainder_idx = {}
        curr_sum = 0
        for i, num in enumerate(nums):
            curr_sum = (curr_sum + num) % k
            if curr_sum == 0 and i >= 1:
                return True
            if curr_sum in remainder_idx and i - remainder_idx[curr_sum] > 1:
                return True
            elif curr_sum not in remainder_idx:
                remainder_idx[curr_sum] = i
        return False