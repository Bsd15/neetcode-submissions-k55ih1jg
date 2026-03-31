class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        for i, c in enumerate(strs[0]):
            for j in range(1, len(strs)):
                if i > len(strs[j]) - 1 or c != strs[j][i]: 
                    return strs[0][0:i]
        return strs[0]