class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        pref_freq = {0 : 1}
        curr_sum = 0
        res = 0
        for n in nums:
            curr_sum += n
            diff = curr_sum - k
            if diff in pref_freq:
                res += pref_freq[diff]
            pref_freq[curr_sum] = pref_freq.get(curr_sum, 0) + 1
        return res
