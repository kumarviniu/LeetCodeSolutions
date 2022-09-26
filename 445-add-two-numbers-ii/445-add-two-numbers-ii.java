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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        while (l1 != null) {
            l1Stack.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        ListNode curr = new ListNode();
        int carry = 0;
        while (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
            int sum = l1Stack.pop() + l2Stack.pop() + carry;
            carry = sum / 10;
            curr.val = sum % 10;
            curr = new ListNode(carry, curr);
        }
        Stack<Integer> left = l1Stack.isEmpty() ? l2Stack : l1Stack;
        while (!left.isEmpty()) {
            int sum = left.pop() + carry;
            carry = sum / 10;
            curr.val = sum % 10;
            curr = new ListNode(carry, curr);
        }
        return curr.val == 0 ? curr.next : curr;
    }
}