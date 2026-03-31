# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        answer = ListNode()
        current_l1 = l1
        current_l2 = l2
        current_answer = answer
        carry_over = 0

        while current_l1 or current_l2 or carry_over:
            sum = carry_over
            if current_l1:
                sum += current_l1.val
                current_l1 = current_l1.next
            if current_l2:
                sum += current_l2.val
                current_l2 = current_l2.next
            temp = ListNode(sum%10)
            carry_over = sum//10
            current_answer.next = temp
            current_answer = temp

        return answer.next