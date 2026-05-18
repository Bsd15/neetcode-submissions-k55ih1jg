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
        curr = head
        prev = dummy
        count = 1
        while curr:
            if count % k == 0:
                prev = self.reverse(prev, curr.next)
                curr = prev.next
            else:
                curr = curr.next
            count += 1
        return dummy.next

    def reverse(self, head, end):
        prev = head
        curr = head.next
        first = head.next
        while curr != end:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        head.next = prev
        first.next = end

        return first
