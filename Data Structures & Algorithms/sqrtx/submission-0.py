class Solution:
    def mySqrt(self, x: int) -> int:
        l = 0
        r = x
        while l <= r:
            m = l + (r - l) // 2
            m_square = m * m
            if m_square == x:
                return m
            elif m_square > x:
                r = m - 1
            else:
                l = m + 1
        return r