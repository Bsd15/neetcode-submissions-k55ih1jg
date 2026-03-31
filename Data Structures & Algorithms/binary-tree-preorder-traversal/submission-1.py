# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        stack = []
        curr = root
        while stack or curr:
            if curr:
                res.append(curr.val)
                stack.append(curr)
                curr = curr.left
            else:
                prev = stack.pop()
                curr = prev.right
        return res