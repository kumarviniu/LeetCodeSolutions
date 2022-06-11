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
        ListNode outHead = null;
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
            if (outHead == null) {
                outHead = temp;
                outRun = outHead;
            } else {
                outRun.next = temp;
                outRun = outRun.next;
            }
        }
        ListNode list = list1 != null ? list1 : list2;
        if (list != null && outHead == null) {
            outHead = list;
            outRun = outHead;
            list = list.next;
        }
        while (list != null) {
            outRun.next = list;
            outRun = outRun.next;
            list = list.next;
        }
        return outHead;
    }
}