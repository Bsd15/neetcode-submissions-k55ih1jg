# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        self.is_sub_tree: bool = False
        if not root and not subRoot:
            return True
        expected = self.dfs(subRoot, None)
        self.dfs(root, expected)
        return self.is_sub_tree
    
    def dfs(self, node: Optional[TreeNode], expected: Optional[str]) -> str:
        if self.is_sub_tree:
            return "n"
        
        if not node:
            return "n"
        
        left_str = self.dfs(node.left, expected)
        right_str = self.dfs(node.right, expected)

        tree_str = f"{left_str}:{node.val}:{right_str}"

        if tree_str == expected:
            self.is_sub_tree = True
        
        return tree_str