class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_freqs = [0] * 26
        max_freq = 0
        l = 0
        res = 0
        for r in range(len(s)):
            i = ord(s[r]) - ord('A')
            char_freqs[i] += 1
            max_freq = max(max_freq, char_freqs[i])
            while (r - l + 1) - max_freq > k:
                i = ord(s[l]) - ord('A')
                char_freqs[i] -= 1
                l += 1
            res = max(res, r - l + 1)
        return res