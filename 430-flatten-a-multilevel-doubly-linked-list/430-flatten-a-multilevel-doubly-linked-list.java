/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flat(head);
        return head;
    }
    
    public Node flat(Node head) {
        Node curr = head;
        Node tail = null;
        while (curr != null) {
            if (curr.child != null) {
                Node childTail = flat(curr.child);
                childTail.next = curr.next;
                if (curr.next != null) curr.next.prev = childTail;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                tail = childTail;
            } else
                tail = curr;
            curr = tail.next;
        }
        return tail;
    }
}