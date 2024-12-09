/*
 * Delete the Middle Node of a Linked List - 2095
 */

 // Definition of a singly-linked list node.
class ListNode {
    int value;
    ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Create a dummy node that acts as a predecessor of the head node.
        ListNode dummy = new ListNode(0, head);
        // Initialize two pointers, slow and fast. Slow moves 1 node at a time, while
        // fast moves 2 nodes.
        ListNode slow = dummy, fast = head;

        // Iterate through the list with the fast pointer advancing twice as fast as the
        // slow pointer
        // so that when the fast pointer reaches the end, the slow pointer will be at
        // the middle.
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step.
            fast = fast.next.next; // Move fast pointer two steps.
        }

        // Skip the middle node. Slow pointer now points to the node before the middle
        // node.
        slow.next = slow.next.next;

        // Return the modified list. The dummy's next points to the new list's head.
        return dummy.next;
    }
}