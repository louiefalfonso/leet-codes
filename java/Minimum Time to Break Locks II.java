/*
 * Minimum Time to Break Locks II - 3385
 */

 import java.util.*;

class Solution {
    public int minimumTime(int[] locks) {
        
        // Sort the locks array to handle the locks in increasing order of time
        Arrays.sort(locks);

        int n = locks.length;
        int totalTime = 0;

        // We will use a priority queue to manage the locks we are currently breaking
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            // Add the current lock's breaking time to the priority queue
            pq.offer(locks[i]);

            // If we have more than 3 locks being broken, we need to finish one
            if (pq.size() > 3) {
                // Remove the lock that takes the least time to break
                totalTime += pq.poll();
            }
        }

        // Add the remaining locks' breaking times
        while (!pq.isEmpty()) {
            totalTime += pq.poll();
        }

        return totalTime;
    }

}