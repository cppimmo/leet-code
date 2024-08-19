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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        ListNode current = head;
        while (current != null) {
            numbers.add(current.val);
            current = current.next;
        }
    }
}
