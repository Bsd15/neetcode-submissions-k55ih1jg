# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:
            return False
        elif self.dfs(root, subRoot):
            return True
        else:
            return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def dfs(self, node: Optional[TreeNode], subTreeNode: Optional[TreeNode]) -> bool:
        if node is None and subTreeNode is None:
            return True
        if node is None or subTreeNode is None:
            return False
        return node.val == subTreeNode.val and self.dfs(node.left, subTreeNode.left) and self.dfs(node.right, subTreeNode.right)
