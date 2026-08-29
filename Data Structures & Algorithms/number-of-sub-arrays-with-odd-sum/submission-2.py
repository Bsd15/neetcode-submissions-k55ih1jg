class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        odd_prefix_count = 0
        even_prefix_count = 0

        curr_prefix = 0

        res = 0

        for num in arr:
            curr_prefix += num
            if curr_prefix % 2 != 0:
                res += even_prefix_count + 1
                odd_prefix_count += 1
            else:
                res += odd_prefix_count
                even_prefix_count += 1

        return res