class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        prefix_mods = [0] * k
        prefix_mods[0] = 1
        curr_prefix_mod = 0
        res = 0
        for n in nums:
            curr_prefix_mod = (curr_prefix_mod + n % k + k) % k
            res += prefix_mods[curr_prefix_mod]
            prefix_mods[curr_prefix_mod] += 1
        return res 