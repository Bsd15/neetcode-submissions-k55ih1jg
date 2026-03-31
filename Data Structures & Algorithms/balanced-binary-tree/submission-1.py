# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.is_balanced = True
        self.check_balance(root)
        return self.is_balanced

    def check_balance(self, node: Optional[TreeNode]) -> None:
        if not node:
            return
        left_height = self.get_tree_height(node.left)
        right_height = self.get_tree_height(node.right)
        if abs(left_height - right_height) > 1:
            self.is_balanced = False
            return
        self.check_balance(node.left)
        self.check_balance(node.right)

    def get_tree_height(self, node: Optional[TreeNode]) -> int:
        if not node:
            return 0

        return 1 + max(self.get_tree_height(node.left), self.get_tree_height(node.right)) 