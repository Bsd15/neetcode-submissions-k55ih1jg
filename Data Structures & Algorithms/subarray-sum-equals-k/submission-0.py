class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sum = 0
        sub_arr_sum = {0 : 1}
        res = 0
        for n in nums:
            prefix_sum += n
            diff = prefix_sum - k
            res += sub_arr_sum.get(diff, 0)
            if prefix_sum not in sub_arr_sum:
                sub_arr_sum[prefix_sum] = 1
            else:
                sub_arr_sum[prefix_sum] = sub_arr_sum[prefix_sum] + 1
        return res