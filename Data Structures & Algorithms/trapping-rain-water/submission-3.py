class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        res = 0
        l_max = height[l]
        r_max = height[r]

        while l <= r:
            if l_max <= r_max:
                curr = l_max - height[l]
                if curr > 0:
                    res += curr
                l_max = max(l_max, height[l])
                l += 1
            else:
                curr = r_max - height[r]
                if curr > 0:
                    res += curr
                r_max = max(r_max, height[r])
                r -= 1

        return res