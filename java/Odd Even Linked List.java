/*
 * Odd Even Linked List - 328
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // If the list is empty, return null.
        if (head == null) {
            return null;
        }

        // Initialize pointers for manipulation.
        // 'odd' points to the last node in the odd-indexed list.
        // 'even' points to the last node in the even-indexed list.
        // 'evenHead' points to the first node of the even-indexed list.
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Iterate over the list to rewire nodes.
        while (even != null && even.next != null) {
            // Link the next odd node.
            odd.next = even.next;
            // Move the 'odd' pointer to the next odd node.
            odd = odd.next;

            // Link the next even node.
            even.next = odd.next;
            // Move the 'even' pointer to the next even node.
            even = even.next;
        }

        // After reordering, attach the even-indexed list to the end of the odd-indexed
        // list.
        odd.next = evenHead;

        // Return the head of the modified list.
        return head;
    }
}
