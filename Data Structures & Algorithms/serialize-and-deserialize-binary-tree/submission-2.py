# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        def visit(node): 
            if not node:
                return "n"
            return str(node.val) + ":" + visit(node.left) + ":" + visit(node.right)
        return visit(root)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        serialized_nodes = data.split(':')
        i = 0
        def visit():
            nonlocal i
            if serialized_nodes[i] == 'n':
                i += 1
                return None
            node = TreeNode(int(serialized_nodes[i]))
            i += 1
            node.left = visit()
            node.right = visit()
            return node
        return visit()