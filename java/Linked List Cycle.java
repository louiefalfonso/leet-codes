/*
 * Linked List Cycle - 141
 */

 /**
 * Definition for singly-linked list.
 */
class ListNode {
    int value; // The value of the node.
    ListNode next; // Reference to the next node in the list.

    // Constructor to initialize the node with a specific value.
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class Solution {
    /**
     * Detects if there is a cycle in the linked list.
     * 
     * @param head The head of the singly-linked list.
     * @return true if there is a cycle, false otherwise.
     */
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers, the slow pointer moves one step at a time.
        ListNode slow = head;
        // The fast pointer moves two steps at a time.
        ListNode fast = head;

        // Keep traversing the list as long as the fast pointer and its next are not
        // null.
        while (fast != null && fast.next != null) {
            // Move the slow pointer one step.
            slow = slow.next;
            // Move the fast pointer two steps.
            fast = fast.next.next;

            // If the slow and fast pointers meet, a cycle exists.
            if (slow == fast) {
                return true;
            }
        }
        // If the loop ends without the pointers meeting, there is no cycle.
        return false;
    }
}