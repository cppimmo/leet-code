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
	// Brute force solution
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
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
	// Faster solution
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // Return the non-null node or null (if both are null)
        if (l1 == null || l2 == null) {
            return (l1 != null) ? l1 : l2;
        }
        // Create dummy to link the rest of the new list
        ListNode dummy = new ListNode(), current = dummy;
        int carryDigit = 0; // Store tenths-place digit
        // Continue while either l1 or l2 have remaining nodes
        while (l1 != null || l2 != null) {
            // Retrieve the digits from the current l1/l2 nodes
            final int digit1 = (l1 != null) ? l1.val : 0;
            final int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carryDigit;
            carryDigit = sum / 10; // Calculate new carry digit
            sum %= 10;
            current.next = new ListNode(sum); // Create the new digit node

            current = current.next; // Advance to prepare next digit node
            // Advance the two lists, or leave them as null
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        // If there is still a remaining carry digit, add it as a new node
        if (carryDigit != 0) {
            current.next = new ListNode(carryDigit);
        }
        return dummy.next; // Return past the dummy node
    }
}
