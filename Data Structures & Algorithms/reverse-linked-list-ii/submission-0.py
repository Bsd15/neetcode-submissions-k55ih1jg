# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
            if left == right:
                return head

            dummy = ListNode(0, head)
            prev_left = left_node = prev = dummy
            curr = head
            right_node: ListNode = head.next
            count = 1
            while count <= right:
                if count == left:
                    prev_left = prev
                    left_node = curr

                if count >= left:
                    curr.next = prev

                if count == right:
                    prev_left.next = curr
                    left_node.next = right_node

                prev = curr
                curr = right_node
                right_node = right_node.next if right_node else None
                count += 1
            return dummy.next