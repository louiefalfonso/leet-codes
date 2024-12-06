/*
 * Merge Two Sorted Lists - 21
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1; // Link the smaller node
                l1 = l1.next; // Move to the next node in l1
            } else {
                current.next = l2; // Link the smaller node
                l2 = l2.next; // Move to the next node in l2
            }
            current = current.next; // Move the current pointer
        }

        // If there are remaining nodes in either list, link them
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list, which starts from the next of the dummy node
        return dummy.next;
    }
}