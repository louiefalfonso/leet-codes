/*
 * Find Score of an Array After Marking All Elements - 2593
 */

 import java.util.List;
 import java.util.PriorityQueue;

 class Solution {
    public long findScore(int[] nums) {
        int length = nums.length;
        // Create an array to keep track of visited indices
        boolean[] visited = new boolean[length];
        // Create a priority queue to store the pairs of number and index,
        // sorted by the number value, and in case of a tie, by the index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Add all numbers along with their indices to the priority queue
        for (int i = 0; i < length; ++i) {
            priorityQueue.offer(new int[] { nums[i], i });
        }

        long totalScore = 0; // This will hold the final score

        // Process the queue until it's empty
        while (!priorityQueue.isEmpty()) {
            var currentPair = priorityQueue.poll(); // Get the pair with the smallest number
            totalScore += currentPair[0]; // Add the number to the score
            visited[currentPair[1]] = true; // Mark the index as visited

            // Visit the neighbors of the current index and mark them as visited
            for (int neighborIndex : List.of(currentPair[1] - 1, currentPair[1] + 1)) {
                if (neighborIndex >= 0 && neighborIndex < length) {
                    visited[neighborIndex] = true;
                }
            }

            // Discard all pairs from the queue where the index has been visited
            while (!priorityQueue.isEmpty() && visited[priorityQueue.peek()[1]]) {
                priorityQueue.poll();
            }
        }

        // Return the total score calculated
        return totalScore;
    }
}