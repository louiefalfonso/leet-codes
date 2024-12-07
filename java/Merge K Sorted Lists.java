/*
 * Merge K Sorted Lists - 23
 */

 /**
 * Definition for singly-linked list.
 */

 import java.util.PriorityQueue;

 class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }

 class MergeKSortedLists {
     public ListNode mergeKLists(ListNode[] lists) {
         // Create a min-heap (priority queue)
         PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

         // Add the head of each list to the min-heap
         for (ListNode list : lists) {
             if (list != null) {
                 minHeap.offer(list);
             }
         }

         // Dummy head for the result list
         ListNode dummy = new ListNode(0);
         ListNode current = dummy;

         // While there are nodes in the min-heap
         while (!minHeap.isEmpty()) {
             // Get the smallest node
             ListNode smallestNode = minHeap.poll();
             current.next = smallestNode; // Add it to the merged list
             current = current.next; // Move the current pointer

             // If there is a next node, add it to the min-heap
             if (smallestNode.next != null) {
                 minHeap.offer(smallestNode.next);
             }
         }

         // Return the merged list, which starts from the next of dummy
         return dummy.next;
     }
 }
    