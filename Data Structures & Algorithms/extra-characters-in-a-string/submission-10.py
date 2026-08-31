class Node:
    def __init__(self):
        self.children = {}
        self.is_word = False


class Trie:
    def __init__(self, dictionary: List[str]):
        self.root = Node()
        for word in dictionary:
            curr = self.root
            for letter in word:
                if letter not in curr.children:
                    curr.children[letter] = Node()
                curr = curr.children[letter]
            curr.is_word = True

    def get_root(self):
        return self.root


class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        n = len(s)
        trie = Trie(dictionary)
        memo = [-1] * (n + 1)

        def dfs(i):
            if i == n:
                return 0
            if memo[i] != -1:
                return memo[i]

            res = 1 + dfs(i + 1)
            curr = trie.get_root()
            for j in range(i, n):
                if s[j] not in curr.children:
                    break
                curr = curr.children[s[j]]
                if curr.is_word:
                    res = min(res, dfs(j + 1))
            memo[i] = res
            return res

        return dfs(0)
