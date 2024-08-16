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
    public ListNode reverseList1(ListNode head) {
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
	
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> nodes = new Stack<>();
        ListNode current = head;
        // Place the nodes into the stack
        while (current != null) {
            nodes.push(current);
            current = current.next;
        }
        // Pop the nodes from the stack, effectively reversing the list
        ListNode newHead = (!nodes.empty()) ? nodes.pop() : null;
        current = newHead;
        while (!nodes.empty()) {
            var node = nodes.pop();
            current.next = node;
            current = node; // Advance the current node
        }
        if (current != null) { // Ensure the list terminates
            current.next = null;
        }
        return newHead;
    }
}
