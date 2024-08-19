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
	// Brute-force implementation
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        List<Integer> numbers = new ArrayList<>(100);
        // Add the numbers from the list nodes to the array
        iterate(list1, numbers);
        iterate(list2, numbers);

        Collections.sort(numbers); // Sort the numbers
        // Create a new linked list from the sorted array
        ListNode head = (!numbers.isEmpty()) ? new ListNode(numbers.get(0)) : null;
        ListNode current = head;
        for (int i = 1; i < numbers.size(); i++) {
            current.next = new ListNode(numbers.get(i));
            current = current.next;
        }
        return head;
    }

    private static void iterate(final ListNode head, List<Integer> numbers) {
		// Add the numbers from the linked-list to the list, numbers.
        ListNode current = head;
        while (current != null) {
            numbers.add(current.val);
            current = current.next;
        }
    }
	// In-place implementation
	public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // Dummy head node provides a means to attach the rest of the nodes
        ListNode head = new ListNode(), current = head;
        while (list1 != null && list2 != null) {
            ListNode node;
            if (list1.val < list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
            current.next = node; // Set the next node which was chosen
            current = current.next;
        }
        // If the lists weren't the same length, advance the list that still has elements.
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return head.next; // Advance past the dummy node (could be null)
    }
}
