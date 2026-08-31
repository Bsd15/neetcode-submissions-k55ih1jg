class Node:
    def __init__(self):
        self.children = {}
        self.is_word = False
        self.word = None

class Trie:
    def __init__(self, words):
        self.root = Node()
        for word in words:
            curr = self.root
            for letter in word:
                if letter not in curr.children:
                    curr.children[letter] = Node()
                curr = curr.children[letter]
            curr.is_word = True
            curr.word = word
    def get_root(self):
        return self.root

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie(words)
        self.ROWS = len(board)
        self.COLS = len(board[0])

        self.marked = [[False] * self.COLS for _ in range(self.ROWS)]

        self.res = []

        for i in range(self.ROWS):
            for j in range(self.COLS):
                self.visit(board, i, j, trie.get_root())
        
        return self.res

    def visit(self, board, i, j, node):
        if self.marked[i][j]:
            return
        if board[i][j] not in node.children:
            return
        
        node = node.children[board[i][j]]
        self.marked[i][j] = True
        if node.is_word:
            self.res.append(node.word)
            node.is_word = False
        
        if i > 0:
            self.visit(board, i - 1, j, node)
        if i < self.ROWS - 1:
            self.visit(board, i + 1, j, node)
        if j > 0:
            self.visit(board, i, j - 1, node)
        if j < self.COLS - 1:
            self.visit(board, i, j + 1, node)

        self.marked[i][j] = False
        


