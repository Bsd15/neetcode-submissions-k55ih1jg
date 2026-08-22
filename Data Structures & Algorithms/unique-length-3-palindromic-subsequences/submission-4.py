class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        first_seen = [-1] * 26
        last_seen = [-1] * 26
        for i, char in enumerate(s):
            index = ord(char) - ord('a')
            if first_seen[index] == -1:
                first_seen[index] = i
            last_seen[index] = i
        
        res = 0
        for i in range(26):
            unique_chars = set()
            if first_seen[i] != last_seen[i]:
                unique_chars = set(s[first_seen[i] + 1: last_seen[i]])
                res += len(unique_chars)
        return res