// Singly-linked list implementation
class MySinglyLinkedList {
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

// Doubly-linked list implementation
class MyLinkedList {
    private class Node {
        public int value = 0;
        public Node next = null, prev = null;
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
        if (head != null) {
            head.prev = newNode;
        }
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
        Node newNode = new Node(val);
        newNode.next = null;
        newNode.prev = tailNode;
        tailNode.next = newNode;
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
        newNode.prev = prevNode;
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if (head == null) {
            return; // Nothing to delete
        }
        // If the node to delete is the head
        if (index == 0) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else 
                head = null; // Only one node to remove
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index; i++, current = current.next);

        if (current == null) {
            return; // Index out of bounds
        }
        // Update the pointers to bypass the node being deleted
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
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
