class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        sequence = {}
        res = 0
        for n in nums:
            if n not in sequence:
                left = sequence.get(n - 1, 0)
                right = sequence.get(n + 1, 0)

                new_sum = 1 + left + right

                res = max(res, new_sum)

                sequence[n] = new_sum
                sequence[n - left] = new_sum
                sequence[n + right] = new_sum
        
        return res