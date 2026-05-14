# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        len_lists = len(lists)
        if len_lists == 0:
            return None
        if len_lists == 1:
            return lists[0]
        def merge(list1: List, list2: List):
            curr1 = list1
            curr2 = list2
            result = ListNode()
            temp = result
            while curr1 and curr2:
                if curr1.val <= curr2.val:
                    temp.next = curr1
                    curr1 = curr1.next
                    temp = temp.next
                else:
                    temp.next = curr2
                    curr2 = curr2.next
                    temp = temp.next

            if curr1:
                temp.next = curr1
            if curr2:
                temp.next = curr2
            return result.next
        
        for i in range(1, len(lists)):
            lists[0] = merge(lists[0], lists[i])
        return lists[0]