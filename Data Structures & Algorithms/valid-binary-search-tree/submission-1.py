# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(node, result):
            if not node:
                return
            inorder(node.left, result)
            result.append(node.val)
            inorder(node.right, result)

        inorder_view = []
        inorder(root, inorder_view)
        for i in range(1, len(inorder_view)):
            if inorder_view[i] <= inorder_view[i - 1]:
                return False
        return True