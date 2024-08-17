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
    public ListNode oddEvenList(ListNode head) {
        // Base cases
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head; // Return head for a single element
        }

        ListNode oddHead = head, evenHead = head.next;
        ListNode odd = oddHead, even = evenHead;
        ListNode current = head.next.next;
        int index = 0;
        // Iterate through the main list and build the odd & even sublists
        while (current != null) {
            if (index % 2 == 0) {
                odd.next = current;
                odd = odd.next;
            } else {
                even.next = current;
                even = even.next;
            }
            index++;
            current = current.next;
        }
        // Combine the odd & even lists
        odd.next = evenHead; // Set the tail of the odd list to the head of the even list
        even.next = null; // Avoid circular list
        return oddHead;
    }
}
