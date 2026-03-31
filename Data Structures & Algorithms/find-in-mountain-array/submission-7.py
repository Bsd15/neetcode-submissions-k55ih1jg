class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        length = mountainArr.length()
        l = 1
        r = length - 2
        while l <= r:
            m = l + (r - l) // 2
            l_val = mountainArr.get(m - 1)
            m_val = mountainArr.get(m)
            r_val = mountainArr.get(m + 1)
            if l_val < m_val > r_val:
                peak = m
                break
            elif l_val > m_val:
                r = m - 1
            else:
                l = m + 1
        
        l = 0
        r = peak
        while l <= r:
            m = l + (r - l) // 2
            m_val = mountainArr.get(m)
            if m_val == target:
                return m
            elif target < m_val:
                r = m - 1
            else:
                l = m + 1
    
        l = length - 1
        r = peak
        while r <= l:
            m = r + (l - r) // 2
            m_val = mountainArr.get(m)
            if m_val == target:
                return m
            elif target < m_val:
                r = m + 1
            else:
                l = m - 1
        
        return -1