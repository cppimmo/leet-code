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
    public ListNode removeElements(ListNode head, int val) {
        Queue<ListNode> nodes = new LinkedList<>();
        ListNode current = head;
        // Add all of the nodes to a queue
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        //nodes.forEach(node -> System.out.print(node.val + " "));
        // Dummy node prevents the head itself from being removed
        ListNode dummy = new ListNode(0);
        current = dummy;
        // Iterate through the nodes and create the list with the elements removed
        while (!nodes.isEmpty()) {
            var node = nodes.remove();
            if (node.val != val) {
                current.next = node;
                current = current.next;
            }
        }
        current.next = null; // Avoid potential circular refrence
        return dummy.next; // (Could be null)
    }
}
