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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i = 0; i < n; i++)
            fast = fast.next;
        ListNode deleted;
        if (fast == null) {
            deleted = null;
        } else {
            deleted = head;
            while(fast.next != null) {
                fast = fast.next;
                deleted = deleted.next;
            }
        }
        if (deleted == null)
            return head.next;
        deleted.next = deleted.next.next;
        return head;
    }
}