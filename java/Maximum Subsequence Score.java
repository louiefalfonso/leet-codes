/*
 * Maximum Subsequence Score - 2542
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // Get the length of the given arrays
        int n = nums1.length;
        // Initialize an array of arrays to hold pairs from nums1 and nums2
        int[][] numsPairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            numsPairs[i] = new int[] { nums1[i], nums2[i] };
        }

        // Sort the pairs based on the second element in decreasing order
        Arrays.sort(numsPairs, (a, b) -> b[1] - a[1]);

        long maxScore = 0; // This will hold the maximum score
        long sum = 0; // This will hold the sum of the smallest 'k' elements from nums1
        // PriorityQueue to hold the smallest 'k' elements from nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            sum += numsPairs[i][0]; // Add the value from nums1
            minHeap.offer(numsPairs[i][0]); // Add value to the min heap

            if (minHeap.size() == k) { // If we have 'k' elements in the min heap
                // Calculate potential score for the current combination and update maxScore if
                // it's higher
                maxScore = Math.max(maxScore, sum * numsPairs[i][1]);
                // Remove the smallest value to make room for the next iteration
                sum -= minHeap.poll();
            }
        }
        // Return the calculated max score
        return maxScore;
    }
}
