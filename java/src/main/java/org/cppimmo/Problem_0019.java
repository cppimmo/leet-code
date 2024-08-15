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
        final int LENGTH = length(head);
        ListNode nodeToRemove = get(head, Math.max(0, LENGTH - n));
        /*if (nodeToRemove != null) {
            System.out.println(nodeToRemove.val);
        }*/
        // Handle the case in which there is a single node which needs to be removed
        if (nodeToRemove == head) {
            return head.next; // Simply return null (head.next is null in this case)
        }

        ListNode prevNode = head;
        while (prevNode.next != null && prevNode.next != nodeToRemove) {
            prevNode = prevNode.next;
        }
        //System.out.println(prevNode.val);
        // Remove the nodeToRemove
        prevNode.next = nodeToRemove.next;
        return head;
    }
    // Get a ListNode at the zero-based index
    public static ListNode get(ListNode head, int index) {
        final int LENGTH = length(head);
        if (index < 0 || index >= LENGTH) {
            return null;
        }

        ListNode node = head;
        for (int i = 0; i < index && node.next != null; i++) {
            node = node.next;
        }
        return node;
    }
    // Calculate the length of the list
    public static int length(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
