# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        p1, p2 = l1, l2
        res = curr = ListNode()

        carry = 0

        while p1 or p2 or carry > 0:
            val1 = p1.val if p1 else 0
            val2 = p2.val if p2 else 0

            curr_sum = val1 + val2 + carry

            digit = curr_sum % 10
            carry = curr_sum // 10

            curr.next = ListNode(digit)
            curr = curr.next

            p1 = p1.next if p1 else None
            p2 = p2.next if p2 else None
        
        return res.next