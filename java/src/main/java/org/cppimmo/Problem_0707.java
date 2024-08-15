class MyLinkedList {
    private class Node {
        public int value = 0;
        public Node next = null;
        public Node() { }
        public Node(int value) { this.value = value; }
        public Node(int value, Node next) { this.value = value; this.next = next; }
    }
    private Node head;

    public MyLinkedList() {
        head = null;
    }

    private int length() {
        int result = 0;
        for (Node node = head; node != null; node = node.next, result++);
        return result;
    }
    
    public int get(int index) {
        Node node = head;
        for (int i = 0; node != null && i < index; i++, node = node.next);
        return (node != null) ? node.value : -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        tailNode.next = new Node(val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val); // Replace the head node
            return;
        }

        Node prevNode = head;
        for (int i = 0; prevNode != null && i < index - 1; i++, prevNode = prevNode.next);

        if (prevNode == null) {
            return; // Index out of bounds
        }

        Node newNode = new Node(val);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if (head == null) {
            return; // Nothing to delete
        } else if (index == 0) {
            head = head.next; // Advance head node
        }

        Node prevNode = head;
        for (int i = 0; prevNode != null && i < index - 1; i++, prevNode = prevNode.next);

        if (prevNode == null || prevNode.next == null) {
            return; // Index out of bounds
        }
        // Advance the prevNode and discard the inbetween
        prevNode.next = prevNode.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
