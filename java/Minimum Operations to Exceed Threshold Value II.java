// Minimum Operations to Exceed Threshold Value II - 3066
import java.util.PriorityQueue;

class Solution {
    
     // Returns the minimum number of operations required to make all elements in the
     // array greater than or equal to k.
    
    public int minOperations(int[] nums, int k) {
        // Create a priority queue to store the elements of the array
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // Add all elements to the priority queue
        for (int x : nums) {
            pq.offer((long) x);
        }
        // Initialize the answer (number of operations)
        int ans = 0;

        // Continue until there is only one element left in the queue or the smallest
        // element is greater than or equal to k
        for (; pq.size() > 1 && pq.peek() < k; ++ans) {
            // Remove the two smallest elements from the queue
            long x = pq.poll(), y = pq.poll();
            // Combine the two elements by multiplying the smaller one by 2 and adding the
            // larger one, and add the result back to the queue
            pq.offer(x * 2 + y);
        }
        // Return the minimum number of operations required
        return ans;
    }
}