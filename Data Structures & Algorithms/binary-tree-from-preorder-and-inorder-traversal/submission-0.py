# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        curr_p = 0
        inorder_pos = {val: index for index, val in enumerate(inorder)}
        def visit(l: int, r: int) -> TreeNode:
            nonlocal curr_p
            if l > r:
                return None
            val = preorder[curr_p]
            curr_p += 1
            val_pos = inorder_pos[val]
            return TreeNode(val, visit(l, val_pos - 1), visit(val_pos + 1, r))

        return visit(0, len(preorder) - 1)
