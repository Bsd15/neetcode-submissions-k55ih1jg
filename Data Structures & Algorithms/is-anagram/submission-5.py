class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_counts = [0] * 27
        for i in range(len(s)):
            idx = ord(s[i]) - ord('a')
            char_counts[idx] += 1
            idx = ord(t[i]) - ord('a')
            char_counts[idx] -= 1

        for i in char_counts:
            if i != 0:
                return False
        return True
