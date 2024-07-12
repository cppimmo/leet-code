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
    public ListNode middleNode(ListNode head) {
        Function<Integer, Boolean> isEven = (number) -> number % 2 == 0;
        final int length = listLength(head);
        
        ListNode current = head;
        for (int i = 0; i < length / 2; ++i) {
            current = current.next;
        }
        return current;
    }

    private static int listLength(ListNode head) {
        int length = 0;
        for (ListNode current = head; current != null; current = current.next, ++length);
        return length;
    }
}
