class Node:
    def __init__(self):
        self.children = [None] * 26
        self.isWord = False
    
class Trie:
    def __init__(self, dictionary):
        self.root = Node()
        for word in dictionary:
            curr = self.root
            for letter in word:
                index = ord(letter) - ord('a')
                if not curr.children[index]:
                    curr.children[index] = Node()
                curr = curr.children[index]
            curr.isWord = True

class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        root = Trie(dictionary).root
        dp = {len(s): 0}

        a = ord('a')

        def dfs(i):
            if i in dp:
                return dp[i]
            
            res = 1 + dfs(i + 1)
            curr = root
            for j in range(i, len(s)):
                idx = ord(s[j]) - a
                if not curr.children[idx]:
                    break
                curr = curr.children[idx]
                if curr.isWord:
                    res = min(res, dfs(j + 1))
            dp[i] = res
            return res
        
        return dfs(0)