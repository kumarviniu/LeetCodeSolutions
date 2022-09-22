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
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null)
                mergeRecursively(curr, next);
            curr = next;
        }
        return head;
    }
    
    public void mergeRecursively(Node start, Node end) {
        //start = 1, end = null
        //start = 2, end = null
        Node curr = start.child;
        start.next = start.child;
        start.child.prev = start;
        start.child = null;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                mergeRecursively(curr, next == null ? end : next);
                prev = next;
            } else
                prev = curr;
            curr = next;
        }
        if (prev != null) {
            prev.next = end;
            if (end != null)
                end.prev = prev;
        }
    }
}