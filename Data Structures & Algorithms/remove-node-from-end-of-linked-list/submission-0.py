# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        size = 0
        curr = head
        while curr:
            curr = curr.next
            size += 1
        if size == n:
            return head.next
        count = 1
        curr = head
        while count < (size - n):
            count += 1
            curr = curr.next
        curr.next = curr.next.next
        return head