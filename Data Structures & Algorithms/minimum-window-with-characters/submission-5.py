class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(t) > len(s):
            return ""
        
        t_char_map = [0] * 58
        s_char_map = [0] * 58

        req_count = 0

        A = ord('A')

        for c in t:
            i = ord(c) - A
            t_char_map[i] += 1
            req_count += 1
        
        res = [0, 0]
        res_length = sys.maxsize

        l = 0
        for r,c in enumerate(s):
            i = ord(c) - A
            s_char_map[i] += 1
            if t_char_map[i] > 0 and s_char_map[i] <= t_char_map[i]:
                req_count -= 1
            while req_count == 0:
                if (r - l + 1) < res_length:
                    res[0] = l
                    res[1] = r
                    res_length = r - l + 1
                j = ord(s[l]) - A
                s_char_map[j] -= 1
                if t_char_map[j] > 0 and s_char_map[j] < t_char_map[j]:
                    req_count += 1
                l += 1
        return s[res[0]:res[1] + 1] if res_length != sys.maxsize else ""