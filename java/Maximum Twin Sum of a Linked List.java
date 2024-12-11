/*
 * Maximum Twin Sum of a Linked List - 2130
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
    // Function to find the maximum Twin Sum in a singly-linked list
    public int pairSum(ListNode head) {
        // Initialize two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head.next;

        // Use fast and slow pointers to find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow pointer one step
            fast = fast.next.next; // move fast pointer two steps
        }

        // After the loop, slow will be at the middle of the list
        // The next step is to reverse the second half of the linked list
        ListNode firstHalf = head; // Start of the first half
        ListNode secondHalfStart = slow.next; // Start of the second half
        slow.next = null; // Split the list into two halves
        ListNode reversedSecondHalf = reverse(secondHalfStart); // Reverse the second half

        // Initialize the maximum sum variable
        int maxSum = 0;

        // Traverse the two halves together
        while (firstHalf != null) {
            // Update the maximum sum using sums of pairs (firstHalf value and
            // reversedSecondHalf value)
            maxSum = Math.max(maxSum, firstHalf.val + reversedSecondHalf.val);
            firstHalf = firstHalf.next; // Move to the next node in the first half
            reversedSecondHalf = reversedSecondHalf.next; // Move to the next node in the reversed second half
        }

        // Return the maximum sum found
        return maxSum;
    }

    // Helper function to reverse a singly-linked list
    private ListNode reverse(ListNode head) {
        // Initialize a dummy node to help with the reversal
        ListNode dummy = new ListNode();

        // Traverse the list and reverse pointers
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next; // Keep the reference to the next node
            current.next = dummy.next; // Reverse the pointer
            dummy.next = current; // Move dummy next to the current node
            current = next; // Move to the next node
        }

        // Return the reversed list, which starts at dummy.next
        return dummy.next;
    }
}