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
        ListNode mid = head;
        ListNode end = head;
        while (end.next != null) {
            mid = mid.next;
            end = end.next;
            if (end.next != null)
                end = end.next;
        }
        
        ListNode prev = null;
        ListNode curr = mid;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
       
        while (head != null && end != null && head != end) {
            temp = head.next; 
            head.next = end;
            head = end;
            end = temp;
        }
    }
}