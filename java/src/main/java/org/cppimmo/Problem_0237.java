/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode1(ListNode node) {
        ListNode current = node;
        // Shift the node values
        // Iterate until the second-to-last node
        while (current.next.next != null) {
            current.val = current.next.val; // Copy the next node's value
            current = current.next; // Advance the current node
        }
        current.val = current.next.val; // Copy the last nodes value
        current.next = null; // Remove the last node
    }

	public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
