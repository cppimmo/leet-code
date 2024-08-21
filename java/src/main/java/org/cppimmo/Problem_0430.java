/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        // Iterate through each node & flatten the child lists
        Node current = head;
        while (current != null) {
            // Flatten the child node if it exists
            if (current.child != null) {
                Node child = current.child, next = current.next;
                Node flattenedChild = flatten(child);
                // Setup the head of the flattened child list
                current.next = flattenedChild;
                flattenedChild.prev = current;
                // Iterate until the tail of the flattened child list
                for (; flattenedChild.next != null; flattenedChild = flattenedChild.next);
                // Attach the rest of the list to the tail of the flattened child list
                if (next != null) {
                    flattenedChild.next = next;
                    next.prev = flattenedChild;
                }
                current.child = null; // Remove child pointer
            }
            current = current.next; // Advance to the next node
        }
        return head;
    }
}

