# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum = float("-inf")

        def dfs(node) -> int:
            if not node:
                return 0
            left_gain = max(0, dfs(node.left))
            right_gain = max(0, dfs(node.right))

            nonlocal max_sum
            max_sum = max(max_sum, node.val + left_gain + right_gain)
            return node.val + max(left_gain, right_gain)

        dfs(root)
        return max_sum
