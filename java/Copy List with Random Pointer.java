// Copy List with Random Pointer - 138


class Solution {
    public Node copyRandomList(Node head) {
        // Return null if the original list is empty
        if (head == null) {
            return null;
        }

        // 1. Create a cloned node for each node in the original list and insert it
        // right next to the original node.
        for (Node current = head; current != null;) {
            Node clone = new Node(current.val); // Clone node
            clone.next = current.next; // Set clone's next to current node's next
            current.next = clone; // Insert cloned node after the current node
            current = clone.next; // Move to the next original node
        }

        // 2. Assign random pointers for the cloned nodes.
        for (Node current = head; current != null; current = current.next.next) {
            if (current.random != null) {
                // Set the cloned node's random to the cloned node of the original node's random
                current.next.random = current.random.next;
            }
        }

        // 3. Restore the original list and extract the cloned list.
        Node copyHead = head.next; // Head of the cloned list
        for (Node current = head; current != null;) {
            Node clone = current.next; // The cloned node
            // Restore the original list's 'next' pointers
            current.next = clone.next;
            // Set the cloned node's 'next' pointers. Check if the next original node
            // exists.
            clone.next = (clone.next != null) ? clone.next.next : null;
            // Move to the next original node
            current = current.next;
        }

        // Return the head of the cloned list
        return copyHead;
    }
}

// Definition for a Node.
class Node {
    public int val; // Value of the node
    public Node next; // Reference to the next node in the list
    public Node random; // Reference to a random node in the list

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}