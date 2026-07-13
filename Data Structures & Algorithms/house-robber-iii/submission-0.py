# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode]) -> List[int]:
            if not node:
                return [0, 0]
            left = dfs(node.left)
            right = dfs(node.right)
            node_robbed = node.val + left[1] + right[1]
            node_not_robbed = max(left) + max(right)
            return [node_robbed, node_not_robbed]
        return max(dfs(root)) 