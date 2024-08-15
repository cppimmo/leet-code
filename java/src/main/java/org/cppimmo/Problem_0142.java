/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return start;
    }
}
