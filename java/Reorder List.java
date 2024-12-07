/*
 * Reorder List - 143
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        // Step 1: Use two-pointers to find the middle of the linked list
        ListNode fastPointer = head, slowPointer = head;
        // fastPointer moves twice as fast as the slowPointer
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Step 2: Split the list into two and reverse the second half
        // Now, slowPointer is at the middle of the list
        ListNode current = slowPointer.next; // This is the start of the second half
        slowPointer.next = null; // Split the list into two

        ListNode previous = null;
        // Reverse the second half of the list
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        // Step 3: Merge the two halves back together
        current = head; // Reset current to the start of the first half

        // Traverse the first and the reversed second half together
        while (previous != null) {
            // 'previous' traverses the reversed list
            ListNode temp = previous.next;
            // Link the current node of the first half to the current node of the reversed
            // second half
            previous.next = current.next;
            // Link the current node of the reversed second half to the next node in the
            // first half
            current.next = previous;

            // Move to the next node in the first half
            current = previous.next;
            // Proceed to the next node in the reversed second half
            previous = temp;
        }
    }
}