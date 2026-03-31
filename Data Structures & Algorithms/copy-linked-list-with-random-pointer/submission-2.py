"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        # Create duplicate nodes
        curr = head
        while curr:
            temp = Node(curr.val, curr.next)
            curr.next = temp
            curr = temp.next

        # link random nodes 
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        # Seperate the duplicate nodes into a new list
        node = head
        res = head.next
        while node:
            temp = node.next
            node.next = temp.next
            if temp.next:
                temp.next = temp.next.next
            node = node.next
        
        return res