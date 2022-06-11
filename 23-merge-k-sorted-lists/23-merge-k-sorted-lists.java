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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode outHead = new ListNode();
        ListNode outRun = outHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode head: lists)
            if (head != null)
                pq.add(head);
        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            outRun.next = head;
            outRun = outRun.next;
            if (head.next != null)
                pq.add(head.next);
        }
        return outHead.next;
    }
}