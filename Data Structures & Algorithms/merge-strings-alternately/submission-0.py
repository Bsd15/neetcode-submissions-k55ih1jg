class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        l1 = len(word1)
        l2 = len(word2)

        i = j = 0
        res = ""
        while i < l1 and j < l2:
           res += word1[i]
           i += 1
           res += word2[j]
           j += 1
        if i < l1:
            res += word1[i:]
        if j < l2:
            res += word2[j:]
        return res     