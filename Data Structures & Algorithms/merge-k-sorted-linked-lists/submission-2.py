# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None
        return self.merge(lists, 0, len(lists) - 1)
    
    def merge(self, lists: List[Optional[ListNode]], l: int, r: int) -> Optional[ListNode]:
        if l > r:
            return None
        if l == r:
            return lists[l]
        m = l + (r - l) // 2
        list1 = self.merge(lists, l, m)
        list2 = self.merge(lists, m + 1, r)
        return self.mergeLists(list1, list2)
    
    def mergeLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        curr = dummy
        while list1 and list2:
            if list1.val <= list2.val:
                curr.next = list1
                list1 = list1.next
            else:
                curr.next = list2
                list2 = list2.next
            curr = curr.next
        if list1:
            curr.next = list1
        if list2:
            curr.next = list2
        return dummy.next