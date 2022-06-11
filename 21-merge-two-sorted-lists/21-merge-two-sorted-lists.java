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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode outHead = new ListNode();
        ListNode outRun = outHead;
        ListNode temp;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            outRun.next = temp;
            outRun = outRun.next;
        }
        outRun.next = list1 != null ? list1 : list2;
        return outHead.next;
    }
}