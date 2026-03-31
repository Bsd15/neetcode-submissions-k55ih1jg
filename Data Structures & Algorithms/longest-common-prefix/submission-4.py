class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        strs_len = len(strs)
        for i in range(len(strs[0])):
            c = strs[0][i]
            for j in range(1, strs_len):
                s = strs[j]
                if i >= len(s) or not s or c != s[i]:
                    return res
            res += c
        return res
