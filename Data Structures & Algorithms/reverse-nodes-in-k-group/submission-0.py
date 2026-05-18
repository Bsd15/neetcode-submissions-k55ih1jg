# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1:
            return head
        dummy = ListNode()
        dummy.next = head
        prev = dummy
        curr = head
        count = 1
        while curr:
            if count % k == 0:
                temp = curr.next
                new_head = self.reverse(head, temp)
                prev.next = new_head
                head.next = temp
                prev = head
                head = temp
                curr = temp
            else:
                curr = curr.next
            count += 1
        return dummy.next
    
    def reverse(self, head, end):
        curr = head
        prev = None
        while curr != end:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev