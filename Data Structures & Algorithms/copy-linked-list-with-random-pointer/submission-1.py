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
        list1 = head
        list2 = head.next
        curr1 = list1
        curr2 = list2
        while curr1 and curr2:
            temp1 = curr1.next.next if curr1.next else None
            temp2 = curr2.next.next if curr2.next else None

            curr1.next = temp1
            curr2.next = temp2

            curr1 = temp1
            curr2 = temp2
        
        return list2