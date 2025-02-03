// Reverse Linked List II - 92


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If the list only has one node or the left and right indices are the same,
        // there's nothing to reverse, so return the head as is.
        if (head.next == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify the handling of the head node.
        ListNode dummy = new ListNode(0, head);

        // Move the pre pointer to the node before the left index.
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; ++i) {
            pre = pre.next;
        }

        // Initialize pointers for the reversal process.
        ListNode p = pre; // The node before the left index.
        ListNode q = pre.next; // The node at the left index.
        ListNode cur = q; // The current node being processed.

        // Reverse the nodes between the left and right indices.
        for (int i = 0; i < right - left + 1; ++i) {
            // Store the next node in the list.
            ListNode t = cur.next;

            // Reverse the link of the current node.
            cur.next = pre;

            // Move the pre and cur pointers for the next iteration.
            pre = cur;
            cur = t;
        }

        // Re-link the nodes after the reversal.
        p.next = pre; // Link the node before the left index to the new first node.
        q.next = cur; // Link the last node of the reversed section to the rest of the list.

        // Return the head of the modified list (which is the next node of the dummy
        // node).
        return dummy.next;
    }
}