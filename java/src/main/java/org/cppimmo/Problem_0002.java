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
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return numberToList(listToNumber(l1).add(listToNumber(l2)));
    }

    private static BigInteger listToNumber(ListNode head) {
        BigInteger number = BigInteger.ZERO, base = BigInteger.ONE;
        for (ListNode current = head; current != null; current = current.next) {
            number = number.add(base.multiply(BigInteger.valueOf(current.val)));
            base = base.multiply(BigInteger.TEN);
        }
        return number;
    }

    private static ListNode numberToList(BigInteger number) {
        ListNode head = null, current = null;
        if (number.equals(BigInteger.ZERO))
            return new ListNode(0);

        for (var n = number; !n.equals(BigInteger.ZERO);) {
            int digit = n.mod(BigInteger.TEN).intValue();
            n = n.divide(BigInteger.TEN);
            if (head == null)
                current = head = new ListNode(digit);
            else {
                current.next = new ListNode(digit);
                current = current.next;
            }
        }
        return head;
    }
}
