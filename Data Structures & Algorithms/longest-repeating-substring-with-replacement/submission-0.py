class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_frequencies = [0] * 26
        l = 0
        most_repeated_char_count = 0
        result = 0
        for r in range(len(s)):
            char_frequencies[ord(s[r]) - ord("A")] += 1
            most_repeated_char_count = max(most_repeated_char_count, char_frequencies[ord(s[r]) - ord("A")])
            while (r - l + 1) - most_repeated_char_count > k:
                char_frequencies[ord(s[l]) - ord("A")] -= 1
                l += 1
            result = max(result, r - l + 1)
        return result