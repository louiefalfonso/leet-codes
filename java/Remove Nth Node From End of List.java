/*
 * Remove Nth Node From End of List - 19
 */

 // Definition for singly-linked list node.
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize the node without a next node
    ListNode() {
    }

    // Constructor to initialize the node with a value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor to initialize the node with a value and a next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    // Removes the nth node from the end of the list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that precedes the head of the list
        ListNode dummyNode = new ListNode(0, head);

        // Initialize two pointers, starting at the dummy node
        ListNode fastPointer = dummyNode;
        ListNode slowPointer = dummyNode;

        // Move the fast pointer n steps ahead
        while (n-- > 0) {
            fastPointer = fastPointer.next;
        }

        // Move both pointers until the fast pointer reaches the end of the list
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        // Skip the node that is nth from the end
        slowPointer.next = slowPointer.next.next;

        // Return the head of the modified list, which is the next node of dummy node
        return dummyNode.next;
    }
}
