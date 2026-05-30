# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = []
        curr = root
        res = []
        while curr or stack:
            if curr:
                stack.append(curr)
                curr = curr.left
            else:
                top = stack.pop()
                res.append(top.val)
                curr = top.right
        return res
        