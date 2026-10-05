class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        n = len(arr)
        if n == 1:
            return 1
        curr_sign = ''
        curr_len = 1
        max_len = 1
        for i in range(n - 1):
            if arr[i] < arr[i + 1]:
                sign = '<'
            elif arr[i] > arr[i + 1]:
                sign = '>'
            else:
                sign = '='
            if sign != '=' and curr_sign != sign:
                curr_len += 1
            else:
                curr_len = 2 if sign != '=' else 1
            curr_sign = sign
            max_len = max(max_len, curr_len)
        return max_len