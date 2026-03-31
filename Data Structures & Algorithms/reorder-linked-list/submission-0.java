/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // if (head.next != null) {
        //     return;
        // }
        var t = head;
        var h = head.next;
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
        }
        var head2 = t.next;
        t.next = null;

        // rev the 2nd list
        ListNode prev = null;
        var curr = head2;
        while (curr != null) {
            var temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }

        head2 = prev;

        // join two lists
        var curr1 = head;
        var curr2 = head2;
        while (curr1 != null && curr2 != null) {
            var t1 = curr1.next;
            var t2 = curr2.next;

            curr1.next = curr2;
            curr2.next = t1;

            curr1 = t1;
            curr2 = t2;
        }
    }
}
