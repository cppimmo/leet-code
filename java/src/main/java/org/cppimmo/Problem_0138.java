/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodesToCopies = new HashMap<>();
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            nodesToCopies.put(current, copy);
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = nodesToCopies.get(current);
            copy.next = nodesToCopies.getOrDefault(current.next, null);
            copy.random = nodesToCopies.getOrDefault(current.random, null);
            current = current.next;
        }
        return nodesToCopies.get(head);
    }
}
