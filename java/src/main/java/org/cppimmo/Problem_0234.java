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
    public boolean isPalindrome1(ListNode head) {
        ListNode forward = head, last = null;
        while (forward != null && last != head) {
            ListNode current = head;
            while (current.next != last) {
                current = current.next;
            }
            System.out.println(forward.val + " " + current.val);
            if (forward.val != current.val) {
                return false;
            }
            forward = forward.next;
            last = current;
        }
        return true;
    }

	public boolean isPalindrome2(ListNode head) {
        if (head == null) { // Base cases (no node or one node)
            return true;
        } else if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        Stack<Integer> nodes = new Stack<>();
        // Use slow/fast pointer approach to place the first half of the list in a stack
        while (fast != null && fast.next != null) {
            nodes.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        // Skip the middle element if the list has an odd number of elements
        if (fast != null) {
            slow = slow.next;
        }
        // Iterating through the first-half stack will compare in reverse as needed
        while (slow != null) {
            if (slow.val != nodes.pop())
                return false;
            // Keep advancing the slow pointer which points to the second half of the list
            slow = slow.next;
        }
        return true;
    }
}
