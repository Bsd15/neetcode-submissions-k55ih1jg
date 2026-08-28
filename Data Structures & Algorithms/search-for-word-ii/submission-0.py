class Node:
    def __init__(self):
        self.children = {}
        self.isWord = False

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.rows = len(board)
        self.cols = len(board[0])
        marked = [[False] * self.cols for _ in range(self.rows)]
        res = []

        # Build Trie
        root = Node()
        for word in words:
            curr = root
            for letter in word:
                if letter not in curr.children:
                    curr.children[letter] = Node()
                curr = curr.children[letter]
            curr.isWord = True

        for i in range(self.rows):
            for j in range(self.cols):
                self.visit(board, i, j, root, marked, res, "")

        return res

    def visit(self, board, i, j, node, marked, res, curr_res):
        if marked[i][j]:
            return
            
        letter = board[i][j]
        if letter not in node.children:
            return

        # Step into the child node corresponding to the current letter
        child_node = node.children[letter]
        curr_res += letter
        marked[i][j] = True

        # Now check if this new node completes a word
        if child_node.isWord:
            res.append(curr_res)
            child_node.isWord = False # Unmark to prevent duplicates

        # Explore the 4 directions, passing the child_node
        if i > 0:
            self.visit(board, i - 1, j, child_node, marked, res, curr_res)
        if i < self.rows - 1:
            self.visit(board, i + 1, j, child_node, marked, res, curr_res)
        if j > 0:
            self.visit(board, i, j - 1, child_node, marked, res, curr_res)
        if j < self.cols - 1:
            self.visit(board, i, j + 1, child_node, marked, res, curr_res)

        # Backtrack the board state (no need to backtrack curr_res!)
        marked[i][j] = False