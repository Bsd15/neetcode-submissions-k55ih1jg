# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root
        while curr:
            if not curr.right:
                res.insert(0, curr.val)
                curr = curr.left
            else:
                prev = curr.right
                while prev.left and prev.left != curr:
                    prev = prev.left
                if not prev.left:
                    res.insert(0, curr.val)
                    prev.left = curr
                    curr = curr.right
                else:
                    prev.left = None
                    curr = curr.left
        return res