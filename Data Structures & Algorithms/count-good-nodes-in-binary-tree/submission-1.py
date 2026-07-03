# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        q = deque()
        res = 0
        q.append([root, root.val])
        while q:
            node, max_val = q.popleft()
            if node.val >= max_val:
                res += 1
                max_val = node.val
            if node.left:
                q.append([node.left, max(node.val, max_val)])
            if node.right:
                q.append([node.right, max(node.val, max_val)]) 
        return res           