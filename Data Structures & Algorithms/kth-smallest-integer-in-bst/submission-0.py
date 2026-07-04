# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inorder(node, arr):
            if not node:
                return
            inorder(node.left, arr)
            arr.append(node.val)
            inorder(node.right, arr)
        tree_inorder = []
        inorder(root, tree_inorder)
        return tree_inorder[k - 1]