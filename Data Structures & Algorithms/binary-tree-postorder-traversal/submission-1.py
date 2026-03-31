# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        stack = []
        curr = root
        last_visited = None
        while stack or curr:
            if curr:
                stack.append(curr)
                curr = curr.left
            else:
                temp = stack[-1]
                print(temp)
                if temp.right and temp.right != last_visited:
                    curr = temp.right
                else:
                    stack.pop()
                    res.append(temp.val)
                    last_visited = temp
        return res

                